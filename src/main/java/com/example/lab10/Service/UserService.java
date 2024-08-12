package com.example.lab10.Service;

import com.example.lab10.Model.User;
import com.example.lab10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public void addUser(User user) {
        userRepository.save(user);
    }
    public boolean updateUser(Integer id,User user) {
        User search = userRepository.getReferenceById(id);
        if(search != null) {
            search.setName(user.getName());
            search.setEmail(user.getEmail());
            search.setPassword(user.getPassword());
            search.setRole(user.getRole());
            userRepository.save(search);
            return true;
        }
        return false;
    }
    public boolean deleteUser(Integer id) {
        User search = userRepository.getReferenceById(id);
        if(search != null) {
            userRepository.delete(search);
            return true;
        }
        return false;
    }
}
