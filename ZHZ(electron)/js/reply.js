$(document).ready(function(){
	$(function(){
		
		initBBS();
		initTable();
		getReply();
		localStorage.removeItem("bbsId");
	})
	
	$("#show-writeReply").click(function(){
		$("#writeReply").modal('show');
		$("#bbsTitle").val(null);
		$(".note-editor .note-editing-area .note-editable").html(null);
		$('#summernote').summernote({ 
        height: 200, 
        tabsize: 2, 
        lang: 'zh-CN' 
    	});
	});
	
	$("#Reply-btn").click(function(){
		writeReply();
	});
	
	function initTable(){
		$('#reply-table').bootstrapTable({
			//url: 'json/user.json',
			method:  'get',						//服务器数据的请求方式 'get' 或 'post'。
			striped: true,
			//classes:  'table-no-bordered',	//删除表格的边框样式。
			sortName: 'endtime',				//定义排序列，通过url方式获取数据填写字段名，否则填写下标。
			sortOrder: 'asc',					//定义排序方式，'asc' 或者 'desc'。
			cache: true,						//设置为 false 禁用 AJAX 数据缓存。
			pagination: true,					//设置为 true 会在表格底部显示分页条。
			paginationLoop: false,				//设置为 true 启用分页条无限循环的功能。
			onlyInfoPagination: false,			//设置为 true 只显示总数据数，而不显示分页按钮。需要设置 pagination='true'。
			sidePagination: 'client',			//设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置服务器数据地址（url）或者重写ajax方法。
			pageNumber: 1,						//如果设置了分页，首页页码。
			pageSize: 5,						//如果设置了分页，页面数据条数。
			pageList: [5],						//如果设置了分页，设置可供选择的页面数据条数。设置为 All 或者 Unlimited，则显示所有记录。
			search: false,						//是否启用搜索框。
			searchOnEnterKey: false,				//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法。
			strictSearch: false,				//设置为 true启用全匹配搜索，否则为模糊搜索。
			showHeader: false,					//是否显示列头。
			
		    columns: [{
		    	field: 'no',
	    		title: '回复',
	    		//width: '25%',
	    		//align: 'center',				//指示如何排列列数据。'left'、'right'、'center'可以使用。
	    		//valign: 'middle',				//指示如何排列单元格数据。'top', 'middle', 'bottom' 可以使用。
		    	//halign: 'center',					//指示如何对齐表格标题。'left'、'right'、'center'可以使用。
		    	searchable: true,				//指示列是否可以被搜索
		    }],
//		    data: [{
//		    	no: '<div id="reply-body">'+
//					'<div id="reply-head" class="title">'+
//						'<p><span>wenliheng</span>'+
//						'<span class="pull-right">1#</span></p>'+
//					'</div>'+
//					'<div id="reply-cont" class="clearfix">'+
//						'生成tr的时候带上跳转地址，拿JQ来说，tr.click 执行 window.location.href = “你要跳转的地址”'+
//					'</div>'+
//					'<div id="reply-footer">'+
//						'<span class="text-color-999 pull-right">2018.5.14</span>'+
//					'</div>'+
//				'</div>'},{
//		    	no: '<div id="reply-body">'+
//					'<div id="reply-head" class="title">'+
//						'<p><span>wenliheng</span>'+
//						'<span class="pull-right">1#</span></p>'+
//					'</div>'+
//					'<div id="reply-cont" class="clearfix">'+
//						'生成tr的时候带上跳转地址，拿JQ来说，tr.click 执行 window.location.href = “你要跳转的地址”'+
//					'</div>'+
//					'<div id="reply-footer">'+
//						'<span class="text-color-999 pull-right">2018.5.14</span>'+
//					'</div>'+
//				'</div>'},{
//		    	no: '<div id="reply-body">'+
//					'<div id="reply-head" class="title">'+
//						'<p><span>wenliheng</span>'+
//						'<span class="pull-right">1#</span></p>'+
//					'</div>'+
//					'<div id="reply-cont" class="clearfix">'+
//						'生成tr的时候带上跳转地址，拿JQ来说，tr.click 执行 window.location.href = “你要跳转的地址”'+
//					'</div>'+
//					'<div id="reply-footer">'+
//						'<span class="text-color-999 pull-right">2018.5.14</span>'+
//					'</div>'+
//				'</div>'},{
//		    	no: '<div id="reply-body">'+
//					'<div id="reply-head" class="title">'+
//						'<p><span>wenliheng</span>'+
//						'<span class="pull-right">1#</span></p>'+
//					'</div>'+
//					'<div id="reply-cont" class="clearfix">'+
//						'生成tr的时候带上跳转地址，拿JQ来说，tr.click 执行 window.location.href = “你要跳转的地址”'+
//					'</div>'+
//					'<div id="reply-footer">'+
//						'<span class="text-color-999 pull-right">2018.5.14</span>'+
//					'</div>'+
//				'</div>'},
//		    ]
		});
	};//creat-table end
});

function getReply(){
	var bbs_id = localStorage.getItem("bbsId");
	var pushdata = {'bbs_id':bbs_id};
	$.ajax({
		type:"get",
		url:"http://localhost:8080/wlh/showReply",
		async:true,
		cache:false,
		dateType:"json",
		data: pushdata,
		success: function (result) {
			if(result=='系统错误！' || result=='找不到回复'){
				$("#modal_message").html(result);
				$("#my-modal-alert").modal('show');
				return;
			}else{
				var row = [];
				$.each(result, function(i,item) {
					var strs = item.create_time.split("T");
					row.push({
						no: '<div id="reply-body">'+
						'<div id="reply-head" class="title">'+
						'<p><span style="display: none;">'+item.id+'</span><span>'+item.account+'</span>'+
						'<span class="pull-right">'+i+'#</span></p>'+
						'</div>'+
						'<div id="reply-cont" class="clearfix">'+item.reply_count+
						'</div>'+
						'<div id="reply-footer">'+
						'<span class="text-color-999 pull-right">'+strs[0]+' '+strs[1]+'</span>'+
						'</div>'+
						'</div>'
					});
				});
				$('#reply-table').bootstrapTable('load',row);
			}
		}, error: function(XMLHttpRequest) {
			var tem = JSON.parse(XMLHttpRequest.responseText);
			$("#modal_message").html(tem.message);
			$("#my-modal-alert").modal('show');
			return;
		}
	});
	
}
function initBBS(){
	var endtime = localStorage.getItem("endtime");
	if(new Date().getTime() - endtime > 0){
		rootzuxiao();
	}
	var bbs_id = localStorage.getItem("bbsId");
	var session_id = localStorage.getItem("session");
	var user_name = localStorage.getItem("username");
	if(session_id==null || user_name==null || bbs_id==null){
		window.location.href="bbs.html";
	}
	var pushdata = {'bbs_id':bbs_id,'userName':user_name,'session':session_id};
	$.ajax({
		type:"get",
		url:"http://localhost:8080/wlh/showOneBBS",
		async:true,
		cache:false,
		dateType:"json",
		data: pushdata,
		success: function (result) {
			if(result=='请登陆后操作！' || result=='请登陆正确的用户' || result=='无此用户信息！' || result=='系统错误！' || result=='找不到帖子'){
				$("#modal_message").html(result);
				$("#my-modal-alert").modal('show');
				return;
			}else{
				var strs = result.createtime.split("T");
				$("#bbs-id").html(result.bbs_id);
				$("#bbs-board").html(result.board_name);
				$("#bbs-account").html(result.account + ' • 发起');
				$("#bbs-cont h1").html(result.bbs_title);
				$("#bbs-cont .mod-body .content").html(result.bbs_count);
				$("#bbs-cont .mod-footer #creat-time").html(strs[0] + ' ' + strs[1]);
			}
		}, error: function(XMLHttpRequest) {
			var tem = JSON.parse(XMLHttpRequest.responseText);
			$("#modal_message").html(tem.message);
			$("#my-modal-alert").modal('show');
			return;
		}
	});
}

function writeReply(){
	var endtime = localStorage.getItem("endtime");
	if(new Date().getTime() - endtime > 0){
		rootzuxiao();
		$("#modal_message").html("用户信息失效！");
		$("#my-modal-alert").modal('show');
		return;
	}
	var session_id = localStorage.getItem("session");
	var user_name = localStorage.getItem("username");
	var bbs_id = $("#bbs-id").html();
	var count = $(".note-editor .note-editing-area .note-editable").html();
	var pushJson = {'sessionId':session_id,'userName':user_name,'bbsId':bbs_id,'count':count};
	$.ajax({
		type:"get",
		url:"http://localhost:8080/wlh/writeReply",
		async:true,
		cache:false,
		dateType:"json",
		data: pushJson,
		success: function (result) {
			$("#writeReply").modal('hide');
			localStorage.setItem("bbsId",$("#bbs-id").html());
			getReply();
		}, error: function(XMLHttpRequest) {
			var tem = JSON.parse(XMLHttpRequest.responseText);
			$("#modal_message").html(tem.message);
			$("#my-modal-alert").modal('show');
			return;
		}
	});
	
};
