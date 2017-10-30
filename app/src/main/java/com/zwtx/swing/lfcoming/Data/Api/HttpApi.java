package com.zwtx.swing.lfcoming.Data.Api;

/**
 *
 * 存储网络请求的接口
 */

public interface HttpApi {

    //主域名
    String ROOT_PATH = "http://192.168.16.193:8080/SpringMVC/HelloController/";
    /*login check authToken*/
    String AUTHTOKEN = "authToken";
    /*timestamp 时间戳*/
    String STAMPTOKEN = "stampToken";
    /*校验标识*/
    String CHECKTOKEN = "sign";
    //注册
    String REGISTER="allmregister";
    //获取雷锋号
    String GETLFNUM="lefengnum";
    //登录
    String LOGIN="login";
    //启动页
    String GUIDE="dynamic";
    //修改密码
    String SETTING_PWD="xgpwd";
    //新闻轮播
    String NEWS_GUIDE="carouse";
    //雷锋动态新闻
    String LF_NEW="hdope";
    //我学雷锋
    String MY_STUDY_LF="skill";
    //个人信息
    String PERSONAL="improve_personal";
    /**
     * 最新求助
     */
    String HELP_PEOPLE="help_people";
    /**
     * 事实新闻
     */
    String NEWS="current_affair";
    /**
     * 评论
     */
    String COMMENT="comment";
    /**
     * 提交评论
     */
    String USER_COMMENT="user_comment";

    /**
     * 雷锋榜
     */
    String LFB="billboard";
    /**
     * 发布活动
     */
    String SEND_ACTIVITY="release_activity";


    String KEY_REQUEST = "b6r9x3u8a6q5k1v7";



}
