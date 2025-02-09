package com.example.demo.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum HeaderEnum {

    CONTENT_TYPE("Content-Type", "image/png");

    private final String headerName;
    private final String headerValue;
}
