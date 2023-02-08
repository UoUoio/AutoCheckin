package com.ruoyi.chenckin;

import cn.hutool.http.HttpRequest;

/**
 * @author:
 * @Date: 2023-02-08 13:13
 * @Description: < 描述 >
 */
public class MyBMW {

    public static void main(String[] args) {
        // https://stm-collect.cn.miaozhen.com/track_ajax HTTP/1.1
        HttpRequest post = HttpRequest.post("https://stm-collect.cn.miaozhen.com/track_ajax?tid=dc-3809&t=event&cid=165302626554784860&lt=3&ni=0&sr=1284*2778&ul=zh-Hans-US&mdm=iPhone14%2C3&brand=apple&appv=3.1.0&mo=ios&m");
        post
                .header("Host", "stm-collect.cn.miaozhen.com")
                .header("Accept", "*/*")
                .header("Content-Type", "image/gif;charset=utf-8")
                .header("Connection", "keep-alive")
                .header("Cookie", "a=bCf5p0Ri43iH; stmat=1671075993.3809; tsc=3_639a9899_639a9899_0_1")
                .header("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 16_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148")
                .header("Accept-Language", "zh-CN,zh-Hans;q=0.9")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Content-Length", "367");
        String body = post.execute().body();
        System.out.println(body);
    }


}
