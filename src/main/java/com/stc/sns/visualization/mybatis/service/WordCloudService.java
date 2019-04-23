package com.stc.sns.visualization.mybatis.service;

import com.stc.sns.visualization.mybatis.mapper.WordCloudMapper;
import com.stc.sns.visualization.mybatis.domain.WordCloudVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordCloudService {

    @Autowired
    private WordCloudMapper wordCloudMapper;

    public List<WordCloudVO> getWordCloudList() {
        return this.wordCloudMapper.getWordCloudList();
    }
}
