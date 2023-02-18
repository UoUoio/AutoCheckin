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
import com.ruoyi.chenckin.domain.TGMsgLog;
import com.ruoyi.chenckin.service.ITGMsgLogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * tg消息发送日志Controller
 * 
 * @author ruoyi
 * @date 2023-02-18
 */
@RestController
@RequestMapping("/chenckin/tgMsgLog")
public class TGMsgLogController extends BaseController
{
    @Autowired
    private ITGMsgLogService tGMsgLogService;

    /**
     * 查询tg消息发送日志列表
     */
    @PreAuthorize("@ss.hasPermi('chenckin:tgMsgLog:list')")
    @GetMapping("/list")
    public TableDataInfo list(TGMsgLog tGMsgLog)
    {
        startPage();
        List<TGMsgLog> list = tGMsgLogService.selectTGMsgLogList(tGMsgLog);
        return getDataTable(list);
    }

    /**
     * 导出tg消息发送日志列表
     */
    @PreAuthorize("@ss.hasPermi('chenckin:tgMsgLog:export')")
    @Log(title = "tg消息发送日志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TGMsgLog tGMsgLog)
    {
        List<TGMsgLog> list = tGMsgLogService.selectTGMsgLogList(tGMsgLog);
        ExcelUtil<TGMsgLog> util = new ExcelUtil<TGMsgLog>(TGMsgLog.class);
        util.exportExcel(response, list, "tg消息发送日志数据");
    }

    /**
     * 获取tg消息发送日志详细信息
     */
    @PreAuthorize("@ss.hasPermi('chenckin:tgMsgLog:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tGMsgLogService.selectTGMsgLogById(id));
    }

    /**
     * 新增tg消息发送日志
     */
    @PreAuthorize("@ss.hasPermi('chenckin:tgMsgLog:add')")
    @Log(title = "tg消息发送日志", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TGMsgLog tGMsgLog)
    {
        return toAjax(tGMsgLogService.insertTGMsgLog(tGMsgLog));
    }

    /**
     * 修改tg消息发送日志
     */
    @PreAuthorize("@ss.hasPermi('chenckin:tgMsgLog:edit')")
    @Log(title = "tg消息发送日志", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TGMsgLog tGMsgLog)
    {
        return toAjax(tGMsgLogService.updateTGMsgLog(tGMsgLog));
    }

    /**
     * 删除tg消息发送日志
     */
    @PreAuthorize("@ss.hasPermi('chenckin:tgMsgLog:remove')")
    @Log(title = "tg消息发送日志", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tGMsgLogService.deleteTGMsgLogByIds(ids));
    }
}
