package com.stc.sns.visualization.mybatis.mapper;

import com.stc.sns.visualization.mybatis.domain.BaseRequestParamVO;
import com.stc.sns.visualization.mybatis.domain.BaseChartVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PieMapper {

    /**
     * 키워드에 해당하는 채널 수집량 조회
     * @param paramVO
     * @return
     */
    List<BaseChartVO> searchChannelTotalByKeyword(BaseRequestParamVO paramVO);

    /**
     * 특정채널에 해당하는 키워드의 채널 상세정보 추이 목록 조회
     * @param paramVO
     * @return
     */
    List<BaseChartVO> searchChannelDetailTotalByKeyword(BaseRequestParamVO paramVO);

}
