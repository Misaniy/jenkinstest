package com.example.test0104.controller;

import com.example.test0104.model.SearchResult;
import com.example.test0104.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:Misaniy
 * @Date:2018/1/3
 */
@RestController
@RequestMapping("ops/helperSearch")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("reIndexes")
    public String reIndex() {
        searchService.reIndexes();
        return "ok";
    }

    @GetMapping("searchByKeyWords")
    public List<SearchResult> searchByKeyWords(
            @RequestParam("keyWords") String keyWords
    ) {
        System.out.println(keyWords);
        List<SearchResult> data = searchService.searchByKeyWords(keyWords);
        return data;
    }

    @GetMapping("searchByName")
    public List<SearchResult> searchByName(
            @RequestParam("name") String name
    ) {
        List<SearchResult> data = searchService.searchByName(name);
        return data;
    }

    @GetMapping("searchByIndex")
    public List<SearchResult> searchByIndex(
            @RequestParam("index") String index
    ) {
        List<SearchResult> data = searchService.searchByIndex(index);
        return data;
    }

    @GetMapping("searchByContent")
    public List<SearchResult> searchByContent(
            @RequestParam("content") String content
    ) {
        List<SearchResult> data = searchService.searchByContent(content);
        return data;
    }
}