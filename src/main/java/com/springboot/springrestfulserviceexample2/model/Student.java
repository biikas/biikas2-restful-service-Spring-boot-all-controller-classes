package com.springboot.springrestfulserviceexample2.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private int id;
    private String username;
    private String password;
}
