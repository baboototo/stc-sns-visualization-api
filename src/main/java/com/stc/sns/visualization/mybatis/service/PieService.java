package com.stc.sns.visualization.mybatis.service;

import com.stc.sns.visualization.jpa.domain.channel.BigTpcMstRepositoryImpl;
import com.stc.sns.visualization.mybatis.domain.BaseChartVO;
import com.stc.sns.visualization.mybatis.domain.BaseRequestParamVO;
import com.stc.sns.visualization.mybatis.mapper.PieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PieService {

    @Autowired
    private PieMapper pieMapper;

    @Autowired
    private BigTpcMstRepositoryImpl bigTpcMstRepository;


    /**
     * 키워드에 해당하는 채널 수집량 조회
     * @param paramVO
     * @return
     */
    public List<BaseChartVO> searchChannelTotalByKeyword(BaseRequestParamVO paramVO) {
        List<String> excludeAskNmList = bigTpcMstRepository.findByExcludeAskNm(paramVO.getCustId());
        excludeAskNmList.add(paramVO.getKeyword());

        paramVO.setExcludeKeywords(excludeAskNmList);
        return this.pieMapper.searchChannelTotalByKeyword(paramVO);
    }

    /**
     * 특정채널에 해당하는 키워드의 채널 상세정보 추이 목록 조회
     * @param paramVO
     * @return
     */
    public List<BaseChartVO> searchChannelDetailTotalByKeyword(BaseRequestParamVO paramVO) {
        List<String> excludeAskNmList = bigTpcMstRepository.findByExcludeAskNm(paramVO.getCustId());
        excludeAskNmList.add(paramVO.getKeyword());

        paramVO.setExcludeKeywords(excludeAskNmList);
        return this.pieMapper.searchChannelDetailTotalByKeyword(paramVO);
    }
}
