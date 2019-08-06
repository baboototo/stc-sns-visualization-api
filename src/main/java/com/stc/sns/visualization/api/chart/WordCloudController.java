package com.stc.sns.visualization.api.chart;

import com.stc.sns.visualization.mybatis.domain.BaseRequestParamVO;
import com.stc.sns.visualization.mybatis.domain.BaseChartVO;
import com.stc.sns.visualization.mybatis.service.DataZoomService;
import com.stc.sns.visualization.mybatis.service.WordCloudService;
import com.stc.sns.visualization.security.tokens.PostAuthorizationToken;
import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;
import kr.co.shineware.util.common.model.Pair;
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
     * 키워드 조회
     * @param authentication
     * @param paramVO
     * @return
     */
    @GetMapping("/v1.0/words/{keyword}")
    public List<BaseChartVO> searchKeywords(Authentication authentication
            , @PathVariable("keyword")      String keyword
            , @ModelAttribute("BaseRequestParamVO") BaseRequestParamVO paramVO) {
        PostAuthorizationToken token = (PostAuthorizationToken)authentication;

        paramVO.setKeyword(keyword);
        paramVO.setCustId(token.getAccount().getCustId());
        return wordCloudService.searchKeywords(paramVO);
    }

    /**
     * 키워드에 해당하는 연관 검색어 조회
     * @param authentication
     * @param keyword
     * @param subKeyword
     * @param paramVO
     * @return
     */
    @GetMapping("/v1.0/words/{keyword}/{subKeyword}")
    public List<BaseChartVO> searchKeywordByWord(Authentication authentication
            , @PathVariable("keyword")      String keyword
            , @PathVariable("subKeyword")   String subKeyword
            , @ModelAttribute("BaseRequestParamVO") BaseRequestParamVO paramVO) {
        PostAuthorizationToken token = (PostAuthorizationToken)authentication;

        paramVO.setKeyword(keyword);
        paramVO.setSubKeyword(subKeyword);
        paramVO.setCustId(token.getAccount().getCustId());
        return wordCloudService.searchKeywordByWord(paramVO);
    }
}
