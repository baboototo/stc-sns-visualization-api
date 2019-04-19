package com.stc.sns.visualization.api.topic;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("hasRole('ROLE_USER')")
@RestController
@RequestMapping("/api/topic")
public class TopicController {


}
