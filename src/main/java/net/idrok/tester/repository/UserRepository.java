package net.idrok.tester.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.idrok.tester.entity.Role;
import net.idrok.tester.entity.User;

public interface UserRepository extends JpaRepository <User, Long> {
    Page<User> findAllByIsmContainingIgnoreCaseOrFamiliyaContainingIgnoreCase(String k1, String k2, Pageable pageable);
    

    List<User> findByRole(Role role);

     default List<User> findByRoleADMIN(){
        return this.findByRole(Role.ADMIN);
     }


     @Query("FROM User u WHERE u.role = net.idrok.tester.entity.Role.USER")
     List<User> findbyRole();
}
