package com.fhj.elventree.constant;

public class Const {
    /**
     * 交易状态(_state字段)
     */
    public static class TransState {
        /**
         * 成功
         */
        public static final String SUCCESS = "SUCCESS";
        /**
         * 失败
         */
        public static final String FAILED = "FAILED";
    }

    /**
     * 交易保留字段
     */
    public static class DefaultCol {
        /**交易状态*/
        public static final String _STATE = "_state";
        /**错误提示信息*/
        public static final String _ERRORMSG = "_errorMsg";
    }
}
