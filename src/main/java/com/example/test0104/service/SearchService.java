package com.example.test0104.service;

import com.example.test0104.mapper.SearchMapper;
import com.example.test0104.model.*;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Misaniy
 * @Date:2018/1/3
 */
@Service
public class SearchService {

    @Autowired
    SearchMapper searchMapper;

    private SolrClient solrClient = new HttpSolrClient("http://10.10.20.47:8983/solr/solrcore2");

    public void reIndexes() {
        try {
            solrClient.deleteByQuery("*:*");
            indexHelper(searchMapper.findHelpers());
            indexHelperIndex(searchMapper.findHelperIndex());
            indexHelperContent(searchMapper.findHelperContent());
        } catch (Exception e) {
            new Exception("重建索引失败");
        }
    }

    public List<SearchResult> searchByKeyWords(String keyWords) {
        SolrQuery query = new SolrQuery();
        query.setQuery("keyWords:"+keyWords);
        query.setFields("id","fid","hid");
        ArrayList<SearchResult> searchResults = new ArrayList<>();
        try {
            QueryResponse queryResponse = solrClient.query(query);
            SolrDocumentList solrDocumentList = queryResponse.getResults();
            for (SolrDocument solrDocument : solrDocumentList) {
                SearchResult item = new SearchResult();
                item.setId(solrDocument.get("id")+"");
                item.setFid(solrDocument.get("fid")+"");
                item.setHid(solrDocument.get("hid")+"");
                item.setKeyWords(keyWords);
                searchResults.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return searchResults;
        }
    }

    public List<SearchResult> searchByName(String name) {
        SolrQuery query = new SolrQuery();
        query.setQuery("name:" + name);
        query.setFields("id","fid","hid");
        ArrayList<SearchResult> searchResults = new ArrayList<>();
        try {
            QueryResponse queryResponse = solrClient.query(query);
            SolrDocumentList solrDocumentList = queryResponse.getResults();
            for (SolrDocument solrDocument : solrDocumentList) {
                SearchResult result = new SearchResult();
                result.setId(solrDocument.get("id")+"");
                result.setKeyWords(name);
                searchResults.add(result);
            }
        } catch (Exception e) {
            new Exception("搜索失败");
        } finally {
            return searchResults;
        }
    }

    public List<SearchResult> searchByIndex(String index) {
        SolrQuery query = new SolrQuery();
        query.setQuery("index:" + index);
        query.setFields("id","fid","hid");
        ArrayList<SearchResult> searchResults = new ArrayList<>();
        try {
            QueryResponse queryResponse = solrClient.query(query);
            SolrDocumentList solrDocumentList = queryResponse.getResults();
            for (SolrDocument solrDocument : solrDocumentList) {
                SearchResult result = new SearchResult();
                result.setId(solrDocument.get("id")+"");
                result.setFid(solrDocument.get("fid")+"");
                result.setHid(solrDocument.get("hid")+"");
                result.setKeyWords(index);
                searchResults.add(result);
            }
        } catch (Exception e) {
            new Exception("搜索失败");
        } finally {
            return searchResults;
        }
    }

    public List<SearchResult> searchByContent(String content) {
        SolrQuery query = new SolrQuery();
        query.setQuery("content:" + content);
        query.setFields("id","fid","hid");
        ArrayList<SearchResult> searchResults = new ArrayList<>();
        try {
            QueryResponse queryResponse = solrClient.query(query);
            SolrDocumentList solrDocumentList = queryResponse.getResults();
            for (SolrDocument solrDocument : solrDocumentList) {
                SearchResult result = new SearchResult();
                result.setId(solrDocument.get("id")+"");
                result.setFid(solrDocument.get("fid")+"");
                result.setHid(solrDocument.get("hid")+"");
                result.setKeyWords(content);
                searchResults.add(result);
            }
        } catch (Exception e) {
            new Exception("搜索失败");
        } finally {
            return searchResults;
        }
    }

    private void indexHelperContent(List<HelperContent> helperContent) throws IOException, SolrServerException {
        for (HelperContent content : helperContent) {
            SolrInputDocument document = new SolrInputDocument();
            document.addField("id",content.getId());
            document.addField("fid",content.getFid());
            document.addField("hid",content.getHid());
            document.addField("content",content.getContent());
            solrClient.add(document);
        }
        solrClient.commit();
    }

    public void indexHelper(List<Helper> helpers) throws Exception{
        for (Helper helper : helpers) {
            SolrInputDocument document = new SolrInputDocument();
            document.addField("id",helper.getId());
            document.addField("name",helper.getName());
            solrClient.add(document);
        }
        solrClient.commit();
    }

    public void indexHelperIndex(List<HelperIndex> helperIndex) throws Exception{
        for (HelperIndex index : helperIndex) {
            SolrInputDocument document = new SolrInputDocument();
            document.addField("id",index.getId());
            document.addField("fid",index.getFid());
            document.addField("hid",index.getHid());
            document.addField("index",index.getName());
            solrClient.add(document);
        }
        solrClient.commit();
    }
}
