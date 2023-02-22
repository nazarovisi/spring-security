package com.nazarov.springsecurity.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private int statusCode = 200;
    private String message = "success";
    private Object response;

}
