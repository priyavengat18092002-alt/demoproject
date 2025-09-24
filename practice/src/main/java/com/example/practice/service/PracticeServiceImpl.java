package com.example.practice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.practice.entity.PracticeEntity;
import com.example.practice.repository.PracticeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PracticeServiceImpl implements PracticeService {

    private final PracticeRepository practiceRepository;

    @Override
    public PracticeEntity newUser(PracticeEntity entity) {
        return practiceRepository.save(entity);
    }

  
    @Override
    public List<PracticeEntity> getUsers() {
        return practiceRepository.findAll();
    }

   
    @Override
    public PracticeEntity getUser(String id) {
        return practiceRepository.findById(id).orElse(null);
    }

   
    @Override
    public PracticeEntity updateUser(String id, PracticeEntity entity) {
        return practiceRepository.findById(id)
                .map(existing -> {
                    existing.setEmpid(entity.getEmpid());
                    existing.setName(entity.getName());
                    existing.setAge(entity.getAge());
                   
                    return practiceRepository.save(existing);
                })
                .orElse(null); 
    }

    @Override
    public void deleteUser(String id) {
        practiceRepository.deleteById(id);
    }
}
