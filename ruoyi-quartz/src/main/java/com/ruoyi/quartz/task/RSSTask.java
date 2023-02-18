package com.ruoyi.quartz.task;

import com.ruoyi.chenckin.service.ITgNewsService;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author:
 * @Date: 2023-02-18 15:03
 * @Description: < 描述 >
 */
@Component("rSSTask")
public class RSSTask {


    @Autowired
    private ITgNewsService tgNewsService;


    /**
     * 从知乎获取每日新闻
     */
    public void getNews() throws DocumentException {
        tgNewsService.autoInsertTgNews();
    }


}
