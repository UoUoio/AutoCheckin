package com.ruoyi.chenckin.service.impl;

import java.util.List;

import com.ruoyi.chenckin.util.RSSUtils;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.chenckin.mapper.TgNewsMapper;
import com.ruoyi.chenckin.domain.TgNews;
import com.ruoyi.chenckin.service.ITgNewsService;

/**
 * TG每日新闻Service业务层处理
 *
 * @author ruoyi
 * @date 2023-02-18
 */
@Service
public class TgNewsServiceImpl implements ITgNewsService {
    @Autowired
    private TgNewsMapper tgNewsMapper;

    /**
     * 查询TG每日新闻
     *
     * @param id TG每日新闻主键
     * @return TG每日新闻
     */
    @Override
    public TgNews selectTgNewsById(Long id) {
        return tgNewsMapper.selectTgNewsById(id);
    }

    /**
     * 查询TG每日新闻列表
     *
     * @param tgNews TG每日新闻
     * @return TG每日新闻
     */
    @Override
    public List<TgNews> selectTgNewsList(TgNews tgNews) {
        return tgNewsMapper.selectTgNewsList(tgNews);
    }

    /**
     * 新增TG每日新闻
     *
     * @param tgNews TG每日新闻
     * @return 结果
     */
    @Override
    public int insertTgNews(TgNews tgNews) {
        tgNews.setCreateTime(DateUtils.getNowDate());
        return tgNewsMapper.insertTgNews(tgNews);
    }


    /**
     * 自动新增TG每日新闻
     *
     * @return 结果
     */
    @Override
    public void autoInsertTgNews() throws DocumentException {
        TgNews newsByNow = tgNewsMapper.selectTgNewsByNow();
        // 先判断数据库今天是否有新闻了
        if (newsByNow == null) {
            // 从Rss订阅获取新闻
            String zhiHuRssStr = RSSUtils.getZhiHuRss();
            // 如果从rss中没有获取到新闻_直接返回
            if (StringUtils.isNotEmpty(zhiHuRssStr)) {
                TgNews tgNews = new TgNews();
                tgNews.setContent(zhiHuRssStr);
                tgNewsMapper.insertTgNews(tgNews);
            }

        }
    }

    /**
     * 修改TG每日新闻
     *
     * @param tgNews TG每日新闻
     * @return 结果
     */
    @Override
    public int updateTgNews(TgNews tgNews) {
        tgNews.setUpdateTime(DateUtils.getNowDate());
        return tgNewsMapper.updateTgNews(tgNews);
    }

    /**
     * 批量删除TG每日新闻
     *
     * @param ids 需要删除的TG每日新闻主键
     * @return 结果
     */
    @Override
    public int deleteTgNewsByIds(Long[] ids) {
        return tgNewsMapper.deleteTgNewsByIds(ids);
    }

    /**
     * 删除TG每日新闻信息
     *
     * @param id TG每日新闻主键
     * @return 结果
     */
    @Override
    public int deleteTgNewsById(Long id) {
        return tgNewsMapper.deleteTgNewsById(id);
    }

    /**
     * 根据状态获取每日新闻
     *
     * @param statu
     */
    @Override
    public List<TgNews> selectTgNewsByStatu(Integer statu) {
        return tgNewsMapper.selectTgNewsByStatu(statu);
    }

    /**
     * 批量修改新闻列表
     *
     * @param tgNewsList 新闻列表
     */
    @Override
    public int updateTgNewsList(List<TgNews> tgNewsList) {
        return tgNewsMapper.updateTgNewsList(tgNewsList);
    }
}
