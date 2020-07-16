package com.cola.sakura.common.dto;

import com.cola.sakura.common.enums.StatusEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: cola
 * @License: (C) Copyright 2019-2020, liangyx Corporation Limited.
 * @Contact: Email: cola_nsd@163.com
 * @Date: 2020/7/9 20:33
 * @Version: 1.0
 * @Description:
 */

public class AbstractBaseDTO implements Serializable {

    private static final long serialVersionUID = -1851168412582311401L;
    /**
     * 主键
     */
    private String id;
    /**
     * 创建者id
     */
    private String ownerId;
    /**
     * 创建者用户名
     */
    private String ownerName;
    /**
     * 创建时间
     */
    private Date objectCreateTime;
    /**
     * 数据修改人ID
     */
    private String objectModifierId;
    /**
     * 数据修改人
     */
    private String objectModifierName;
    /**
     * 修改时间
     */
    private Date objectModificationTime;
    /**
     * 数据来源
     */
    private String dataSource;

    public String getObjectModifierId() {
        return objectModifierId;
    }

    public void setObjectModifierId(String objectModifierId) {
        this.objectModifierId = objectModifierId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Date getObjectCreateTime() {
        return objectCreateTime;
    }

    public void setObjectCreateTime(Date objectCreateTime) {
        this.objectCreateTime = objectCreateTime;
    }

    public String getObjectModifierName() {
        return objectModifierName;
    }

    public void setObjectModifierName(String objectModifierName) {
        this.objectModifierName = objectModifierName;
    }

    public Date getObjectModificationTime() {
        return objectModificationTime;
    }

    public void setObjectModificationTime(Date objectModificationTime) {
        this.objectModificationTime = objectModificationTime;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String toString() {
        return "AbstractBaseEntity{" +
                "id='" + id + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", objectCreateTime=" + objectCreateTime +
                ", objectModifierId='" + objectModifierId + '\'' +
                ", objectModifierName='" + objectModifierName + '\'' +
                ", objectModificationTime=" + objectModificationTime +
                ", dataSource='" + dataSource + '\'' +
                '}';
    }
}
