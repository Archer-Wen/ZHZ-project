package com.zhzteam.zhz233.controller.wlh;

import com.zhzteam.zhz233.model.BBSModel;
import com.zhzteam.zhz233.model.ReplyModel;
import com.zhzteam.zhz233.model.UserModel;
import com.zhzteam.zhz233.model.wlh.ShowBBSView;
import com.zhzteam.zhz233.model.wlh.ShowReplyView;
import com.zhzteam.zhz233.service.wlh.PCBBSService;
import com.zhzteam.zhz233.service.wlh.PCBoardService;
import com.zhzteam.zhz233.service.wlh.PCReplyService;
import com.zhzteam.zhz233.service.wlh.PCUserService;
import com.zhzteam.zhz233.service.zlb.RedisService;
import com.zhzteam.zhz233.service.zlb.impl.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/23
 */
@RestController
@RequestMapping(value = "/wlh")
public class PCBBSControlleer {
    @Autowired
    PCBBSService bbsService;
    @Autowired
    RedisServiceImpl redisService;
    @Autowired
    PCUserService userService;
    @Autowired
    PCReplyService replyService;
    @Autowired
    PCBoardService boardService;

    @ResponseBody
    @RequestMapping(value = "/showBBS")
    public Object showBBS(HttpServletRequest request, HttpServletResponse response, Integer board_id){
        if (board_id == null){
            return "板块错误";
        }
        List<ShowBBSView> bbsViews = bbsService.ShowBBS(board_id);
        if (bbsViews.size() == 0){
            return "无更多内容";
        }
        return bbsViews;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteBBS")
    public Object deleteBBS(HttpServletRequest request, HttpServletResponse response,String userName,String session,Integer bbsId){
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(session)){
            return "请登陆后操作！";
        }
        if(bbsId == null){
            return "帖子选择出错！";
        }
        String redisUser = (String) redisService.select(session);
        if (!redisUser.equals(userName)){
            return "请登陆正确的用户";
        }
        UserModel userPojo = userService.selectByAccount(userName);
        if (userPojo == null){
            return "无此用户信息！";
        }
        if(userPojo.getAccess() <= 1){
            return "您没有权限！";
        }
        //删除操作
        BBSModel bbsModel = bbsService.findOne(bbsId);
        boolean issuccess = bbsService.deleteBBS(bbsId);
        Integer count = replyService.CountByBBSId(bbsId);
        if (issuccess){
            if (count > 0) {//有回帖
                boolean issuccess2 = replyService.deleteReplyByBBSId(bbsId);
                if (issuccess2) {
                    return "删除成功！";
                }else{
                    Integer flag = bbsService.insertOne(bbsModel);
                    if (flag == null){
                        return "系统错误，回帖未删除！";
                    }
                    return "删除失败！";
                }
            }else{//无回帖
                return "删除成功！";
            }
        }
        return "删除失败！";
    }

    @ResponseBody
    @RequestMapping(value = "/writeBBS")
    public Object writeBBS(HttpServletRequest request, HttpServletResponse response,
                           String userName,String session,String title,String count,String board){
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(session)){
            return "请登陆后操作！";
        }
        String redisUser = (String) redisService.select(session);
        if (!redisUser.equals(userName)){
            return "请登陆正确的用户";
        }
        UserModel userPojo = userService.selectByAccount(userName);
        if (userPojo == null){
            return "无此用户信息！";
        }

        BBSModel bbsModel = new BBSModel();
        Map<Object,Object> boardMap = boardService.selectByName(board);

        bbsModel.setAccount_no(userPojo.getAccount_no());
        bbsModel.setBbs_count(count);
        bbsModel.setBbs_title(title);
        bbsModel.setBoard_id(Integer.valueOf(boardMap.get("id").toString()));
        bbsModel.setCreatetime(LocalDateTime.now());
        bbsModel.setUpdatetime(LocalDateTime.now());
        Integer flag = bbsService.insertOne(bbsModel);
        if (flag == null){
            return "添加失败";
        }
        return "添加成功";
    }

    @ResponseBody
    @RequestMapping(value = "/showOneBBS")
    public Object showOneBBS(HttpServletRequest request, HttpServletResponse response,
                             String userName,String session,Integer bbs_id){
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(session)){
            return "请登陆后操作！";
        }
        String redisUser = (String) redisService.select(session);
        if (!redisUser.equals(userName)){
            return "请登陆正确的用户";
        }
        UserModel userPojo = userService.selectByAccount(userName);
        if (userPojo == null){
            return "无此用户信息！";
        }
        if (bbs_id == null){
            return "系统错误！";
        }
        ShowBBSView bbsView = bbsService.showOneBBS(bbs_id);
        if (bbsView == null){
            return "找不到帖子";
        }
        return bbsView;
    }

    @ResponseBody
    @RequestMapping(value = "/showReply")
    public Object showReply(HttpServletRequest request, HttpServletResponse response,Integer bbs_id){
        if (bbs_id == null){
            return "系统错误！";
        }
        List<ShowReplyView> replyView = replyService.ShowReply(bbs_id);
        if (replyView == null){
            return "找不到回复";
        }
        return replyView;
    }

    @ResponseBody
    @RequestMapping(value = "/writeReply")
    public Object writeReply(HttpServletResponse response,HttpServletRequest request,
                             String sessionId,String userName,Integer bbsId,String count){
        if (sessionId==null || StringUtils.isEmpty(userName)){
            return "访问错误！";
        }
        if(!redisService.exist(sessionId.toString())){
            return "访问错误！";
        }
        UserModel user = userService.selectByAccount(userName);
        if (bbsId==null || StringUtils.isEmpty(count)){
            return "添加失败！";
        }
        String userNo = user.getAccount_no();
        Integer flag = replyService.insertReply(userNo,bbsId,count);
        if (flag == null){
            return "添加失败！";
        }
        return "添加成功！";
    }
}
