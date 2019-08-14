package com.stc.sns.visualization.common;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.util.common.model.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Komoran 형태소 분석 사용 Util
 */
public class KomoranUtils {

    private static final Logger log = LoggerFactory.getLogger(KomoranUtils.class);

    private KomoranUtils(){}

    public static Komoran getInstance() {
        return KomoranInstance.instance;
    }

    private static class KomoranInstance {
        public static final Komoran instance = new Komoran(DEFAULT_MODEL.FULL);
    }


    /**
     * 키워드 형태소 분석 후 사전목록 반환
     * @param keyword
     * @return
     */
    public static List<String> analyzeKeywordList(String keyword) {
        List<String> keywordList = new ArrayList<>();

        KomoranResult analyzeResultList = KomoranUtils.getInstance().analyze(keyword);
        for (Pair<String, String> data : analyzeResultList.getList()) {
            keywordList.add(data.getFirst());
        }

        return keywordList;
    }
}
