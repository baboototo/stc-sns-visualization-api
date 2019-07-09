package com.stc.sns.visualization.api.data;

import com.stc.sns.visualization.mybatis.domain.BaseRequestParamVO;
import com.stc.sns.visualization.mybatis.service.DataService;
import com.stc.sns.visualization.security.tokens.PostAuthorizationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@PreAuthorize("hasRole('ROLE_USER')")
@RestController
@RequestMapping("/api/data")
public class DataController {

    private static final Logger log = LoggerFactory.getLogger(DataController.class);

    @Autowired
    private DataService dataService;


    @GetMapping("/v1.0/original/documents/{keyword}")
    public List<Map<String, String>> searchOriginalWebDocument(Authentication authentication
            , @PathVariable("keyword")      String keyword
            , @ModelAttribute("BaseRequestParamVO") BaseRequestParamVO paramVO) {
        PostAuthorizationToken token = (PostAuthorizationToken)authentication;

        paramVO.setKeyword(keyword);
        paramVO.setCustId(token.getAccount().getCustId());
        return dataService.searchOriginalWebDocument(paramVO);
    }
}
