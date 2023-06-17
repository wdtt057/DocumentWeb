package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter @Setter @NoArgsConstructor
public class Document {
    private Integer id;
    private String content;
}
