package com.stc.sns.visualization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing
@SpringBootApplication
public class StcSnsVisualizationApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StcSnsVisualizationApiApplication.class, args);
    }

}
