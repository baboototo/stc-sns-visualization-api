package com.stc.sns.visualization.mybatis.service;

import com.stc.sns.visualization.jpa.domain.channel.BigLclsChnl;
import com.stc.sns.visualization.jpa.domain.channel.BigLclsChnlRepository;
import com.stc.sns.visualization.mybatis.domain.BaseRequestParamVO;
import com.stc.sns.visualization.mybatis.domain.DataZoomChartVO;
import com.stc.sns.visualization.mybatis.domain.DataZoomResultChartVO;
import com.stc.sns.visualization.mybatis.mapper.DataZoomMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataZoomService {

    private static final Logger log = LoggerFactory.getLogger(DataZoomService.class);

    @Autowired
    private DataZoomMapper dataZoomMapper;

    @Autowired
    private BigLclsChnlRepository bigLclsChnlRepository;


    public DataZoomResultChartVO searchChannelByDays(BaseRequestParamVO paramVO) {

        Map<String, List<DataZoomChartVO>> searchDataMap = new HashMap<>();
        List<String> legend = new ArrayList<>();

        /**
         * 채널 조회 및 채널에 해당하는 DataZoom 데이터 조회
         */
        List<BigLclsChnl> chnlList = bigLclsChnlRepository.findAll();
        chnlList.forEach(bigLclsChnl -> {
            // Legend 데이터 생성
            legend.add(bigLclsChnl.getChnlLclsNm());

            // 채널에 해당하는 DataZoom 데이터 조회
            paramVO.setChnlCd(bigLclsChnl.getChnlLclsCd());
            searchDataMap.put(bigLclsChnl.getChnlLclsNm(), this.dataZoomMapper.searchChannelByDays(paramVO));
        });

        /**
         * DataZoom 차트 데이터 생성
         */
        Map<String, List<Long>> seriesData = new HashMap<>();
        List<String> xAxisList = new ArrayList<>();
        legend.forEach(channelName -> {

            // DataZoom X축 기준 데이터 생성
            int idx = legend.indexOf(channelName);
            if (idx == 0) {
                List<DataZoomChartVO> dataZoomChartVOList = searchDataMap.get(channelName);
                dataZoomChartVOList.forEach(dataZoomChartVO -> {
                    xAxisList.add(dataZoomChartVO.getXAxis());
                });
            }

            // DataZoom Series 데이터 생성
            List<Long> seriesValueList = new ArrayList<>();
            List<DataZoomChartVO> dataZoomChartVOList = searchDataMap.get(channelName);
            dataZoomChartVOList.forEach(dataZoomChartVO -> {
                seriesValueList.add(dataZoomChartVO.getSeriesValue());
            });

            seriesData.put(channelName, seriesValueList);
        });

        return new DataZoomResultChartVO(legend, xAxisList, seriesData);
    }
}
