package com.example.mbtogether.global.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PagingResponse<T> {

    private final long totalElements;
    private final List<T> contents;

}