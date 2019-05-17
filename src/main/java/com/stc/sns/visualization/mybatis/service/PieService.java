package com.stc.sns.visualization.mybatis.service;

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

    /**
     * 키워드에 해당하는 채널 수집량 조회
     * @param paramVO
     * @return
     */
    public List<BaseChartVO> searchChannelTotalByKeyword(BaseRequestParamVO paramVO) {
        return this.pieMapper.searchChannelTotalByKeyword(paramVO);
    }
}
