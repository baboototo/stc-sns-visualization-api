package com.stc.sns.visualization.api.chart;

import com.stc.sns.visualization.mybatis.domain.BaseRequestParamVO;
import com.stc.sns.visualization.mybatis.domain.BaseChartVO;
import com.stc.sns.visualization.mybatis.service.WordCloudService;
import com.stc.sns.visualization.security.tokens.PostAuthorizationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasRole('ROLE_USER')")
@RestController
@RequestMapping("/api/wordCloud")
public class WordCloudController {

    private static final Logger log = LoggerFactory.getLogger(WordCloudController.class);

    @Autowired
    private WordCloudService wordCloudService;

    /**
     * Word Cloud 조회
     * @param authentication
     * @param paramVO
     * @return
     */
    @GetMapping("/v1.0/words")
    public List<BaseChartVO> searchWorldCloud(Authentication authentication
                                           , @ModelAttribute("BaseRequestParamVO") BaseRequestParamVO paramVO) {
        PostAuthorizationToken token = (PostAuthorizationToken)authentication;
        paramVO.setCustId(token.getAccount().getCustId());
        return wordCloudService.searchWordCloudList(paramVO);
    }

    @GetMapping("/v1.0/words/{keyword}/{subKeyword}")
    public List<BaseChartVO> searchWorldCloud(Authentication authentication
            , @PathVariable("keyword")      String keyword
            , @PathVariable("subKeyword")   String subKeyword
            , @ModelAttribute("BaseRequestParamVO") BaseRequestParamVO paramVO) {
        PostAuthorizationToken token = (PostAuthorizationToken)authentication;

        paramVO.setKeyword(keyword);
        paramVO.setSubKeyword(subKeyword);
        paramVO.setCustId(token.getAccount().getCustId());
        return wordCloudService.searchWordCloudList(paramVO);
    }
}
