package com.zwtx.swing.lfcoming.MVP.Entity;

import java.util.List;

/**
 * Created by SuperSow
 */

public class UserInfo {


    /**
     * code : 1
     * msg : 登录成功
     * data : [{"madress":"北京","mcard_id":"","mleifennum":"6000000","mnane":"3433","mphone":"1362977063","mpictureurl":"abc.PNG","msex":"男"}]
     */

    private String code;
    private String msg;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * madress : 北京
         * mcard_id :
         * mleifennum : 6000000
         * mnane : 3433
         * mphone : 1362977063
         * mpictureurl : abc.PNG
         * msex : 男
         */

        private String madress;
        private String mcard_id;
        private String mleifennum;
        private String mnane;
        private String mphone;
        private String mpictureurl;
        private String msex;

        public String getMadress() {
            return madress;
        }

        public void setMadress(String madress) {
            this.madress = madress;
        }

        public String getMcard_id() {
            return mcard_id;
        }

        public void setMcard_id(String mcard_id) {
            this.mcard_id = mcard_id;
        }

        public String getMleifennum() {
            return mleifennum;
        }

        public void setMleifennum(String mleifennum) {
            this.mleifennum = mleifennum;
        }

        public String getMnane() {
            return mnane;
        }

        public void setMnane(String mnane) {
            this.mnane = mnane;
        }

        public String getMphone() {
            return mphone;
        }

        public void setMphone(String mphone) {
            this.mphone = mphone;
        }

        public String getMpictureurl() {
            return mpictureurl;
        }

        public void setMpictureurl(String mpictureurl) {
            this.mpictureurl = mpictureurl;
        }

        public String getMsex() {
            return msex;
        }

        public void setMsex(String msex) {
            this.msex = msex;
        }
    }
}
