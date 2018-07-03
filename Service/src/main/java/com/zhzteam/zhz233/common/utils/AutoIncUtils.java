package com.zhzteam.zhz233.common.utils;

public class AutoIncUtils{

    /**
     * 生成 认证 自增No
     * @param oldNo
     * @return
     */
    public static String getCertificationNo(String oldNo){
        Long autoNo = 1L;
        String autoDT = DateTimeUtils.getPatternY();
        if(oldNo != null && !oldNo.isEmpty() && !oldNo.equals("")) {
            if(autoDT.equals(oldNo.substring(0, 4))) {
                autoNo = Long.parseLong(oldNo.substring(5, 12)) + 1;
            }
        }
        return autoDT + String.format("%08d", autoNo);
    }
    /**
     * 获取 文件 自增 ID
     * @param oldNo
     * @return
     */
    public static String getFileURLNo(String oldNo){
        Long autoNo = 1L;
        String autoDT = DateTimeUtils.getPatternYMD();
        if(oldNo != null && !oldNo.isEmpty() && !oldNo.equals("")) {
            if(autoDT.equals(oldNo.substring(0, 8))) {
                autoNo = Long.parseLong(oldNo.substring(9, 16)) + 1;
            }
        }
        return autoDT + String.format("%08d", autoNo);
    }

    /**
     * 20180520 00 0000 0000 0001 充值 记录 详情
     * @param oldNo
     * @return
     */
    public static String getRechargeOrderNo(String oldNo){
        Long autoNo = 1L;
        String autoDT = DateTimeUtils.getPatternYMD();
        if(oldNo != null && !oldNo.isEmpty() && !oldNo.equals("")) {
            if(autoDT.equals(oldNo.substring(0, 8))) {
                autoNo = Long.parseLong(oldNo.substring(11, 22)) + 1;
            }
        }
        return autoDT + "01" +String.format("%012d", autoNo);
    }

    /**
     * 20180520 00 0000 0000 0001 资金 记录 详情
     * @param oldNo
     * @return
     */
    public static String getInvlaOrderNo(String oldNo){
        Long autoNo = 1L;
        String autoDT = DateTimeUtils.getPatternYMD();
        if(oldNo != null && !oldNo.isEmpty() && !oldNo.equals("")) {
            if(autoDT.equals(oldNo.substring(0, 8))) {
                autoNo = Long.parseLong(oldNo.substring(11, 22)) + 1;
            }
        }
        return autoDT + "00" +String.format("%012d", autoNo);
    }
    /**
     * 20180404 03 0000 0000 0001 出租订单编号
     * @param oldNo
     * @return
     */
    public static String getLeaseOrderNo(String oldNo){
        Long autoNo = 1L;
        String autoDT = DateTimeUtils.getPatternYMD();
        if(oldNo != null && !oldNo.isEmpty() && !oldNo.equals("")) {
            if(autoDT.equals(oldNo.substring(0, 8))) {
                autoNo = Long.parseLong(oldNo.substring(11, 22)) + 1;
            }
        }
        return autoDT + "03" +String.format("%012d", autoNo);
    }
    /**
     * 生成自增No
     * @param oldNo
     * @return
     */
    public static String getAccountNo(String oldNo){
        Long autoNo = 1L;
        String autoDT = DateTimeUtils.getPatternY();
        if(oldNo != null && !oldNo.isEmpty() && !oldNo.equals("")) {
            if(autoDT.equals(oldNo.substring(0, 4))) {
                autoNo = Long.parseLong(oldNo.substring(5, 12)) + 1;
            }
        }
        return autoDT + String.format("%08d", autoNo);
    }
}
