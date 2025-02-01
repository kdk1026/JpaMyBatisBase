# JPA와 MyBatis를 결합하여 사용하는 예제

단일 테이블 CRUD 작업은 JPA를 사용하고, 그 외의 작업은 MyBatis를 사용

## 설정

### 트랜잭션 매니저 설정
MyBatis 관련 트랜잭션 매니저 설정은 `MyBatisConfig` 클래스에서 수행
<br>
JPA 관련 트랜잭션 매니저 설정은 `JpaConfig` 클래스에서 수행

### 트랜잭션 매니저 참조
클래스 상단에 참조 설정
<br><br>
MyBatis 사용하는 Service는 @Transactional(transactionManager = "myBatisTransactionManager")
<br>
JPA 사용하는 Service는 @Transactional(transactionManager = "jpaTransactionManager")

### MyBatis 단독 설정 및 예제 참고 링크
[여기](https://github.com/kdk1026/MyBatisBase)에서 확인