package kabbee.miu.videostreamingproject.controller;

import jakarta.validation.Valid;
import kabbee.miu.videostreamingproject.ExceptionHandling.ExceptionHandling;
import kabbee.miu.videostreamingproject.domain.User;
import kabbee.miu.videostreamingproject.service.UserInterfaceService;
import kabbee.miu.videostreamingproject.service.UserServiceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Validated
public class UserController {

   private final UserInterfaceService userInterfaceService;
   private final PasswordEncoder passwordEncoder;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id ){
        var user=userInterfaceService.findById(id);
        if (user == null) {
            return new ResponseEntity<>(new ExceptionHandling("not available"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>( user, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody  User user){
        String encodedPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
     var userRegistered =   userInterfaceService.register(user);
        System.out.println("abule");
        if (userRegistered == null) {
            return new ResponseEntity<>(new ExceptionHandling("not Registered"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userRegistered,HttpStatus.OK);
    }

}
