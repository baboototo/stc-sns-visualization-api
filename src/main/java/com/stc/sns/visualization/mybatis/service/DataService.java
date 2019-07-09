package com.stc.sns.visualization.mybatis.service;

import com.stc.sns.visualization.mybatis.domain.BaseRequestParamVO;
import com.stc.sns.visualization.mybatis.mapper.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DataService {

    @Autowired
    private DataMapper dataMapper;


    public List<Map<String, String>> searchOriginalWebDocument(BaseRequestParamVO paramVO) {
        return this.dataMapper.searchOriginalWebDocument(paramVO);
    }

}
