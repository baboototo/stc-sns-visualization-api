package com.stc.sns.visualization.mybatis.mapper;

import com.stc.sns.visualization.mybatis.domain.WordCloudVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface WordCloudMapper {
    List<WordCloudVO> getWordCloudList();
}
