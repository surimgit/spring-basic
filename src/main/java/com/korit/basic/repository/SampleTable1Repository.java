package com.korit.basic.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.korit.basic.entity.SampleTable1Entity;

// Repository: 레이어
// - 데이터베이스 작업을 수행하는 영역

// @Repository: 해당 클래스를 Spring Bean으로 등록하는 어노테이션, @Component와 동일한 역할
// - interface에 @Repositoy를 적용한 이유:
// - JPA를 사용할 땐 해당 Interface의 구현체를 JPA가 자동으로 생성
@Repository
public interface SampleTable1Repository extends 
// JpaRepository 인터페이스
// - JPA 기반의 Repository를 구현하는 주요 인터페이스
// - 기본 CRUD 기능 및 정렬 기능등을 포함
// - JPA 기반의 Repository를 생성할 때는 필수로 상속받아야 함
// - JpaRepository 인터페이스는 두 개의 제너릭을(<T, ID>) 받음
// - 매개타입 T: 해당 Repository가 어떤 Entity의 Repository인지 지정
// - 매개타입 ID: 해당 Repository가 사용하는 Entity의 기본키 타입을 지정
JpaRepository<SampleTable1Entity, String>{
  
}
