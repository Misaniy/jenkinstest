package com.example.test0104.model;

import java.util.Date;

/**
 * @Author:Misaniy
 * @Date:2018/1/4
 */
public class Helper {
    private long id;
    private String name;//名称
    private long typeId;//文档类型ID
    private String typeName; //文档类型名称
    private Date cts;//创建时间
    private Date uts;//最后更新时间
    private int status; //状态

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Date getCts() {
        return cts;
    }

    public void setCts(Date cts) {
        this.cts = cts;
    }

    public Date getUts() {
        return uts;
    }

    public void setUts(Date uts) {
        this.uts = uts;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
