package com.stc.sns.visualization.mybatis.service;

import com.stc.sns.visualization.common.OpenKoreanTextUtils;
import com.stc.sns.visualization.mybatis.domain.BaseChartVO;
import com.stc.sns.visualization.mybatis.domain.BaseRequestParamVO;
import com.stc.sns.visualization.mybatis.mapper.CommonMapper;
import com.stc.sns.visualization.mybatis.mapper.PieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PieService {

    @Autowired
    private CommonMapper commonMapper;

    @Autowired
    private PieMapper pieMapper;


    /**
     * 키워드에 해당하는 채널 수집량 조회
     * @param paramVO
     * @return
     */
    public List<BaseChartVO> searchChannelTotalByKeyword(BaseRequestParamVO paramVO) {
        List<BaseChartVO> resultData = this.pieMapper.searchChannelTotalByKeyword(paramVO);

        if (resultData.size() == 0) {
            List<String> analyzeList = OpenKoreanTextUtils.extractPhrases(paramVO.getKeyword());
            paramVO.setAnalyzeKeywords(analyzeList);

            resultData = this.pieMapper.searchChannelTotalByKeyword(paramVO);
        }

        return resultData;
    }

    /**
     * 특정채널에 해당하는 키워드의 채널 상세정보 추이 목록 조회
     * @param paramVO
     * @return
     */
    public List<BaseChartVO> searchChannelDetailTotalByKeyword(BaseRequestParamVO paramVO) {
        List<BaseChartVO> resultData = this.pieMapper.searchChannelDetailTotalByKeyword(paramVO);

        if (resultData.size() == 0) {
            List<String> analyzeList = OpenKoreanTextUtils.extractPhrases(paramVO.getKeyword());
            paramVO.setAnalyzeKeywords(analyzeList);

            resultData = this.pieMapper.searchChannelDetailTotalByKeyword(paramVO);
        }

        return resultData;
    }
}
