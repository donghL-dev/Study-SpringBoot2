Study-Spring Boot 2
===
* 최신 버전의 스프링 부트 2.0(또는 2.0 이후의 버전)에 대해 스터디를 진행하면서 자료를 정리해두기 위한 저장소입니다. 
* 스터디를 진행하면서 공부하는 책은 [처음 배우는 스프링 부트 2](http://www.hanbit.co.kr/store/books/look.php?p_code=B4458049183) 라는 책입니다.
* 위 책의 특징으로는 커뮤니티 게시판을 구현하며 배울 수 있도록 예제 중심으로 구성되어 있습니다.
* 2019 겨울방학 **Spring Boot 2 Study**
  * 인원 : [민경환](https://github.com/ber01/Study-Spring-Boot), [박동현](https://github.com/pdh6547/study-spring-boot), [신무곤](https://github.com/mkshin96/study-spring-boot), [신재홍](https://github.com/woghd9072/study-spring-boot), [양기석](https://github.com/yks095/study-spring-boot), [엄태균](https://github.com/etg6550/2019WinterProject), [임동훈](https://github.com/dongh9508/Study-SpringBoot2), [최광민](https://github.com/rhkd4560/Study-SpringBoot), [하상엽](https://github.com/hagome0/Study-Spring-Boot)

  * 스터디 진행 **방향** 및 **목적**
    
    * 스프링 부트의 기본 개념을 이해하고 커뮤니티 게시판 구축

    * 참여 인원 모두가 개인 프로젝트 진행
    * 용어 정리 및 공유, 소스코드 피드백 

* 스터디를 진행하며 모르는 용어는 [Keyword](https://github.com/dongh9508/Study-SpringBoot2/tree/master/keyword)에 정리하면서 진행하고 있습니다.
* 개발환경

  |      도구            | 버전      | 
    ----------------- | ---------------------------- | 
  | **OS** | Windows 10(64-bit), Mac OS  | 
  |  **IDE**  | IntelliJ IDEA  |
  |  **JDK**  | JDK 8          | 

### Study-Day-1

  * application.yml 생성 및 test property 값 추가 

  * @Value 어노테이션 테스트
  * @ConfigurationProperties 어노테이션 테스트

### Study-Day-2

  * 자동 환경 설정 어노테이션 살펴보기

  * H2 Console 자동 설정 적용해보기
  * @SpringBootTest 어노테이션 테스트 및 실습
  * @WebMVCTest 어노테이션 테스트 및 실습 

### Study-Day-3

  * @DataJpaTest 어노테이션 테스트 및 실습

  * @RestCilentTest 어노테이션 테스트 및 실습
  * @JsonTest 어노테이션 테스츠 및 실습

### Study-Day-4

  * 커뮤니티 게시판 설계
  
  * 커뮤니티 게시판 프로젝트 'Spring-Boot-Community-Web' 생성
    * 프로젝트 의존 라이브러리 6개 구성
    
      * Web, Thymeleaf, JPA, DevTools, lombook, H2

  * 도메인 매핑 및 도메인 테스트하기
    * 도메인 매핑 : JPA를 사용하여 DB와 도메인 클래스를 연결시켜주는 작업

### Study-Day-5

  * BoardService, BoardController 클래스 생성.
  
  * CommandLineRunner를 사용하여 DB에 데이터 넣기.

  * 게시판 리스트 기능과 페이징 처리 및 등록 폼 생성(**Thymeleaf** 활용)
  * H2-console 확인
    ```
    application.properties

    spring.thymeleaf.cache=false

    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.generate-ddl=true
    spring.jpa.show-sql=true

    spring.h2.console.enabled=true

    logging.level.org.hibernate=info
    logging.level.org.springframework.web=info
    
    url : http://localhost:8080/h2-console/
    ```

### Study-Day-6

  * 스프링 부트 시큐리티, OAuth2 개념 이해하기.

  * OAuth2의 제공하는 4가지 승인 타입 중 **권한 부여 승인 코드 타입** 이해 및 적용.

    * 소셜 미디어 타입 정보를 나타내는 SocialType enum 객체 생성.

    * User 클래스에 인증을 위한 principal(키값), socialType(인증여부) 컬럼 추가.

  * 스프링 부트 시큐리티 + OAuth2 의존성 설정.
  
  * OAuth2를 사용하기 위한 페이스북, 구글, 카카오 개발자 센터 연동.

    * 클라이언트 ID 및 클라이언트 Secret 발급.


### Study-Day-7

  * 스프링 부트 1.5.14 버전 다운 그레이드

  * SNS 프로퍼티 설정 및 바인딩

    * ClientResources 클래스 생성

  * 시큐리티와 OAuth2 설정

    * SecurityConfig 클래스 생성.

    * UserTokenService 클래스 생성.