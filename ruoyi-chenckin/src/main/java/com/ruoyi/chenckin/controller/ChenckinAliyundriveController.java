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
import com.ruoyi.chenckin.domain.ChenckinAliyundrive;
import com.ruoyi.chenckin.service.IChenckinAliyundriveService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 阿里云盘Controller
 *
 * @author ruoyi
 * @date 2023-02-08
 */
@RestController
@RequestMapping("/chenckin/aliyundrive")
public class ChenckinAliyundriveController extends BaseController {
    @Autowired
    private IChenckinAliyundriveService chenckinAliyundriveService;

    /**
     * 查询阿里云盘列表
     */
    @PreAuthorize("@ss.hasPermi('chenckin:aliyundrive:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChenckinAliyundrive chenckinAliyundrive) {
        startPage();
        List<ChenckinAliyundrive> list = chenckinAliyundriveService.selectChenckinAliyundriveList(chenckinAliyundrive);
        return getDataTable(list);
    }

    /**
     * 导出阿里云盘列表
     */
    @PreAuthorize("@ss.hasPermi('chenckin:aliyundrive:export')")
    @Log(title = "阿里云盘", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChenckinAliyundrive chenckinAliyundrive) {
        List<ChenckinAliyundrive> list = chenckinAliyundriveService.selectChenckinAliyundriveList(chenckinAliyundrive);
        ExcelUtil<ChenckinAliyundrive> util = new ExcelUtil<ChenckinAliyundrive>(ChenckinAliyundrive.class);
        util.exportExcel(response, list, "阿里云盘数据");
    }

    /**
     * 获取阿里云盘详细信息
     */
    @PreAuthorize("@ss.hasPermi('chenckin:aliyundrive:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(chenckinAliyundriveService.selectChenckinAliyundriveById(id));
    }

    /**
     * 新增阿里云盘
     */
    @PreAuthorize("@ss.hasPermi('chenckin:aliyundrive:add')")
    @Log(title = "阿里云盘", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChenckinAliyundrive chenckinAliyundrive) {
        return toAjax(chenckinAliyundriveService.insertChenckinAliyundrive(chenckinAliyundrive));
    }

    /**
     * 修改阿里云盘
     */
    @PreAuthorize("@ss.hasPermi('chenckin:aliyundrive:edit')")
    @Log(title = "阿里云盘", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChenckinAliyundrive chenckinAliyundrive) {
        return toAjax(chenckinAliyundriveService.updateChenckinAliyundrive(chenckinAliyundrive));
    }

    /**
     * 删除阿里云盘
     */
    @PreAuthorize("@ss.hasPermi('chenckin:aliyundrive:remove')")
    @Log(title = "阿里云盘", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(chenckinAliyundriveService.deleteChenckinAliyundriveByIds(ids));
    }
}
