package com.stc.sns.visualization.mybatis.service;

import com.stc.sns.visualization.common.KomoranUtils;
import com.stc.sns.visualization.mybatis.domain.BaseRequestParamVO;
import com.stc.sns.visualization.mybatis.mapper.CommonMapper;
import com.stc.sns.visualization.mybatis.mapper.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DataService {

    @Autowired
    private CommonMapper commonMapper;

    @Autowired
    private DataMapper dataMapper;


    public List<Map<String, String>> searchOriginalWebDocument(BaseRequestParamVO paramVO) {
        // 키워드 데이터 확인 후 매칭 키워드가 없을 경우 키워드 형태소 분석 단어 설정
        int dataCount = this.commonMapper.countKeywords(paramVO);
        if (dataCount == 0) {
            List<String> analyzeList = KomoranUtils.analyzeKeywordList(paramVO.getKeyword());
            paramVO.setAnalyzeKeywords(analyzeList);
        }
        return this.dataMapper.searchOriginalWebDocument(paramVO);
    }

}
