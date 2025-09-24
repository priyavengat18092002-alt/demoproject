package com.example.practice.service;

import java.util.List;

import com.example.practice.entity.PracticeEntity;

public interface PracticeService {
    PracticeEntity newUser(PracticeEntity entity);
    List<PracticeEntity> getUsers();
    PracticeEntity getUser(String id);
    PracticeEntity updateUser(String id, PracticeEntity entity);
    void deleteUser(String id);
}
