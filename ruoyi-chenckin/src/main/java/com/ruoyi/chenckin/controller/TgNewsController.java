package com.ruoyi.chenckin.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.chenckin.domain.TgNews;
import com.ruoyi.chenckin.service.ITgNewsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * TG每日新闻Controller
 * 
 * @author ruoyi
 * @date 2023-02-18
 */
@RestController
@RequestMapping("/chenckin/tgNews")
public class TgNewsController extends BaseController
{
    @Autowired
    private ITgNewsService tgNewsService;

    /**
     * 查询TG每日新闻列表
     */
    @PreAuthorize("@ss.hasPermi('chenckin:tgNews:list')")
    @GetMapping("/list")
    public TableDataInfo list(TgNews tgNews)
    {
        startPage();
        List<TgNews> list = tgNewsService.selectTgNewsList(tgNews);
        return getDataTable(list);
    }

    /**
     * 导出TG每日新闻列表
     */
    @PreAuthorize("@ss.hasPermi('chenckin:tgNews:export')")
    @Log(title = "TG每日新闻", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TgNews tgNews)
    {
        List<TgNews> list = tgNewsService.selectTgNewsList(tgNews);
        ExcelUtil<TgNews> util = new ExcelUtil<TgNews>(TgNews.class);
        util.exportExcel(response, list, "TG每日新闻数据");
    }

    /**
     * 获取TG每日新闻详细信息
     */
    @PreAuthorize("@ss.hasPermi('chenckin:tgNews:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tgNewsService.selectTgNewsById(id));
    }

    /**
     * 新增TG每日新闻
     */
    @PreAuthorize("@ss.hasPermi('chenckin:tgNews:add')")
    @Log(title = "TG每日新闻", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TgNews tgNews)
    {
        return toAjax(tgNewsService.insertTgNews(tgNews));
    }

    /**
     * 修改TG每日新闻
     */
    @PreAuthorize("@ss.hasPermi('chenckin:tgNews:edit')")
    @Log(title = "TG每日新闻", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TgNews tgNews)
    {
        return toAjax(tgNewsService.updateTgNews(tgNews));
    }

    /**
     * 删除TG每日新闻
     */
    @PreAuthorize("@ss.hasPermi('chenckin:tgNews:remove')")
    @Log(title = "TG每日新闻", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tgNewsService.deleteTgNewsByIds(ids));
    }
}
