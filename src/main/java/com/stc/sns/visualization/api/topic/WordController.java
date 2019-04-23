package com.stc.sns.visualization.api.topic;

import com.stc.sns.visualization.mybatis.domain.WordCloudVO;
import com.stc.sns.visualization.mybatis.service.WordCloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@PreAuthorize("hasRole('ROLE_USER')")
@RestController
@RequestMapping("/api/word")
public class WordController {

    @Autowired
    private WordCloudService wordCloudService;

    @GetMapping("/cloud/{word}")
    public List<WordCloudVO> getWorldCloud(@PathVariable("word") String word) {
        return wordCloudService.getWordCloudList();
    }
}
