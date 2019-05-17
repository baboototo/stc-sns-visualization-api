package com.stc.sns.visualization.mybatis.mapper;

import com.stc.sns.visualization.mybatis.domain.BaseRequestParamVO;
import com.stc.sns.visualization.mybatis.domain.BaseChartVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface WordCloudMapper {

    /**
     * Word Cloud 조회
     * @param paramVO
     * @return
     */
    List<BaseChartVO> searchWordCloudList(BaseRequestParamVO paramVO);
}
