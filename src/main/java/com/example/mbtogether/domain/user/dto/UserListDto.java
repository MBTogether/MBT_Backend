package com.example.mbtogether.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserListDto {

    private Integer id;
    private String title;
    private String coverUrl;
    private LocalDate date;

}
