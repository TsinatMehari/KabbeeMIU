package kabbee.miu.videostreamingproject;

import kabbee.miu.videostreamingproject.domain.Address;
import kabbee.miu.videostreamingproject.domain.Contact;
import kabbee.miu.videostreamingproject.domain.User;
import kabbee.miu.videostreamingproject.service.UserServiceImpl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class VideoStreamingProjectApplication implements CommandLineRunner {

    @Autowired
    UserServiceImpl userService;


    public static void main(String[] args) {
        SpringApplication.run(VideoStreamingProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Contact contact= new Contact("123","abule@gmail.com");
        Address address=new Address("s","city","ca","12334");
        User aa=new User(1L,"abi","zaki",45,"user","abule","1234",contact,address);

        userService.register(aa);
    }
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
