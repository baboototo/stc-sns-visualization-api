package com.stc.sns.visualization.api.channel;

import com.stc.sns.visualization.domain.channel.BigLclsChnl;
import com.stc.sns.visualization.domain.channel.BigLclsChnlRepository;
import com.stc.sns.visualization.domain.channel.BigMclsChnl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("hasRole('ROLE_USER')")
@RestController
@RequestMapping("/api/channels")
public class ChannelController {

    @Autowired
    private BigLclsChnlRepository bigLclsChnlRepository;

    @GetMapping("/{chnlLclsCd}")
    public BigLclsChnl getGetLclsChnl(@PathVariable("chnlLclsCd") String chnlLclsCd) {
        return this.bigLclsChnlRepository.findById(chnlLclsCd).orElseThrow(() -> new ResourceNotFoundException(chnlLclsCd));
    }
}
