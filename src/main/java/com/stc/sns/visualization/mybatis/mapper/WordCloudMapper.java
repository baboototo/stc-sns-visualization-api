package com.stc.sns.visualization.mybatis.mapper;

import com.stc.sns.visualization.mybatis.domain.BaseChartVO;
import com.stc.sns.visualization.mybatis.domain.BaseRequestParamVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface WordCloudMapper {

    /**
     * 키워드 조회
     * @param paramVO
     * @return
     */
    List<BaseChartVO> searchKeywords(BaseRequestParamVO paramVO);

    /**
     * 키워드에 해당하는 연관 검색어 조회
     * @param paramVO
     * @return
     */
    List<BaseChartVO> searchKeywordByWord(BaseRequestParamVO paramVO);

}
