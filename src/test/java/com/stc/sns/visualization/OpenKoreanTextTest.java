package com.stc.sns.visualization;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openkoreantext.processor.OpenKoreanTextProcessorJava;
import org.openkoreantext.processor.phrase_extractor.KoreanPhraseExtractor;
import org.openkoreantext.processor.tokenizer.KoreanTokenizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import scala.collection.Seq;

import java.util.List;

@SpringBootTest
@ActiveProfiles("local-live")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    // DB 사용 설정
@RunWith(SpringRunner.class)
public class OpenKoreanTextTest {

    private static final Logger log = LoggerFactory.getLogger(OpenKoreanTextTest.class);

    @Test
    public void Test() {

        String text = "BTS방탄소년단야동#방소";

        // Normalize
        CharSequence normalized = OpenKoreanTextProcessorJava.normalize(text);
        System.out.println(normalized);
        // 한국어를 처리하는 예시입니다ㅋㅋ #한국어

        // Tokenize
        Seq<KoreanTokenizer.KoreanToken> tokens = OpenKoreanTextProcessorJava.tokenize(normalized);
        System.out.println(OpenKoreanTextProcessorJava.tokensToJavaStringList(tokens));
        // [한국어, 를, 처리, 하는, 예시, 입니, 다, ㅋㅋ, #한국어]
        System.out.println(OpenKoreanTextProcessorJava.tokensToJavaKoreanTokenList(tokens));
        // [한국어(Noun: 0, 3), 를(Josa: 3, 1), 처리(Noun: 5, 2), 하는(Verb(하다): 7, 2), 예시(Noun: 10, 2),
        // 입니다(Adjective(이다): 12, 3), ㅋㅋㅋ(KoreanParticle: 15, 3), #한국어(Hashtag: 19, 4)]

        // Phrase extraction
        List<KoreanPhraseExtractor.KoreanPhrase> phrases = OpenKoreanTextProcessorJava.extractPhrases(tokens, true, true);
        System.out.println(phrases);
        // [한국어(Noun: 0, 3), 처리(Noun: 5, 2), 처리하는 예시(Noun: 5, 7), 예시(Noun: 10, 2), #한국어(Hashtag: 18, 4)]

        phrases = OpenKoreanTextProcessorJava.extractPhrases(tokens, false, true);
        System.out.println(phrases);

        phrases = OpenKoreanTextProcessorJava.extractPhrases(tokens, true, false);
        System.out.println(phrases);

        log.info("--------------------------------");
        for (KoreanPhraseExtractor.KoreanPhrase koreanPhrase : phrases) {
            log.info(koreanPhrase.productPrefix());
            log.info(koreanPhrase.text());
            log.info(koreanPhrase.toString());
        }
        log.info("--------------------------------");

    }
}
