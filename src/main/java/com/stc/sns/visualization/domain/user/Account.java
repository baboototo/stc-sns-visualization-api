package com.stc.sns.visualization.domain.user;

import com.stc.sns.visualization.domain.common.BaseDomain;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "ACCOUNT")
public class Account extends BaseDomain implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "USER_ROLE")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Builder
    public Account(String userName, String userId, String password, UserRole userRole) {
        this.userName = userName;
        this.userId = userId;
        this.password = password;
        this.userRole = userRole;
    }
}
