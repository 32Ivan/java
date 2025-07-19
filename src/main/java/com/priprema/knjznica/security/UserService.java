package com.priprema.knjznica.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private IUserRepo userRepo;

    public ResponseEntity<?> getUserById(int userId) {
        try {
            if (userRepo.findById(userId).isPresent()) {
                return new ResponseEntity<>(userRepo.findById(userId).get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Internal error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public ResponseEntity<?> deleteUser(int userId) {
        if (userRepo.findById(userId).isPresent()) {
            userRepo.deleteById(userId);
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        }

        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }

}