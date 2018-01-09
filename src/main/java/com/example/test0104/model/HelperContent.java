package com.example.test0104.model;

import java.util.Date;

/**
 * @Author:Misaniy
 * @Date:2018/1/4
 */
public class HelperContent {
    private long id;
    private long fid;//父节点ID
    private long hid;//所属说明文档ID
    private String content;//文档类容
    private Date cts;//创建时间
    private Date uts;//最后更新时间
    private int status; //状态

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFid() {
        return fid;
    }

    public void setFid(long fid) {
        this.fid = fid;
    }

    public long getHid() {
        return hid;
    }

    public void setHid(long hid) {
        this.hid = hid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
