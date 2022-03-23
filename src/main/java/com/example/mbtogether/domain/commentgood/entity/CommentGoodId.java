package com.example.mbtogether.domain.commentgood.entity;

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
public class CommentGoodId implements Serializable {

    @Column(nullable = false)
    private String commentId;

    @Column(nullable = false)
    private String userId;

}
