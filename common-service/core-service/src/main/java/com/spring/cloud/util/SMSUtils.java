package com.spring.cloud.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 短信通工具
 */
@Component
public class SMSUtils {

    private static final String URL = "sms.url";
    private static final String CONTENT_TYPE = "application/x-www-form-urlencoded;charset=gbk";
    private static final String UID = "sms.Uid";//本站用户名
    private static final String KEY = "sms.Key";//接口安全密钥
    private static final String SMS_TEXT = "【项目名称】您的验证码：";//短信签名
    /**
     * 短信发送
     * @param smsMob 发送的目标手机号
     * @param validateCode 验证码   注意:携带签名
     * @throws Exception
     */
    public String send(String smsMob,String validateCode){
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod(URL);
        String result = null;
        try {
            post.addRequestHeader("Content-Type",CONTENT_TYPE);//在头文件中设置转码
            NameValuePair[] data =  {
                    new NameValuePair("Uid", UID),
                    new NameValuePair("Key", KEY),
                    new NameValuePair("smsMob",smsMob),//手机号
                    new NameValuePair("smsText",SMS_TEXT+validateCode)};//验证码
            post.setRequestBody(data);

            client.executeMethod(post);//发送
            result = new String(post.getResponseBodyAsString().getBytes("gbk"));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            post.releaseConnection();
        }
        return Msg.getContent(Integer.valueOf(result));
    }
}

//错误类别枚举类
enum Msg{
    SUCCESS_1(1,"发送成功"),
    ERROR_1(-1,"没有该用户账户"),
    ERROR_2(-2,"接口密钥不正确"),
    ERROR_3(-3,"短信数量不足"),
    ERROR_4(-4,"手机号格式不正确"),
    ERROR_21(-21,"MD5接口密钥加密不正确"),
    ERROR_11(-11,"该用户被禁用"),
    ERROR_14(-14,"短信内容出现非法字符"),
    ERROR_41(-41,"手机号为空"),
    ERROR_42(-42,"短信内容为空"),
    ERROR_51(-51,"短信签名格式不对"),
    ERROR_6(-6,"IP限制"),
    ;

    private int statusCode;//错误状态码
    private String errorContent;//错误内容

    Msg(int  statusCode ,String errorContent){
        this.statusCode = statusCode;
        this.errorContent = errorContent;
    }

    Msg(int  statusCode){
        this.statusCode = statusCode;
    }

    int getStatusCode(){
        return statusCode;
    }

    String getErrorContent(){
        return errorContent;
    }

    public static String getContent(int statusCode){
        for (Msg errorMsg: Msg.values()) {
            if(errorMsg.getStatusCode() == statusCode){
                return errorMsg.getErrorContent();
            }
        }
        return Msg.SUCCESS_1.getErrorContent();
    }
}