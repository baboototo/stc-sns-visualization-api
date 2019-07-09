package com.stc.sns.visualization.mybatis.mapper;

import com.stc.sns.visualization.mybatis.domain.BaseRequestParamVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface DataMapper {

      List<Map<String, String>> searchOriginalWebDocument(BaseRequestParamVO paramVO);

}
