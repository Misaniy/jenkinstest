package com.example.test0104.mapper;

import com.example.test0104.model.Helper;
import com.example.test0104.model.HelperContent;
import com.example.test0104.model.HelperIndex;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SearchMapper {

    @Select("SELECT id,name FROM helper")
    List<Helper> findHelpers();

    @Select("SELECT id,hid,fid,name FROM helper_index")
    List<HelperIndex> findHelperIndex();

    @Select("SELECT id,hid,fid,content FROM helper_content")
    List<HelperContent> findHelperContent();

}
