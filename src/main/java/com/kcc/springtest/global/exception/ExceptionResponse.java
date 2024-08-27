package com.kcc.springtest.global.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.net.URL;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExceptionResponse {
    private String path;
    private Map<String, String> messages;
    private HttpStatus status;
    private String timestamp;
}
