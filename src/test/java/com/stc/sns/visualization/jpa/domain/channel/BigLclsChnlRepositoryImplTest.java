package com.stc.sns.visualization.jpa.domain.channel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    // DB 사용 설정
public class BigLclsChnlRepositoryImplTest {

    @Autowired
    private BigLclsChnlRepository bigLclsChnlRepository;

    @Test
    public void searchBigLclsChnlList() {
        this.bigLclsChnlRepository.findById("10");
        this.bigLclsChnlRepository.findAll();

    }


}