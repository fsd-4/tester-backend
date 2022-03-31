package net.idrok.tester;

import net.idrok.tester.entity.Role;
import net.idrok.tester.entity.User;
import net.idrok.tester.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@SpringBootApplication
public class TesterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesterApplication.class, args);	
	}

	@Autowired
	UserRepository userRepository;


	@PostConstruct
	public void birlamchiAdminlarniBelgilash(){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		if(userRepository.findByLogin("admin123").isEmpty()){
			User user = new User();
			user.setIsm("Administrator");
			user.setLogin("admin123");
			user.setParol(encoder.encode("admin123"));
			user.setAktiv(true);
			user.setRegVaqt(LocalDateTime.now());
			user.setRole(Role.ADMIN);
			userRepository.save(user);
		}
	}

}
