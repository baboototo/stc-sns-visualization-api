package com.stc.sns.visualization.mybatis.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@NoArgsConstructor
@Alias("WordCloudVO")
public class WordCloudVO {
    private String name;
    private Long value;

}
