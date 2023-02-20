package com.ruoyi.chenckin.service;

import java.util.List;

import com.ruoyi.chenckin.domain.TgNews;
import org.apache.ibatis.annotations.Param;
import org.dom4j.DocumentException;

/**
 * TG每日新闻Service接口
 *
 * @author ruoyi
 * @date 2023-02-18
 */
public interface ITgNewsService {
    /**
     * 查询TG每日新闻
     *
     * @param id TG每日新闻主键
     * @return TG每日新闻
     */
    public TgNews selectTgNewsById(Long id);

    /**
     * 查询TG每日新闻列表
     *
     * @param tgNews TG每日新闻
     * @return TG每日新闻集合
     */
    public List<TgNews> selectTgNewsList(TgNews tgNews);

    /**
     * 新增TG每日新闻
     *
     * @return 结果
     */
    public int insertTgNews(TgNews tgNews);

    /**
     * 自动新增TG每日新闻
     *
     * @return 结果
     */
    public void autoInsertTgNews() throws DocumentException;

    /**
     * 修改TG每日新闻
     *
     * @param tgNews TG每日新闻
     * @return 结果
     */
    public int updateTgNews(TgNews tgNews);

    /**
     * 批量删除TG每日新闻
     *
     * @param ids 需要删除的TG每日新闻主键集合
     * @return 结果
     */
    public int deleteTgNewsByIds(Long[] ids);

    /**
     * 删除TG每日新闻信息
     *
     * @param id TG每日新闻主键
     * @return 结果
     */
    public int deleteTgNewsById(Long id);

    /**
     * 根据状态获取每日新闻
     *
     * @param statu
     */
    List<TgNews> selectTgNewsByStatu(Integer statu);

    /**
     * 批量修改新闻列表
     *
     * @param tgNewsList 新闻列表
     */
    int updateTgNewsList(List<TgNews> tgNewsList);
}
