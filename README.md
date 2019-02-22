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

### Study-Day-8

  * 어노테이션 기반으로 User 정보 불러오기.

    * LoginController 클래스 생성

    * UserArgumentResolver 클래스 생성

    * WebApplication 클래스에 UserArgumentResolver 등록

    * SocialUser 어노테이션 생성

  * 인증 권한 확인 및 페이지 권한 분리

### Study-Day-9

  * 챕터 5의 전반적인 내용이 이해가 가지 않아서 처음부터 진행

    * 소셜 미디어 타입 정보를 나타내는 enum 객체 생성

      * Facebook, Google, Kakao

    * User 클래스에 socialType, principal 컬럼 추가.

      * socialType : 어떤 소셜 미디어로 인증 받았는지 여부를 나타냄.

      * principal : OAuth2 인증으로 제공받는 키 값.

    * 소셜 미디어 리소스 정보 추가

    * 소셜 미디어 리소스 프로퍼티를 객체로 매핑하는 ClientResoucre 클래스 생성

    * 각 소셜 미디어의 프로퍼티 값을 호출하는 SecurityConfig 클래스 생성 후 Bean 등록

    * 시큐리티 설정을 위한 SecurityConfig 클래스 수정

### Study-Day-10

  * OAuth2 설정을 위한 SecurityConfig 클래스 수정

    * OAuth2를 사용하기 위해 @EnableOAuth2Client 어노테이션 추가

      * @EnableOAuth2Client를 사용함으로써 두 개의 빈을 생성해야 한다.
      
        * 현재 요청과 컨텍스트를 저장하는 필터 빈과 AccessTokenRequest 타입 빈 생성

    * 액세스 토큰 및 권한 서버의 응답값을 받기 위한 OAuth2ClientContext 객체 생성

    * 현재 요청과 컨텍스트를 저장하는 필터인 oauth2ClientFilterRegistration 메소드 생성

    * 소셜 미디어 로그인 관련 필터인 oauth2Filter() 메소드 생성

### Study-Day-11

  * 스프링 부트 2.0 버전으로 의존성 업그레이드

    *  build.gradle 업데이트
  
  * 스프링 부트 2.0 방식의 OAuth2 인증 재설정

    * application.yml 내용 수정 및 업데이트

    * 카카오 정보를 담은 CustomOAuth2Provider 클래스 생성.

    * 변경된 시큐리티 + OAuth2 설정을 위한 SecurityConfig 클래스 대폭 수정.

    * 요청 서공시 URI 변경을 위한 LoginController 클래스 수정

    * 요청 스크립트 코드 변경을 위한 login.html 수정

    * UserArgumentResolver 클래스에 User 정보를 받아오는 부분 추가.

### Study-Day-12

  * CHAPTER 6 진입.

  * REST와 RESTful에 대해 알아보기.

    * REST와 RESTful의 개념에 대한 이해

    * RESTful의 제약 조건에 대한 이해

  * REST API 설계에 대한 이해

  * REST API 설계의 두가지 방법

    * MVC 패턴을 활용하는 방법

    * 스프링 부트 데이터 레스트를 활용하는 방법

### Study-Day-13

  * 커뮤니티 게시판의 form.html에 Ajax 통신용 스크립트 코드 추가.

  * 커뮤니티 게시판 프로젝트에 MySQL을 연동하기 위한 런타임 의존성 추가.

  * 커뮤니티 게시판 프로젝트의 application.yml에 MySQL 연동을 위한 설정하기.

  * Spring-Boot-Community-Rest 프로젝트 생성

    * rest-web 모듈과 data-rest 모듈 생성.

    * rest-web 모듈에 MVC 패턴을 활용하는 REST API를 구현하기.

      * rest-web 디렉터리 구조 맞추기.

      * BoardType, SocialType, Board, User, BoardRepository, UserRepository, BoardRestController, RestWebApplication 클래스 생성.

      * CORS 허용 및 시큐리티 설정을 위한 RestWebApplication 클래스 수정

      * 커뮤니티 게시판에 생성, 삭제, 수정 연동을 위해 BoardRestController 클래스 수정

    * data-rest 모듈에 스프링 부트 데이터 레스트로 REST API를 구현하기.

      * rest-web 모듈에서 작성했던 Board, User, SocialType, BoardType 클래스를 그대로 생성.

      * BoardRepository, UserRepository 인터페이스에 @RepoistoryRestResoucre 어노테이션을 추가.

      * [결과 확인](https://github.com/dongh9508/Study-SpringBoot2/blob/master/keyword/LINK/result/result1.md)

      * @RepositoryRestController를 사용하여 REST API 구현하기

        * @RepositoryRestController를 사용한 BoardRestController 클래스 생성.

        * [결과 확인](https://github.com/dongh9508/Study-SpringBoot2/blob/master/keyword/LINK/result/result2.md)

### Study-Day-14

  * data-rest 모듈에 스프링 부트 데이터 레스트로 REST API 구현하기.

    * 게시글 생성, 수정, 삭제, 연동 테스트

    * 프로젝션으로 노출 필드 제한하기

    * 각 메서드 권한 제한

  * 이벤트 바인딩

  * URI 처리

### Study-Day-15

  * 챕터 4부터 6까지 이해가지 않는 부분 내용들 검토 및 정리.

### Study-Day-16

  * 챕터 6 종료 및 챕터 4 복습 시작

  * 커뮤니티 게시판 프로젝트 생성(Spring-Boot-Community-Web2)

  * 프로젝트 의존성 구성

    * build.gradle 수정

  * 도메인 패키지 생성

    * Board, User 클래스 생성

  * 레포지토리 패키지 생성

    * BoardRepoistory, UserRepository 인터페이스 생성

  * 도메인 테스트

  * 서비스 패키지 생성

    * 핵심 비지니스 로직을 담당하는 BoardService 클래스 생성

  * 컨트롤러 패키지 생성

    * BoardController 클래스 생성

      * 클라이언트로부터 요청을 받아오고 서비스로부터 데이터를 받아와 뷰를 바인딩하는 역할을 함.

  * CommandLineRunner를 통한 H2 DB에 데이터 삽입

  * [다양한 형식의 게시판 출력](https://github.com/dongh9508/Study-SpringBoot2/blob/master/keyword/LINK/result/Board.md)

    * 페이징 형식 출력

    * 페이징 형식 역순 출력

    * 리스트 형식 출력

    * 리스트 형식 역순 출력

  * 게시판의 '#' 클릭시에 게시글의 역순출력과 정상출력이 가능하도록 구현.

    * list2.html 생성, BoardController에 list2 메소드를 생성하여 /list2 url을 getmapping 으로 매핑함.
   