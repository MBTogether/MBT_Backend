package com.example.mbtogether.domain.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="USERS")
public class User {

    @Id
    @Column(length = 30)
    private String id;

    @Column(length = 200, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String nickname;

    @Column(length = 100, nullable = false)
    private String email;

}
