package com.korit.basic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Cors 정책: Cross origin Resource Sharing으로
// 웹 브라우저의 스크립트로 출처가 서로 다른 곳으로 자원을 공유할 때 지정된 정책
// - 출처(Origin): 프로토콜, 호스트, 포트가 출처에 해당
// - 출처가 서로 다른 위치에 스크립트로요청을 보내면 일반적으론 Cors 정책에 의해 막힘

// @Configuration: 생성자나 메서드가 호출 시 Spring Bean으로 등록될 수 있도록 하는 어노테이션
@Configuration
// WebMvcConfigurer 인터페이스를 구현하여 웹 서비스의 기본 설정을 변경 가능
public class CorsConfig implements WebMvcConfigurer{
  
  // CORS 정책 설정을 변경할 수 있는 메서드
  @Override
  public void addCorsMappings(CorsRegistry corsRegistry){
    corsRegistry.addMapping("/**")
    .allowedOrigins("*")
    .allowedMethods("*");
      // addMapping(): 특정 패턴을 지정
      
      // allowedOrigin(): 허용할 출처를 지정
      
      // allowedMethods(): 허용할 HTTP method를 지정
    }
}
