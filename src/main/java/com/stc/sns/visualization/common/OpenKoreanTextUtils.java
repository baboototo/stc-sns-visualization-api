package com.stc.sns.visualization.common;

import org.openkoreantext.processor.OpenKoreanTextProcessorJava;
import org.openkoreantext.processor.phrase_extractor.KoreanPhraseExtractor;
import org.openkoreantext.processor.tokenizer.KoreanTokenizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.collection.Seq;

import java.util.ArrayList;
import java.util.List;

/**
 * Open Korean Text 형태소 분석 사용 Util
 */
public class OpenKoreanTextUtils {

    private static final Logger log = LoggerFactory.getLogger(OpenKoreanTextUtils.class);

    private OpenKoreanTextUtils(){}

    /**
     * 키워드 형태소 분석 후 사전목록 반환
     * @param keyword
     * @return
     */
    public static List<String> extractPhrases(String keyword) {
        CharSequence normalized = OpenKoreanTextProcessorJava.normalize(keyword);
        Seq<KoreanTokenizer.KoreanToken> tokens = OpenKoreanTextProcessorJava.tokenize(normalized);
        List<KoreanPhraseExtractor.KoreanPhrase> phrases = OpenKoreanTextProcessorJava.extractPhrases(tokens, true, false);

        List<String> keywordList = new ArrayList<>();
        for ( KoreanPhraseExtractor.KoreanPhrase koreanPhrase : phrases ) {
            keywordList.add(koreanPhrase.text());
        }
        return keywordList;
    }
}
