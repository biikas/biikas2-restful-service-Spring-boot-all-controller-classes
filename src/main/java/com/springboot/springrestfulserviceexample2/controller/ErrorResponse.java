package com.springboot.springrestfulserviceexample2.controller;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorResponse {
    private boolean success;
    private String message;
}
