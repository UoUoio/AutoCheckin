package com.ruoyi.chenckin.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 阿里云盘对象 chenckin_aliyundrive
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
public class ChenckinAliyundrive extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickname;

    /** Token */
    private String token;

    /** 最后一次运行结果 */
    @Excel(name = "最后一次运行结果")
    private String lastResult;

    /** 最后一次运行状态 */
    @Excel(name = "最后一次运行状态")
    private Long lastStatus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setNickname(String nickname) 
    {
        this.nickname = nickname;
    }

    public String getNickname() 
    {
        return nickname;
    }
    public void setToken(String token) 
    {
        this.token = token;
    }

    public String getToken() 
    {
        return token;
    }
    public void setLastResult(String lastResult) 
    {
        this.lastResult = lastResult;
    }

    public String getLastResult() 
    {
        return lastResult;
    }
    public void setLastStatus(Long lastStatus) 
    {
        this.lastStatus = lastStatus;
    }

    public Long getLastStatus() 
    {
        return lastStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("nickname", getNickname())
            .append("token", getToken())
            .append("lastResult", getLastResult())
            .append("lastStatus", getLastStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
