package com.korit.basic.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.korit.basic.dto.PostUserRequestDto;
import com.korit.basic.dto.ResponseDto;
import com.korit.basic.entity.UserEntity;
import com.korit.basic.repository.UserRepository;
import com.korit.basic.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {

  private final UserRepository userRepository;

  @Override
  public ResponseEntity<ResponseDto> postUser(PostUserRequestDto dto) {
    
    String userId = dto.getUserId();
    boolean isExistUserId = userRepository.existsById(userId);
    if (isExistUserId) {
      ResponseDto responseBody = new ResponseDto("DI", "Duplicated Id.");
      return ResponseEntity
        .status(HttpStatus.BAD_REQUEST).body(responseBody);
    }


    String userTelNumber = dto.getUserTelNumber();
    boolean isExistUserTelNumber = userRepository.existsByUserTelNumber(userTelNumber);
    if (isExistUserTelNumber) {
      ResponseDto responseBody = new ResponseDto("DT", "Duplicated Tel number.");
      return ResponseEntity
        .status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    // UserEntity userEntity = new UserEntity(userId, dto.getUserPassword(), dto.getUserName(), dto.getUserAddress(), userTelNumber);
    
    // 빌더 패턴: 객체 생성 과정에 멤버변수 별로 객체를 구성한 후 객체를 생성할 수 있도록 도움을 주는 생성패턴
    // UserEntity userEntity =
    //   UserEntity
    //   .builder()
    //   .userId(userId)
    //   .userPassword(dto.getUserPassword())
    //   .userName(dto.getUserName())
    //   .userAddress(dto.getUserAddress())
    //   .userTelNumber(userTelNumber)
    //   .build();

    UserEntity userEntity = new UserEntity(); 
    userRepository.save(userEntity);

    ResponseDto response = new ResponseDto("SU", "Success.");
    return ResponseEntity.status(HttpStatus.CREATED).body(response);

  }
  
}