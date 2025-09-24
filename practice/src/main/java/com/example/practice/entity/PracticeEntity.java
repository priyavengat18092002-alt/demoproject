package com.example.practice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Document(collection="userInfo")
@RequiredArgsConstructor
public class PracticeEntity {
    @Id
    private String id;
    private Integer empid;
    private String name;
    private Integer age;
    
}
