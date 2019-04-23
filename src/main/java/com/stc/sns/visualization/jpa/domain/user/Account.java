package com.stc.sns.visualization.jpa.domain.user;

import com.stc.sns.visualization.jpa.domain.common.BaseDomain;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "ACCOUNT")
public class Account extends BaseDomain implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "PASSWORD")
    private String password;


    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_ROLE")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Builder
    public Account(String userId, String password, String userName, UserRole userRole) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.userRole = userRole;
    }
}
