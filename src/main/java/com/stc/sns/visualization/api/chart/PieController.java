package com.stc.sns.visualization.api.chart;

import com.stc.sns.visualization.mybatis.domain.BaseChartVO;
import com.stc.sns.visualization.mybatis.domain.BaseRequestParamVO;
import com.stc.sns.visualization.mybatis.domain.ChartType;
import com.stc.sns.visualization.mybatis.domain.BaseResultChartVO;
import com.stc.sns.visualization.mybatis.service.PieService;
import com.stc.sns.visualization.security.tokens.PostAuthorizationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@PreAuthorize("hasRole('ROLE_USER')")
@RestController
@RequestMapping("/api/pie")
public class PieController {

    private static final Logger log = LoggerFactory.getLogger(PieController.class);

    @Autowired
    private PieService pieService;

    @GetMapping("/v1.0/channels")
    public BaseResultChartVO searchChannel(Authentication authentication
                                            , @ModelAttribute("BaseRequestParamVO") BaseRequestParamVO paramVO) {
        PostAuthorizationToken token = (PostAuthorizationToken)authentication;
        paramVO.setCustId(token.getAccount().getCustId());

        List<BaseChartVO> chartVOList = pieService.searchChannelTotalByKeyword(paramVO);
        return new BaseResultChartVO(ChartType.PIE.getChartName(), chartVOList);
    }

}
