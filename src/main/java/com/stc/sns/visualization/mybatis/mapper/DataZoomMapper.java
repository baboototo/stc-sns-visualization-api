package com.stc.sns.visualization.mybatis.mapper;

import com.stc.sns.visualization.mybatis.domain.BaseRequestParamVO;
import com.stc.sns.visualization.mybatis.domain.DataZoomChartVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DataZoomMapper {

    /**
     * 채널별 수집 추이 일별 데이터 조회
     * @param paramVO
     * @return
     */
    List<DataZoomChartVO> searchChannelCollectionByDays(BaseRequestParamVO paramVO);

    /**
     * 특정채널에 해당하는 키워드의 채널 상세정보 수집 추이 일별 데이터 조회
     * @param paramVO
     * @return
     */
    List<DataZoomChartVO> searchChannelDetailCollectionByDays(BaseRequestParamVO paramVO);
}
