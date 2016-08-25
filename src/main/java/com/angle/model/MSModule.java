package com.angle.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/8/18 0018.
 */
@Entity
@Table(name = "tbl_ms_module")
public class MSModule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MODULE_ID")
    private long moduleId;
    @Column(nullable = false,name="MODULE_NAME")
    private String moduleName;
    @Column(name="MODULE_URL")
    private String moduleUrl;
    @Column(nullable = false,name="PARENT_ID")
    private long parentId;
    @Column(nullable = false,name="LEVEL")
    private int level;
    @Column(nullable = false,name="IF_LEAF")
    private int ifLeaf;
    @Column(nullable = false,name="STATUS")
    private int status;
    @Column(nullable = false,name="SORT_ORDER")
    private int sortOrder;
    @Column(nullable = false,name="CREATE_TIME")
    private Date createTime;

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleUrl() {
        return moduleUrl;
    }

    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getIfLeaf() {
        return ifLeaf;
    }

    public void setIfLeaf(int ifLeaf) {
        this.ifLeaf = ifLeaf;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
