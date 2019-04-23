package com.stc.sns.visualization.jpa.domain.topic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    // DB 사용 설정
public class BigTpcMstRepositoryImplTest {

    @Autowired
    private BigTpcMstRepository bigTpcMstRepository;

    @Test
    public void findAllById() {

        List<BigTpcMst> result = bigTpcMstRepository.findAllByAskNum("1");

        assertThat(result.size(), is(1));
        assertThat(result.get(0).getApiPrvdNm(), is("네이버(뉴스)"));
    }
}