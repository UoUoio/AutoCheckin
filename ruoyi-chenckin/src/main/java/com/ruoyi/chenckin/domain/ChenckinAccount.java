package com.ruoyi.chenckin.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 签到列表对象 chenckin_account
 * 
 * @author ruoyi
 * @date 2023-02-09
 */
public class ChenckinAccount extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickname;

    /** Token */
    @Excel(name = "Token")
    private String token;

    /** 运行结果 */
    @Excel(name = "运行结果")
    private String lastResult;

    /** 运行状态 */
    @Excel(name = "运行状态")
    private Integer lastStatus;

    /** 创建人 */
    private Long userId;

    /** 类型 */
    @Excel(name = "类型")
    private Long types;

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
    public void setLastStatus(Integer lastStatus) 
    {
        this.lastStatus = lastStatus;
    }

    public Integer getLastStatus() 
    {
        return lastStatus;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setTypes(Long types) 
    {
        this.types = types;
    }

    public Long getTypes() 
    {
        return types;
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
            .append("userId", getUserId())
            .append("types", getTypes())
            .toString();
    }
}
