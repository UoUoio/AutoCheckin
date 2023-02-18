package com.ruoyi.chenckin.mapper;

import java.util.List;

import com.ruoyi.chenckin.domain.TgNews;

/**
 * TG每日新闻Mapper接口
 *
 * @author ruoyi
 * @date 2023-02-18
 */
public interface TgNewsMapper {
    /**
     * 查询TG每日新闻
     *
     * @param id TG每日新闻主键
     * @return TG每日新闻
     */
    public TgNews selectTgNewsById(Long id);

    /**
     * 查询TG每日新闻-今天
     *
     * @param id TG每日新闻主键
     * @return TG每日新闻
     */
    public TgNews selectTgNewsByNow();

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
     * @param tgNews TG每日新闻
     * @return 结果
     */
    public int insertTgNews(TgNews tgNews);

    /**
     * 修改TG每日新闻
     *
     * @param tgNews TG每日新闻
     * @return 结果
     */
    public int updateTgNews(TgNews tgNews);

    /**
     * 删除TG每日新闻
     *
     * @param id TG每日新闻主键
     * @return 结果
     */
    public int deleteTgNewsById(Long id);

    /**
     * 批量删除TG每日新闻
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTgNewsByIds(Long[] ids);

    /**
     * 根据状态获取每日新闻
     *
     * @param statu
     */
    List<TgNews> selectTgNewsByStatu(Integer statu);
}
