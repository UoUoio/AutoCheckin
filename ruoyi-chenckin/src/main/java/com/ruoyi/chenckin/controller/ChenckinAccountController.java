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
import com.ruoyi.chenckin.domain.ChenckinAccount;
import com.ruoyi.chenckin.service.IChenckinAccountService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 签到列表Controller
 *
 * @author ruoyi
 * @date 2023-02-09
 */
@RestController
@RequestMapping("/chenckin/account")
public class ChenckinAccountController extends BaseController {
    @Autowired
    private IChenckinAccountService chenckinAccountService;

    /**
     * 查询签到列表列表
     */
    @PreAuthorize("@ss.hasPermi('chenckin:account:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChenckinAccount chenckinAccount) {
        startPage();
        List<ChenckinAccount> list = chenckinAccountService.selectChenckinAccountList(chenckinAccount);
        return getDataTable(list);
    }

    /**
     * 导出签到列表列表
     */
    @PreAuthorize("@ss.hasPermi('chenckin:account:export')")
    @Log(title = "签到列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChenckinAccount chenckinAccount) {
        List<ChenckinAccount> list = chenckinAccountService.selectChenckinAccountList(chenckinAccount);
        ExcelUtil<ChenckinAccount> util = new ExcelUtil<ChenckinAccount>(ChenckinAccount.class);
        util.exportExcel(response, list, "签到列表数据");
    }

    /**
     * 获取签到列表详细信息
     */
    @PreAuthorize("@ss.hasPermi('chenckin:account:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(chenckinAccountService.selectChenckinAccountById(id));
    }

    /**
     * 新增签到列表
     */
    @PreAuthorize("@ss.hasPermi('chenckin:account:add')")
    @Log(title = "签到列表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChenckinAccount chenckinAccount) {
        return toAjax(chenckinAccountService.insertChenckinAccount(chenckinAccount));
    }

    /**
     * 修改签到列表
     */
    @PreAuthorize("@ss.hasPermi('chenckin:account:edit')")
    @Log(title = "签到列表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChenckinAccount chenckinAccount) {
        return toAjax(chenckinAccountService.updateChenckinAccount(chenckinAccount));
    }

    /**
     * 删除签到列表
     */
    @PreAuthorize("@ss.hasPermi('chenckin:account:remove')")
    @Log(title = "签到列表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(chenckinAccountService.deleteChenckinAccountByIds(ids));
    }


    /**
     * 执行某个任务
     */
    @Log(title = "签到列表", businessType = BusinessType.OTHER)
    @PostMapping("/handleRun/{id}")
    public AjaxResult handleRun(@PathVariable("id") Long id) {
        return toAjax(chenckinAccountService.handleRun(id));
    }
}
