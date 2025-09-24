package com.example.practice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.practice.entity.PracticeEntity;
public interface PracticeRepository extends MongoRepository<PracticeEntity,String>{
    
}
