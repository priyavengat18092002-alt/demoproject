package com.example.practice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.entity.PracticeEntity;
import com.example.practice.genericresponse.GenericResponse;
import com.example.practice.service.PracticeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/practice")
@RequiredArgsConstructor

public class PracticeController {

    private final PracticeService practiceService;
    

    @PostMapping()
    public ResponseEntity<GenericResponse<PracticeEntity>> newUser(@RequestBody PracticeEntity entity) {
        try {
            PracticeEntity post = practiceService.newUser(entity);
            return ResponseEntity.ok(GenericResponse.success(post, "Created successfully"));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponse.error(null, "Failed to create: " + ex.getMessage()));
        }
    }
    @GetMapping()
    public ResponseEntity<GenericResponse<List<PracticeEntity>>> getUsers() {
        try {
            List<PracticeEntity> list = practiceService.getUsers();
            return ResponseEntity.ok(GenericResponse.success(list, "Fetched successfully"));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponse.error(null, "Failed to fetch: " + ex.getMessage()));
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<PracticeEntity>> getUsers(@PathVariable String id) {
        try {
            PracticeEntity user = practiceService.getUser(id); 
            return ResponseEntity.ok(GenericResponse.success(user, "Fetched successfully"));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(GenericResponse.error(null, ex.getMessage()));
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<PracticeEntity>> updateUser(
            @PathVariable String id,
            @RequestBody PracticeEntity entity) {
        try {
            PracticeEntity updated = practiceService.updateUser(id, entity);
            return ResponseEntity.ok(GenericResponse.success(updated, "Updated successfully"));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(GenericResponse.error(null, ex.getMessage()));
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse<Void>> deleteUser(@PathVariable String id) {
        try {
            practiceService.deleteUser(id);
            return ResponseEntity.ok(GenericResponse.success(null, "Deleted successfully"));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(GenericResponse.error(null, ex.getMessage()));
        }
    }
}
