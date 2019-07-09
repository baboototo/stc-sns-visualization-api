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

    /**
     * 채널별 수집 추이 일별 데이터 조회
     * @param authentication
     * @param keyword
     * @param paramVO
     * @return
     */
    @GetMapping("/v1.0/channels/collection/days/{keyword}")
    public DataZoomResultChartVO searchChannelCollectionByDays(Authentication authentication
                                            , @PathVariable("keyword") String keyword
                                            , @ModelAttribute("BaseRequestParamVO") BaseRequestParamVO paramVO) {
        PostAuthorizationToken token = (PostAuthorizationToken)authentication;

        paramVO.setCustId(token.getAccount().getCustId());
        paramVO.setKeyword(keyword);

        return this.dataZoomService.searchChannelCollectionByDays(paramVO);
    }

    /**
     * 특정채널에 해당하는 키워드의 채널 상세정보 수집 추이 일별 데이터 조회
     * @param authentication
     * @param chnlCd
     * @param keyword
     * @param paramVO
     * @return
     */
    @GetMapping("/v1.0/channels/{chnlCd}/collection/days/{keyword}")
    public DataZoomResultChartVO searchChannelDetailCollectionByDays(Authentication authentication
            , @PathVariable("chnlCd") String chnlCd
            , @PathVariable("keyword") String keyword
            , @ModelAttribute("BaseRequestParamVO") BaseRequestParamVO paramVO) {
        PostAuthorizationToken token = (PostAuthorizationToken)authentication;

        paramVO.setCustId(token.getAccount().getCustId());
        paramVO.setKeyword(keyword);
        paramVO.setChnlCd(chnlCd);

        return this.dataZoomService.searchChannelDetailCollectionByDays(paramVO);
    }


//
}
