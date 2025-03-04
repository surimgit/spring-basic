package com.korit.basic.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.korit.basic.dto.ResponseDto;

@RestController
public class CustomExceptionHandler {
  
  // @ExceptionHandler: 지정한 예외에 대하여 직접 조작할 수 있게 함
  // @ExceptionHandler(value={예외클래스, ...})
  @ExceptionHandler(value={
    MethodArgumentNotValidException.class,
    HttpMessageNotReadableException.class
  })
  public ResponseEntity<ResponseDto> customException(
    Exception exception
  ){
    exception.printStackTrace();
    ResponseDto responseBody = new ResponseDto("VF", "Validation Failed.");
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
  }
}
