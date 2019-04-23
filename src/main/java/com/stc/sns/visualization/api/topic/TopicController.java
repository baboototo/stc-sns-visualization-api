package com.stc.sns.visualization.api.topic;

import com.stc.sns.visualization.jpa.domain.topic.BigTpcRstRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("hasRole('ROLE_USER')")
@RestController
@RequestMapping("/api/topic")
public class TopicController {

    @Autowired
    private BigTpcRstRepository bigTpcRstRepository;

}
