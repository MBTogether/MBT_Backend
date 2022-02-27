package com.example.mbtogether.domain.entity;

import lombok.*;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

import javax.persistence.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="USER")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String oauthId;

    @Column(nullable = false)
    private String oauthType;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String introduction;

    @Column(nullable = false)
    private String mbti;

    @Column(nullable = false)
    private String authority;

}
