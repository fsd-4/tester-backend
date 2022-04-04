package net.idrok.tester.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.idrok.tester.entity.User;
import net.idrok.tester.repository.UserRepository;
import net.idrok.tester.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll(String key) {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        // TODO Auto-generated method stub
        return userRepository.findById(id).get();
    }

    @Override
    public User create(User entity) {
        // TODO Auto-generated method stub
        return userRepository.save(entity);
    }

    @Override
    public User update(User entity) {
        // TODO Auto-generated method stub
        return userRepository.save(entity);
    }

    @Override
    public void delete(User entity) {
        // TODO Auto-generated method stub
        userRepository.delete(entity);
        
    }

    @Override
    public void deleteById(Long dataId) {
        // TODO Auto-generated method stub
        userRepository.deleteById(dataId);
        
    }

    @Override
    public Optional<User> getByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
