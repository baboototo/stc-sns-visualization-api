package com.stc.sns.visualization.mybatis.mapper;

import com.stc.sns.visualization.mybatis.domain.BaseRequestParamVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CommonMapper {

    /**
     * 키워드 개수 조회
     * @param paramVO
     * @return
     */
    int countKeywords(BaseRequestParamVO paramVO);


    /**
     * 키워드에 해당하는 연관 검색어 개수 조회
     * @param paramVO
     * @return
     */
    int countKeywordByWord(BaseRequestParamVO paramVO);


}
