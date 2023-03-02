package kabbee.miu.videostreamingproject.AOP;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import kabbee.miu.videostreamingproject.ExceptionHandling.ExceptionHandling;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class UserControllerAdvice {

//   @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<?> handleConstraintEx(ConstraintViolationException ex){
//       List<String> errorMessages= ex.getConstraintViolations().stream()
//               .map(ConstraintViolation::getMessage).toList();
//
//       ExceptionHandling response=new ExceptionHandling(errorMessages);
//      System.out.println("pirvnt soth" +
//              "");
//       return ResponseEntity.badRequest().body(response);
//   }

   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
      List<String> errorMessages =ex.getBindingResult().getAllErrors().stream()
              .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());

      ExceptionHandling response=new ExceptionHandling(errorMessages);

       return ResponseEntity.badRequest().body(response.toString());
     //return ResponseEntity.badRequest().body(errorMessages.toString());
   }


}
