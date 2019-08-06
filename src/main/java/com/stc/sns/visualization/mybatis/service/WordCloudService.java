package com.stc.sns.visualization.mybatis.service;

import com.stc.sns.visualization.common.KomoranUtils;
import com.stc.sns.visualization.jpa.domain.channel.BigTpcMstRepositoryImpl;
import com.stc.sns.visualization.mybatis.domain.BaseChartVO;
import com.stc.sns.visualization.mybatis.domain.BaseRequestParamVO;
import com.stc.sns.visualization.mybatis.mapper.CommonMapper;
import com.stc.sns.visualization.mybatis.mapper.WordCloudMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordCloudService {

    private static final Logger log = LoggerFactory.getLogger(WordCloudService.class);

    @Autowired
    private CommonMapper commonMapper;

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

        // 제외 키워드 조회 및 파라미터 설정
        List<String> excludeAskNmList = bigTpcMstRepository.findByExcludeAskNm(paramVO.getCustId());
        excludeAskNmList.add(paramVO.getKeyword());
        paramVO.setExcludeKeywords(excludeAskNmList);

        // 키워드 데이터 확인 후 매칭 키워드가 없을 경우 키워드 형태소 분석 단어 설정
        int dataCount = this.commonMapper.countKeywords(paramVO);
        if (dataCount == 0) {
            List<String> analyzeList = KomoranUtils.analyzeKeywordList(paramVO.getKeyword());
            excludeAskNmList.addAll(analyzeList);

            paramVO.setExcludeKeywords(excludeAskNmList);
            paramVO.setAnalyzeKeywords(analyzeList);
        }

        return this.wordCloudMapper.searchKeywords(paramVO);
    }

    /**
     * 키워드에 해당하는 연관 검색어 조회
     *
     * @param paramVO
     * @return
     */
    public List<BaseChartVO> searchKeywordByWord(BaseRequestParamVO paramVO) {

        // 제외 키워드 조회 및 파라미터 설정
        List<String> excludeAskNmList = bigTpcMstRepository.findByExcludeAskNm(paramVO.getCustId());
        excludeAskNmList.add(paramVO.getSubKeyword());
        paramVO.setExcludeKeywords(excludeAskNmList);

        // 키워드 데이터 확인 후 매칭 키워드가 없을 경우 키워드 형태소 분석 단어 설정
        int dataCount = this.commonMapper.countKeywordByWord(paramVO);
        if (dataCount == 0) {
            List<String> analyzeList = KomoranUtils.analyzeKeywordList(paramVO.getKeyword());
            excludeAskNmList.addAll(analyzeList);

            paramVO.setExcludeKeywords(excludeAskNmList);
            paramVO.setAnalyzeKeywords(analyzeList);
        }

        return this.wordCloudMapper.searchKeywordByWord(paramVO);
    }
}
