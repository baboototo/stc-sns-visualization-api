package com.stc.sns.visualization.api.chart;

import com.stc.sns.visualization.mybatis.domain.BaseChartVO;
import com.stc.sns.visualization.mybatis.domain.BaseRequestParamVO;
import com.stc.sns.visualization.mybatis.domain.BaseResultChartVO;
import com.stc.sns.visualization.mybatis.domain.ChartType;
import com.stc.sns.visualization.mybatis.service.PieService;
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
@RequestMapping("/api/pie")
public class PieController {

    private static final Logger log = LoggerFactory.getLogger(PieController.class);

    @Autowired
    private PieService pieService;

    /**
     * 키워드에 해당하는 채널별 추이 조회
     * @param authentication
     * @param paramVO
     * @return
     */
    @GetMapping("/v1.0/channels/{keyword}")
    public BaseResultChartVO searchChannelTotalByKeyword(Authentication authentication
                                            , @PathVariable("keyword") String keyword
                                            , @ModelAttribute("BaseRequestParamVO") BaseRequestParamVO paramVO) {
        PostAuthorizationToken token = (PostAuthorizationToken)authentication;
        paramVO.setCustId(token.getAccount().getCustId());
        paramVO.setKeyword(keyword);

        List<BaseChartVO> chartVOList = pieService.searchChannelTotalByKeyword(paramVO);
        return new BaseResultChartVO(ChartType.PIE.getChartName(), chartVOList);
    }

    /**
     * 특정채널에 해당하는 키워드의 채널 상세정보 추이 목록 조회
     * @param authentication
     * @param paramVO
     * @return
     */
    @GetMapping("/v1.0/channels/{chnlCd}/{keyword}")
    public BaseResultChartVO searchChannelDetailTotalByKeyword(Authentication authentication
            , @PathVariable("chnlCd") String chnlCd
            , @PathVariable("keyword") String keyword
            , @ModelAttribute("BaseRequestParamVO") BaseRequestParamVO paramVO) {
        PostAuthorizationToken token = (PostAuthorizationToken)authentication;
        paramVO.setCustId(token.getAccount().getCustId());
        paramVO.setChnlCd(chnlCd);
        paramVO.setKeyword(keyword);

        List<BaseChartVO> chartVOList = pieService.searchChannelDetailTotalByKeyword(paramVO);
        return new BaseResultChartVO(ChartType.PIE.getChartName(), chartVOList);
    }

}
