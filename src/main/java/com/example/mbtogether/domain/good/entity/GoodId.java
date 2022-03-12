package com.example.mbtogether.domain.good.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class GoodId implements Serializable {

    @Column(nullable = false)
    private String postId;

    @Column(nullable = false)
    private String userId;

}
