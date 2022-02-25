package com.example.mbtogether.domain.entity;

import lombok.*;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

import javax.persistence.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="USERS")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(length = 30)
    private String oauth_id;

    @Column(length = 50)
    private String oauth_type;

    @Column(length = 20, nullable = false)
    private String nickname;

    @Column(length = 100)
    private String introduction;

    @Column(length = 7, nullable = false)
    private String mbti;

}
