package com.example.trainMarch.requests;

import lombok.Data;

@Data
public class postCreateRequest {
    Long id;
    String title;
    String text;
    Long userId;
}
