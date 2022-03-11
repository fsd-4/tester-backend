package net.idrok.tester.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.idrok.tester.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
