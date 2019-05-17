package com.stc.sns.visualization.mybatis.service;

import com.stc.sns.visualization.mybatis.domain.BaseRequestParamVO;
import com.stc.sns.visualization.mybatis.mapper.WordCloudMapper;
import com.stc.sns.visualization.mybatis.domain.BaseChartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordCloudService {

    @Autowired
    private WordCloudMapper wordCloudMapper;

    /**
     * Word Cloud
     * @param paramVO
     * @return
     */
    public List<BaseChartVO> searchWordCloudList(BaseRequestParamVO paramVO) {
        return this.wordCloudMapper.searchWordCloudList(paramVO);
    }
}
