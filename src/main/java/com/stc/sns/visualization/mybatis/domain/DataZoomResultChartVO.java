package com.stc.sns.visualization.mybatis.domain;

import com.stc.sns.visualization.util.StringUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
public class DataZoomResultChartVO {

    private List<String> xAxis;
    private List<String> legend;
    private List<DataZoomSeries> series;
    private List<List<Object>> webAccessibilityData;

    public DataZoomResultChartVO(List<String> legend, List<String> xAxis, Map<String, List<Long>> seriesData) {
        this.legend = legend;
        this.xAxis = xAxis;
        this.series = new ArrayList<>();

        if (this.legend.size() > 0) {
            this.legend.forEach(legendName -> {
                this.series.add(new DataZoomSeries(ChartType.LINE.getChartName(), legendName, seriesData.get(legendName)));
            });
        }

        webAccessibilityData = new ArrayList<>();

        // 시리즈 데이터만 추출
        int seriesCount = series.size();
        List<List<Long>> seriesList = new ArrayList<>();
        for (int seriesIdx = 0; seriesIdx < seriesCount; seriesIdx++) {
            seriesList.add(this.series.get(seriesIdx).getData());
        }

        // 웹접근성 데이터 생성
        int xAxisCount      = xAxis.size();
        int seriesListCount = seriesList.size();
        for (int xAxisIdx = 0; xAxisIdx < xAxisCount; xAxisIdx++) {

            List<Object> wsDataList = new ArrayList<>();
            wsDataList.add(StringUtils.formatDate(xAxis.get(xAxisIdx)));
            for (int seriesIdx = 0; seriesIdx < seriesListCount; seriesIdx++) {
                wsDataList.add(seriesList.get(seriesIdx).get(xAxisIdx));
            }

            webAccessibilityData.add(wsDataList);
        }

    }

    @Getter
    @Setter
    @NoArgsConstructor
    class DataZoomSeries {
        private String type;
        private String name;
        private List<Long> data;

        public DataZoomSeries(String type, String name, List<Long> data) {
            this.type = type;
            this.name = name;
            this.data = data;
        }
    }
}


