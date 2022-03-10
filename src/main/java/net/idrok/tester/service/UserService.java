package net.idrok.tester.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.idrok.tester.entity.User;
import net.idrok.tester.repository.UserRepository;

public class UserService {
    @Autowired
    UserRepository userRepository;

    public Page<User> getAll(String key, Pageable pageable) {
        return userRepository.findAllByIsmContainingIgnoreCaseOrFamiliyaContainingIgnoreCase(key, key,pageable);
    }

    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    public User create(User user) {
        if (user.getId() == null)
            return userRepository.save(user);
        throw new RuntimeException("id null bo'lishi zarur");
    }

    public User update(User user) {
        if (user.getId() != null)
          return  userRepository.save(user);
        throw new RuntimeException("id null bo'lishi zarur");
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public void deleteById(Long fanId) {
        userRepository.deleteById(fanId);
    }
}
