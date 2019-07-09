package com.stc.sns.visualization.mybatis.service;

import com.stc.sns.visualization.jpa.domain.channel.BigTpcMstRepository;
import com.stc.sns.visualization.jpa.domain.channel.BigTpcMstRepositoryImpl;
import com.stc.sns.visualization.mybatis.domain.BaseChartVO;
import com.stc.sns.visualization.mybatis.domain.BaseRequestParamVO;
import com.stc.sns.visualization.mybatis.mapper.WordCloudMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordCloudService {

    @Autowired
    private WordCloudMapper wordCloudMapper;

    @Autowired
    private BigTpcMstRepositoryImpl bigTpcMstRepository;

    /**
     * 키워드 조회
     *
     * @param paramVO
     * @return
     */
    public List<BaseChartVO> searchKeywords(BaseRequestParamVO paramVO) {
        List<String> excludeAskNmList = bigTpcMstRepository.findByExcludeAskNm(paramVO.getCustId());
        excludeAskNmList.add(paramVO.getKeyword());

        paramVO.setExcludeKeywords(excludeAskNmList);
        return this.wordCloudMapper.searchKeywords(paramVO);
    }

    /**
     * 키워드에 해당하는 연관 검색어 조회
     *
     * @param paramVO
     * @return
     */
    public List<BaseChartVO> searchKeywordByWord(BaseRequestParamVO paramVO) {

        List<String> excludeAskNmList = bigTpcMstRepository.findByExcludeAskNm(paramVO.getCustId());
        excludeAskNmList.add(paramVO.getSubKeyword());

        paramVO.setExcludeKeywords(excludeAskNmList);

        return this.wordCloudMapper.searchKeywordByWord(paramVO);
    }
}
