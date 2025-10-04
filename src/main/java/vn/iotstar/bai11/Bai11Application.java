package vn.iotstar.bai11;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import vn.iotstar.bai11.entity.ERole;
import vn.iotstar.bai11.entity.Role;
import vn.iotstar.bai11.repository.RoleRepository;

@SpringBootApplication
public class Bai11Application {

        public static void main(String[] args) {
                SpringApplication.run(Bai11Application.class, args);
        }

        @Bean
        CommandLineRunner initRoles(RoleRepository roleRepository) {
                return args -> {
                        for (ERole role : ERole.values()) {
                                roleRepository.findByName(role).orElseGet(() -> roleRepository.save(new Role(null, role)));
                        }
                };
        }

}
