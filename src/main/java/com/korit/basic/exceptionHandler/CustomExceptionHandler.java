package com.korit.basic.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomExceptionHandler {
  
  // @ExceptionHandler: 지정한 예외에 대하여 직접 조작할 수 있게 함
  // @ExceptionHandler(value={예외클래스, ...})
  @ExceptionHandler(value={MethodArgumentNotValidException.class})
  public ResponseEntity<String> customException(
    MethodArgumentNotValidException exception
  ){
    exception.printStackTrace();
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("잘못된 입력입니다.");
  }
}
