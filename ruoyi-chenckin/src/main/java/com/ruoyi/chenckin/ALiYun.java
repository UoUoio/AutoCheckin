package com.ruoyi.chenckin;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

/**
 * @author:
 * @Date: 2023-02-08 11:16
 * @Description: < 描述 >
 */
public class ALiYun {
    public static void main(String[] args) {
        // 使用hutool创建post请求,并设置请求头内容
        HttpRequest post = HttpRequest.post("https://member.aliyundrive.com/v1/activity/sign_in_list");
        post.header("Host", "member.aliyundrive.com")
                .header("Accept", "application/json, text/plain, */*")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI1MTRkNmRlZmIxMWU0ODQyOTg5ODVjZjFiNDkwMTU5NCIsImN1c3RvbUpzb24iOiJ7XCJjbGllbnRJZFwiOlwicEpaSW5OSE4yZFpXazhxZ1wiLFwiZG9tYWluSWRcIjpcImJqMjlcIixcInNjb3BlXCI6W1wiRFJJVkUuQUxMXCIsXCJGSUxFLkFMTFwiLFwiVklFVy5BTExcIixcIlNIQVJFLkFMTFwiLFwiU1RPUkFHRS5BTExcIixcIlNUT1JBR0VGSUxFLkxJU1RcIixcIlVTRVIuQUxMXCIsXCJCQVRDSFwiLFwiQUNDT1VOVC5BTExcIixcIklNQUdFLkFMTFwiLFwiSU5WSVRFLkFMTFwiLFwiU1lOQ01BUFBJTkcuTElTVFwiXSxcInJvbGVcIjpcInVzZXJcIixcInJlZlwiOlwiXCIsXCJkZXZpY2VfaWRcIjpcIjI5YWFmZmQxNWY4ZDQ1OTc5MjJjYWUxYWExNjg5N2NkXCJ9IiwiZXhwIjoxNjc1ODQxMzg0LCJpYXQiOjE2NzU4MzQxMjR9.iUSYealCuT98jCAevaf1f54MSDeT7byIHNvDzUrCJ1dldPfgAZUIA2TYhG_c5Hr1dpNZEPS6GKDnDT-Y_EImhvqow7DOOgqNAysp03hWYNCJ6WJ0lb17SWqfjGXsuKOKyHg6swfAChel6HfJXFZdTLtmR0ETk-l95J3mf-p5DwE");
        post.body("{}");

        String body = post.execute().body();
        System.out.println(body);

    }




    /** public static void main(String[] args) {
        // 使用hutool创建post请求,并设置请求头内容
        HttpRequest post = HttpRequest.post("https://member.aliyundrive.com/v1/activity/sign_in_list");
        // HttpRequest post = HttpRequest.post("https://api.aliyundrive.com/adrive/v1/dailyCheckin/getConfig");

        post.header("Host", "member.aliyundrive.com")
                // .header("Accept", "application/json, text/plain, ")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI1MTRkNmRlZmIxMWU0ODQyOTg5ODVjZjFiNDkwMTU5NCIsImN1c3RvbUpzb24iOiJ7XCJjbGllbnRJZFwiOlwicEpaSW5OSE4yZFpXazhxZ1wiLFwiZG9tYWluSWRcIjpcImJqMjlcIixcInNjb3BlXCI6W1wiRFJJVkUuQUxMXCIsXCJGSUxFLkFMTFwiLFwiVklFVy5BTExcIixcIlNIQVJFLkFMTFwiLFwiU1RPUkFHRS5BTExcIixcIlNUT1JBR0VGSUxFLkxJU1RcIixcIlVTRVIuQUxMXCIsXCJCQVRDSFwiLFwiQUNDT1VOVC5BTExcIixcIklNQUdFLkFMTFwiLFwiSU5WSVRFLkFMTFwiLFwiU1lOQ01BUFBJTkcuTElTVFwiXSxcInJvbGVcIjpcInVzZXJcIixcInJlZlwiOlwiXCIsXCJkZXZpY2VfaWRcIjpcIjI5YWFmZmQxNWY4ZDQ1OTc5MjJjYWUxYWExNjg5N2NkXCJ9IiwiZXhwIjoxNjc1ODQxMzg0LCJpYXQiOjE2NzU4MzQxMjR9.iUSYealCuT98jCAevaf1f54MSDeT7byIHNvDzUrCJ1dldPfgAZUIA2TYhG_c5Hr1dpNZEPS6GKDnDT-Y_EImhvqow7DOOgqNAysp03hWYNCJ6WJ0lb17SWqfjGXsuKOKyHg6swfAChel6HfJXFZdTLtmR0ETk-l95J3mf-p5DwE")


                .header("X-Canary", "client=web,app=other,version=v0.1.0")
                .header("x-umt", "defaultFY1_fyjs_not_loaded@@https://pages.aliyundrive.com/mobile-page/web/dailycheck.html@@1675822110242")
                .header("Accept-Language", "zh-CN,zh-Hans;q=0.9")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Content-Type", "application/json")
                .header("Origin", "https://pages.aliyundrive.com")
                .header("x-ua", "defaultFY1_fyjs_not_loaded@@https://pages.aliyundrive.com/mobile-page/web/dailycheck.html@@1675822110242")
                .header("Content-Length", "2")
                .header("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 16_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/20D47 iOS16.3 (iPhone14,3;zh-Hans-US) App/4.1.1 AliApp(yunpan/4.1.1) com.alicloud.smartdrive/28070909  Channel/201200 AliApp(AYSD/4.1.1) com.alicloud.smartdrive/4.1.1 Version/16.3 Channel/201200 Language/zh-Hans-US /iOS Mobile/iPhone14,3 language/zh-Hans-US")
                .header("Referer", "https://pages.aliyundrive.com/")
                .header("Connection", "keep-alive");
        post.body("{}");

        String body = post.execute().body();
        System.out.println(body);

    }
    */
}
         // .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI0YTEzNDgyMDliZWQ0MDU2YWM1YTViZDhjZTAzZjYyMiIsImN1c3RvbUpzb24iOiJ7XCJjbGllbnRJZFwiOlwicEpaSW5OSE4yZFpXazhxZ1wiLFwiZG9tYWluSWRcIjpcImJqMjlcIixcInNjb3BlXCI6W1wiRFJJVkUuQUxMXCIsXCJGSUxFLkFMTFwiLFwiVklFVy5BTExcIixcIlNIQVJFLkFMTFwiLFwiU1RPUkFHRS5BTExcIixcIlNUT1JBR0VGSUxFLkxJU1RcIixcIlVTRVIuQUxMXCIsXCJCQVRDSFwiLFwiQUNDT1VOVC5BTExcIixcIklNQUdFLkFMTFwiLFwiSU5WSVRFLkFMTFwiLFwiU1lOQ01BUFBJTkcuTElTVFwiXSxcInJvbGVcIjpcInVzZXJcIixcInJlZlwiOlwiXCIsXCJkZXZpY2VfaWRcIjpcIjgyMjY2MzVjOWZmYzQzNTFhOWQ0ZTBhYWJmYzVlY2VlXCJ9IiwiZXhwIjoxNjc1ODI5Mjk0LCJpYXQiOjE2NzU4MjIwMzR9.LXmWVTC_XaZRgz6Gs3Q_OPvnIU37-zTNoJ60Tis5zbkY8AFitilagedAsStUQRVJByH1UjynvBXeWhOUrYzSqiNrTT-smvxv3gQnZTyLk6nKBmXhvpuxaE3m_HnytwrGc2copuYmJdSSOhU0tZh3AYDZA_XBPPeBduc0j71LqI8")