package com.stc.sns.visualization.mybatis.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.parameters.P;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class DataZoomResultChartVO {

    private List<String> xAxis;
    private List<String> legend;
    private List<DataZoomSeries> series;


    public DataZoomResultChartVO(List<String> legend, List<String> xAxis, Map<String, List<Long>> seriesData) {
        this.legend = legend;
        this.xAxis = xAxis;
        this.series = new ArrayList<>();

        if (this.legend.size() > 0) {
            this.legend.forEach(legendName -> {
                this.series.add(new DataZoomSeries(ChartType.LINE.getChartName(), legendName, seriesData.get(legendName)));
            });
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


