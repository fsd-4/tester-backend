package net.idrok.tester.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import net.idrok.tester.entity.Role;
import net.idrok.tester.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.idrok.tester.entity.User;
import net.idrok.tester.repository.UserRepository;
import net.idrok.tester.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;

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
        if(entity.getId() == null){
            entity.setRole(Role.USER);
            entity.setRegVaqt(LocalDateTime.now());
            entity.setOxirgiTashrif(LocalDateTime.now());
            entity.setAktiv(true);
            entity.setParol(encoder.encode(entity.getParol()));
            return userRepository.save(entity);
        }
        throw new RuntimeException("id null bo'lsihi shart");
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

    @Override
    public UserDTO getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth.getPrincipal() instanceof UserDetails){
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            User u = userRepository.findByLogin(userDetails.getUsername()).orElseThrow(()->  new RuntimeException("not found"));
            return new UserDTO(u);
        }
        throw new RuntimeException("not found");
    }
}
