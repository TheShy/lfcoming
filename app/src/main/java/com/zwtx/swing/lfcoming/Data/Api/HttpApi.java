package com.zwtx.swing.lfcoming.Data.Api;

/**
 *
 * 存储网络请求的接口
 */

public interface HttpApi {

    /**
     * 主域名部分
     */
    String ROOT_PATH = "http://192.168.16.193:8080/SpringMVC/HelloController/";
    /**
     * 获取短信验证码
     */
    String USER_SEND_MESSAGE = "api/hd/user/send_msg.php";
    String AUTHTOKEN = "authToken";
    /*timestamp 时间戳*/
    String STAMPTOKEN = "stampToken";
    /*校验标识*/
    String CHECKTOKEN = "sign";
    String KEY_REQUEST = "b6r9x3u8a6q5k1v7";
    //登录
    String Login="login";
}
