package com.example.test0104.model;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Author:Misaniy
 * @Date:2018/1/3
 */
@Component
public class SearchItem implements Serializable{

    @Field
    long id;

    @Field
    long hid;

    @Field
    long fid;

    @Field
    String keyWords;

    @Field
    String content;

    @Field
    String index;

    @Field
    String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getHid() {
        return hid;
    }

    public void setHid(long hid) {
        this.hid = hid;
    }

    public long getFid() {
        return fid;
    }

    public void setFid(long fid) {
        this.fid = fid;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
