package com.stc.sns.visualization;

import com.stc.sns.visualization.common.KomoranUtils;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@ActiveProfiles("local-live")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    // DB 사용 설정
@RunWith(SpringRunner.class)
public class KomoranTest {

    private static final Logger log = LoggerFactory.getLogger(KomoranTest.class);

    @Test
    public void KomoranUtilSingletonTest() {
        List<String> analyzeList = KomoranUtils.analyzeKeywordList("광주세계선수권대회");
        for (String title : analyzeList) {
            log.info(title);
        }
    }

    @Test
    public void Test() {
        Komoran komoran = KomoranUtils.getInstance();

        KomoranResult analyzeResultList = komoran.analyze("부산코미디페스티벌NAVER");

        List<Token> tokenList = analyzeResultList.getTokenList();

        // 1. print each tokens by getTokenList()
        log.info("==========print 'getTokenList()'==========");
        for (Token token : tokenList) {
            log.info(token.toString());
            log.info(token.getMorph()+"/"+token.getPos()+"("+token.getBeginIndex()+","+token.getEndIndex()+")");

        }

        // 2. print nouns
        log.info("==========print 'getNouns()'==========");
        log.info(analyzeResultList.getNouns().toString());


        // 3. print analyzed result as pos-tagged text
        log.info("==========print 'getPlainText()'==========");
        log.info(analyzeResultList.getPlainText());


        // 4. print analyzed result as list
        log.info("==========print 'getList()'==========");
        log.info(analyzeResultList.getList().toString());


        // 5. print morphes with selected pos
        log.info("==========print 'getMorphesByTags()'==========");
        log.info(analyzeResultList.getMorphesByTags("NNG", "NNP", "NNB", "SL").toString());
    }
}
