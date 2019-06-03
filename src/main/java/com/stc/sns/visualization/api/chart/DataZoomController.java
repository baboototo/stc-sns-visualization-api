package com.stc.sns.visualization.api.chart;

import com.stc.sns.visualization.mybatis.domain.BaseRequestParamVO;
import com.stc.sns.visualization.mybatis.domain.DataZoomResultChartVO;
import com.stc.sns.visualization.mybatis.service.DataZoomService;
import com.stc.sns.visualization.security.tokens.PostAuthorizationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("hasRole('ROLE_USER')")
@RestController
@RequestMapping("/api/dataZoom")
public class DataZoomController {

    private static final Logger log = LoggerFactory.getLogger(DataZoomController.class);

    @Autowired
    private DataZoomService dataZoomService;

    @GetMapping("/v1.0/channel/days/{keyword}")
    public DataZoomResultChartVO searchChannelByDays(Authentication authentication
                                            , @PathVariable("keyword") String keyword
                                            , @ModelAttribute("BaseRequestParamVO") BaseRequestParamVO paramVO) {
        PostAuthorizationToken token = (PostAuthorizationToken)authentication;

        paramVO.setCustId(token.getAccount().getCustId());
        paramVO.setKeyword(keyword);

        return this.dataZoomService.searchChannelByDays(paramVO);
    }



}
