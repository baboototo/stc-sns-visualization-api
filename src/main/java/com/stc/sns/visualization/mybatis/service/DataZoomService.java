package com.stc.sns.visualization.mybatis.service;

import com.stc.sns.visualization.jpa.domain.channel.BigMclsChnlRepositoryImpl;
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
    private BigMclsChnlRepositoryImpl bigMclsChnlRepository;



    /**
     * 채널별 수집 추이 일별 데이터 조회
     * @param paramVO
     * @return
     */
    public DataZoomResultChartVO searchChannelCollectionByDays(BaseRequestParamVO paramVO) {

        Map<String, List<Long>> seriesDataMap = new HashMap<>();

        List<String> legendList = new ArrayList<>();
        List<String> xAxisList = new ArrayList<>();
        List<Long> seriesDataList;

        List<String> searchChannelList = paramVO.getChannels();
        for (String channelCode : searchChannelList) {

            // 채널별 데이터 조회
            paramVO.setChnlCd(channelCode);
            List<DataZoomChartVO> searchChannelDataList = this.dataZoomMapper.searchChannelCollectionByDays(paramVO);

            if (searchChannelDataList.size() > 0) {

                DataZoomChartVO channelData = searchChannelDataList.get(0);

                // Legend 등록
                legendList.add(channelData.getSeries());

                // xAxis 등록
                if (searchChannelList.indexOf(channelCode) == 0) {
                    for (DataZoomChartVO baseData : searchChannelDataList) {
                        xAxisList.add(baseData.getXAxis());
                    }
                }

                // series 등록
                seriesDataList = new ArrayList<>();
                for (DataZoomChartVO seriesData : searchChannelDataList) {
                    seriesDataList.add(seriesData.getSeriesValue());
                }
                seriesDataMap.put(channelData.getSeries(), seriesDataList);
            }
        }

        return new DataZoomResultChartVO(legendList, xAxisList, seriesDataMap);
    }


    /**
     * 특정채널에 해당하는 키워드의 채널 상세정보 수집 추이 일별 데이터 조회
     * @param paramVO
     * @return
     */
    public DataZoomResultChartVO searchChannelDetailCollectionByDays(BaseRequestParamVO paramVO) {
        Map<String, List<Long>> seriesDataMap = new HashMap<>();

        List<String> legendList = new ArrayList<>();
        List<String> xAxisList = new ArrayList<>();
        List<Long> seriesDataList;

        List<String> searchChannelList = bigMclsChnlRepository.findByMclsCd(paramVO.getChnlCd());
        for (String channelCode : searchChannelList) {

            // 채널별 데이터 조회
            paramVO.setChnlCd(channelCode);
            List<DataZoomChartVO> searchChannelDataList = this.dataZoomMapper.searchChannelDetailCollectionByDays(paramVO);

            if (searchChannelDataList.size() > 0) {

                DataZoomChartVO channelData = searchChannelDataList.get(0);

                // Legend 등록
                legendList.add(channelData.getSeries());

                // xAxis 등록
                if (searchChannelList.indexOf(channelCode) == 0) {
                    for (DataZoomChartVO baseData : searchChannelDataList) {
                        xAxisList.add(baseData.getXAxis());
                    }
                }

                // series 등록
                seriesDataList = new ArrayList<>();
                for (DataZoomChartVO seriesData : searchChannelDataList) {
                    seriesDataList.add(seriesData.getSeriesValue());
                }
                seriesDataMap.put(channelData.getSeries(), seriesDataList);
            }
        }

        return new DataZoomResultChartVO(legendList, xAxisList, seriesDataMap);
    }


}
