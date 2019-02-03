용어정리
===
## Ch. 1, Ch. 2
### Dependency

  * Dependency(또는 의존성)는 코드에서 두 모둘간의 연결이라고 볼 수 있다. 객체 지향 언어에서는 두 클래스간의 관계라고도 말한다.
  * 일반적으로 둘 중 하나가 다른 하나를 어떤 용도를 위해 사용한다. 간단히 생성자 호출인 new 연산자가 될 수 있다.
  * 클래스 내에서 개발자가 객체를 직접 관리(생성 및 조작)할 경우, 의존성이 나타나게 된다.
  * A 클래스와 B 클래스와 C 클래스가 있다고 가정하면, A 클래스 내에서 B 객체와 C 객체를 생성할 경우, A 객체는 B 객체와 C 객체를 사용함과 동시에 의존한다 라는 의미를 가진다.

    ```java
    public class A {	
      public A() {
        B b = new B();
	    C c = new C();
      }
    }
    ```
  * 위와 같은 경우, A 객체는 객체 B와 C에 의존하게 되는 경우가 생깁니다. 이런 의존성이 위험한 이유는 다음과 같습니다.

#### Dependency가 위험한 이유

* 의존성이 강하면 강할수록, 상호적으로 결합이 생기고, 결합이 강해지면 클래스간의 관계가 복잡해지고 쉽사리 변경하기가 쉽지가 않다.

* 두 코드가 서로를 종속하고 있기 때문에 변경에 대한 작업이 어려워진다. 
* A 객체에서 다른 객체를 사용한다고 했을 때 테스트를 한다고 해보자, 테스트가 실패했을 때 현재 객체에서의 실패일까 의존하는 객체의 실패일까? 알 수 없다. 이게 클래스별로 상당한 양의 코드라면 이건 너무 심각한 문제가 된다.
* 하나의 모듈이 바뀌면 의존한 다른 모듈까지 변경이 이루어지기 때문이다.  

### DI(Dependency Injection)

* A 클래스가 B와 C 객체에 의존하고 있는 상황일 때, 직접 A 클래스 내에서 B객체와 C객체를 생성하는 것이 아니라, 외부에서 B 객체와 C 객체를 생성한 다음 A 클래스에 주입하는 방법이다.

* 의존 객체를 외부에서 직접 생성해서 주입하는 형태를 의존성 주입이라고 한다.
* 그렇게 할 경우, 외부(프레임워크)에 의해 의존 객체가 동적으로 주입되므로, 여러 객체간의 결합(의존도)이 줄어든다.
* 의존성 주입을 위해서는 객체를 생성하고 넘겨주는 외부의 무언가가 필요하게 되는데, 우리는 Spring Framework에서 이를 해결한다.
* 의존 객체를 생성하고 주입시켜 주는 곳이 Spring에서는 Bean container가 된다.

#### Dependency Injection의 장점

* 종속성(의존성)이 줄어든다
  * 종속성이 줄어드므로, 변경에 민감하지가 않다.

* 재사용성이 증가한다.
  * 다른 클래스에서도 이러한 의존 객체가 필요할 경우, Bean 컨테이너에서 의존 객체를 주입해줄 수 있다.

* 테스트 코드를 작성하는데에 대한 불편이 줄어든다.
* 코드의 가독성이 올라간다. 

### Build

  * 소스코드 파일을 컴퓨터에서 실행시킬 수 있도록 가공하는 것, 실행가능한 파일을 만드는 것.

### Redis

  * 오픈소스 기반의 비관계형 데이터 베이스 관리 시스템

### JDBC

  * Java에서 데이터베이스에서 접근할 수 있는 자바 인터페이스

### REST API

  * 웹 설계의 우수성을 제대로 사용하기 위한 Architecture

### 프레임워크

  * 소프트웨어에서의 특정 문제를 해결하기 위해 상호 협력 하는 클래스와 인터페이스의 집합체.

  * 프로그램 설계를 위하여 일관된 방법이나 설계를 제공하는 환경을 의미하기도 한다.

  * 어떠한 목적을 달성하기 위해 복잡하게 얽혀있는 문제를 해결하기 위한 구조이며, 소프트웨어 개발에 있어 하나의 뼈대 역할을 한다.

  * 라이브러리와의 차이점

    * 프레임워크라고 하면 클래스와 라이브러리가 합쳐진 형태라고 볼 수 있다.

    * 메소드 및 클래스화, 즉 모듈화를 하는 이유 중 하나가 재사용성인데, 프레임워크는 이 재사용성을 큰 그룹 단위로 묶어주었다고 보면 된다.

    * 재사용 가능한 수많은 클래스들과 라이브러리들을 융합한 채로 처음부터 제공해 주기 때문에, 여러 개의 표준을 만들지 않아도 돼서 개발자의 피곤함을 덜어준다.


### JPA(Java Persistent API)

  * 어플리케이션과 JDBC 사이에서 동작하는 도구

  * 자바 플랫폼 SE와 자바 플랫폼 EE를 사용하는 응용프로그램에서 관계형 데이터베이스의 관리를 표현하는 자바 API이다. 
  * 기존에 EJB에서 제공되던 엔터티 빈을 대체하는 기술이다.
  * ORM 표준 기술로 Hibernate, OpenJPA, EclipseLink, TopLink Essentials과 같은 구현체가 있고 이에 표준 인터페이스가 바로 JPA이다.
  * ORM(Object Relational Mapping)이란 데이터베이스와 객체 지향 프로그래밍 언어 간의 호환되지 않는 데이터 변환 기법이다. 
  * 쉽게 얘기하면 RDB 테이블을 객체지향적으로 사용하기 위한 기술이다. 
  * RDB 테이블은 객체지향적 특징(상속, 다형성, 레퍼런스, 오브젝트 등)이 없고 자바와 같은 언어로 접근하기 쉽지 않다.
  * 때문에 ORM을 사용해 오브젝트와 RDB 사이에 존재하는 개념과 접근을 객체지향적으로 다루기 위한 기술이다.

### Gradle

  * 소스 코드로 부터 배포 가능한 산출물을 빌드하는 '빌드툴' 또는 '프로젝트 관리 도구'

  * Gradle = Ant의 유연성 + Maven의 편리성을 조합해서 만든 빌드 시스템
  * API 제공 및 확장성이 좋다.
  * 빌드의 구조화를 제공하고, Mulit-Project 빌드를 쉽게할 수 있도록 제공
  * Groovy DSL(Domain Specific Language) 기반
  * 빌드 스크립트는 기존 XML이 아닌 Grooovy 방식으로 작성

### Rest Controller

  * REST(Representational State Transfer)는 하나의 URI는 하나의 고유한 리소스를 대표하도록 설계된다는 개념이다.
  * REST 방식은 특정한 URI는 반드시 그에 상응하는 데이터 자체라는 것을 의미하는 방식이다.
    * /wedul/123은 해당 페이지의 번호의 123번이라는 고유한 의미를 가지고 설계하고, 이에 대한 처리는 GET, POST 방식과 같이 추가적인 정보를 통해서 결정한다.

  * Rest API는 외부에서 위와 같은 방식으로 특정 URI를 통해서 사용자가 원하는 정보를 제공하는 방식이다.
    * Rest 방식의 서비스 제공이 가능한 것을 RestFul 하다고 표현한다.

  * 스프링 3부터 @Repository 어노테이션을 지원하면서 REST 방식의 처리를 지원하고 있었으며 스프링 4에 들어와서 @RestController가 본격적으로 소개되었다.

  * @RestController

    * 특정한 JSP와 같은 뷰를 만들어 내는 것이 아닌 REST 방식의 데이터 자체를 서비스하는 것을 말한다.
    
    * @Controller + @ResponseBody 의 축약형으로써, 리턴값을 view resolver로 매핑하지 않고 그대로 출력해준다.
    * @RestController라는 어노테이션을 컨트롤러에 지정하면, 해당 컨트롤러의 모든 메소드는 자동적으로 @RseponseBody 어노테이션이 적용된 것처럼 동작한다.
    * @RestController가 적용된 컨트롤러의 모든 메소드는 jsp등의 뷰를 생성하지 않고 데이터만 반환하게 된다.
    * 이 데이터는 크게 단순문자열, JSON, XML 등으로 나누어진다.
    * @Controller와 RESTful 컨트롤러인 @RestController의 차이점은 HTTP Response Body가 생성되는 방식이다.
    * @Controller 는 View Page를 반환하지만, @RestController는 객체(VO,DTO)를 반환하기만 하면, 객체데이터는 application/json 형식의 HTTP ResponseBody에 직접 작성되게 된다.

### @GetMapping

  * @RequestMapping(method = RequestMethod.GET) 의 축약형으로써, 어노테이션만 보고 무슨 메소드 요청인지 바로 알아볼 수 있다.
  
  * @GetMapping은 요청 URL을 어떠한 메서드가 처리할 지 맵핑한다.
  
  * controller 내부에서 URI 경로 지정하는 역할도 한다.

### YAML(YAML Ain’t Markup Language)

  * '사람이 쉽게 읽을 수 있는' 데이터 직렬화 양식

  * XML, JSON과 같은 가독성을 염두에 두고 설계된 포맷

### @Value

  * 프로퍼티의 키값을 사용하여 특정한 값을 호출할 수 있다.

  * YAML 파일에서 설정한 키 값을 @Value의 프로퍼티 값으로 주면 해당 값이 필드 값에 할당되는 방식.
  * 단일 필드값을 가져오는데 사용.
  * 공통 값들을 정의해 놓은 파일(YAML)에 접근하여 원하는 데이터를 읽어와 사용한다.

### @ConfigurationProperties

  * 다양한 형태의 프로퍼티 값을 매핑할 수 있다.

  * @Value 와 마찬가지로 YAML 파일에 접근하여 원하는 데이터를 읽어오는 것은 동일하나, 특정한 값(단일 필드)값을 가져오는것이 아닌, 기본적으로 접두사를 사용하여 값을 바인당한다.
  * @ConfigurationProperties는 유연한 바인딩(다양한 형식으로 선언하여 바인딩)이 가능하다.

### Spring Bean

  * 간단하게 애기하면 스프링 빈이란, 자바의 객체이다.

  * 스프링 컨테이너(Spring Container)에 의해서 자바 객체가 만들어 지게 되면 이 객체를 스프링은 스프링 빈이라고 부르는 것.
  * 스프링 빈과 자바 일반 객체와의 차이점은 없다.
  * 스프링 컨테이너에서 만들어지는 객체를 스프링 빈이라고 부를 뿐이다.
  * 스프링 IOC 컨테이너에 의해 관리되며 스프링 제어권을 가지고 관계를 부여하는 객체
  * 스프링 컨테이너는 빈의 생성 주기, 관계, 사용 등의 설정을 제어한다.(의존 객체를 모아두는 곳이 스프링(Bean) 컨테이너, 컨테이너에서 의존 객체를 관리한다.)

### Spring Boot Starter

  * 다양한 애플리케이션에 포함되는 편리한 의존성 집합체

  * 스프링 부트는 관련 의존성을 스타터라는 묶음으로 제공하여 수동 설정을 지양.

### @Data

  * 클래스안의 모든 private 필드에 대해 @Getter와 @Setter를 적용하여 세터/게터를 만들어준다.

  * 클래스내에 @ToString 과 @EqualsAndHashCode를 적용시켜 메소드를 오버라이드 해주며 @RequiredArgsConstructor를 지정해 준다.

### @Component

  * Spring의 @Repository, @Service 및 @Controller가 관리하는 구성 요소에 대한 일반 스테레오 타입

  * MVC의 구성 요소를 나타내는 일반 주석
  * 주석 된 bean을 스캔하여 DI 컨테이너에서 사용할 수있게하는 최상위 일반 주석

### Anotation

  * 인터페이스를 기반으로 한 어떠한 기능을 주입하는데에 사용되는 것.

### h2

  * Java로 작성된 인 메모리 RDBMS
---

## Ch. 3
### JUnit

  * xUnit이라고 하는 단위 테스트 프레인워크의 자바 구현물이다.

  * 테스트 도구로서 외부 테스트 프로그램(케이스)를 작성하여 System.out으로 일일이 출력하면서 디버깅 하지 않아도 되고 프로그램 테스트시 걸린 시간 같은 것도 관리를 할 수 있게 해주는 도구이다.
  * 단 하나의 jar파일로 되어 있으며 사용법 또한 간단하다.
  * 테스트 결과를 확인 하는 것 이외 최적화된 코드를 유추해내는 기능도 하므로 성능 향상도 기대할 수 있으며 테스트 결과를 단순한 텍스트로 남기는 것이 아니라 Test클래스로 남김으로 개발자에게 테스트 방법 및 클래스의 History를 넘겨줄 수 있다.

### @RunWith

  * JUnit에 내장된 러너를 사용하는 대신 어노테이션에 정의된 러너 클래스 사용.
  * JUnit 프레임워크의 테스트 실행 방법을 확장할 떄 사용하는 어노테이션

  * @RunWith를 사용하기 위해선 Junit 실행에 필요한 SpringJunit4ClassRunner 클래스를 상속받은 @Runwith(SpringRunner.class)를 꼭 붙여서 사용해야 한다.

### @SpringBootTest

  * 통합 테스트를 제공하는 기본적인 스프링 부트 테스트 어노테이션.
  * 여러 단위의 테스트를 하나의 통합된 테스트로 수행할 떄 적합.

  * 만능 테스트 어노테이션으로 하고 싶은 모두 테스트를 수행할 수 있다.
  * 단, 애플리케이션에 설정된 빈을 모두 로드하기 때문에 규모가 클수록 느려진다.

### @WebMvcTest

  * MVC를 위한 테스트 어노테이션

  * 웹에서 테스트하기 힘든 컨트롤러를 테스트하는데 적합하고 웹 상의 요청/응답에 대해 테스트할 수 있다.
  * @WebMvcTest를 사용하면 MVC 관련 설정인 어노테이션만 불러오기 때문에 @SpringBootTest보다 가벼운 테스트가 가능하다.

### @DataJpaTest

  * JPA 관련 테스트 설정만 로드하는 어노테이션.

  * 데이터 소스의 설정이 정상적인지 JPA를 사용하여 데이터를 제대로 CRUD 하는지 테스트가 가능.
  * @Entity 클래스를 스캔하여 스프링 데이터 JPA 저장소를 구성.
  * 실제 데이터 베이스를 쓰지않고, 내장형 데이터 베이스를 사용하여 테스트하기 때문에 JPA 테스트 이후 실제 데이터가 벼경 되었는지 걱정할 필요가 없다.

### @RestClientTest

  * Rest 관련 테스트를 도와주는 어노테이션

  * REST 통신의 데이터 형으로 사용되는 JSON 형식이 제대로 응답을 반환하는지 등을 테스트 한다.

### @JsonTest

  * JSON 테스트를 지원하는 어노테이션.

  * @JsonTest 어노테이션은 JSON의 직렬화와 역질렬화를 수행하는 라이브러리인 Gson과 Jackson API 테스트를 제공한다. 
---

## Ch. 4
### [MVC 패턴](https://github.com/ber01/Study-Spring-Boot/tree/master/keyword/MVC)

  * MVC 패턴에 Service가 필요한 이유

    * Service에서 실제 요청에 필요한 비즈니스 로직을 구현하기 때문에 Service가 없을 경우, Controller에서 비즈니스 로직을 구현해야 한다. 
    
    * Service가 없을 때, Controller에 요청이 왔다면 각 요청에 따른 비즈니스 로직을 구현한 Controller들이 응답해줘야 한다.

      * 하나의 컨트롤러에 모든 요청에 따른 비즈니스 로직을 모두 구현할 경우, Controller와 애플리케이션이 상당히 복잡해진다.

        * 그리하여, 요청에 연관성이 있는 여러개의 Controller로 분리되어 처리되어야 한다. 이렇게 되면 Controller가 상당히 많아질 수 있다.
    
    * 이렇게 될 경우, 여러 Controller에서 공통으로 사용되는 로직이 생기게 되고, 애플리케이션이 쉽게 복잡해진다.
    
    * 그렇기 때문에 요청을 Controller에서 받고 요청에 필요한 비즈니스 로직은 Service에서 담당하는 것이 더 효율적이며 깔끔한 애플리케이션이 될 수 있다. 

### [Thymeleaf](https://github.com/rhkd4560/Study-SpringBoot/tree/master/Spring%204day/homework)

### [Template](https://github.com/rhkd4560/Study-SpringBoot/tree/master/Spring%204day/homework), [Template Engine](https://github.com/rhkd4560/Study-SpringBoot/tree/master/Spring%204day/homework)

### [의존 라이브러리](https://github.com/dongh9508/Study-SpringBoot2/tree/master/keyword/LINK/dependency%20library)
  * Web

  * Thymeleaf
  * JPA
  * Devtools
  * Lombok
  * H2

### [각종 어노테이션 모음](https://github.com/etg6550/2019WinterProject/tree/master/Day4/HomeWork)
  * Serializable

  * @Getter
  * @NoArgsConstructor
  * @Entity
  * @Table
  * @Id
  * @Column
  * @Builder

### [각종 어노테이션 모음2](https://github.com/ber01/Study-Spring-Boot/tree/master/keyword/Annotation2)
  * Pageable
  
  * @Service
  * @Controller
  * @RequestMapping
  * @PageableParam
  * @PageableDefault
  * @Bean
---

## Ch. 5
### 스프링 부트 시큐리티

* 스프링 부트 시큐리티는 스프링 시큐리티의 번거로운 설정을 간소화 시켜주는 래핑 프레임워크다.

  * 스프링 시큐리티 : 자바 EE 기반의 엔터프라이즈 소프트웨어 애플리케이션을 위한 포괄적인 보안 서비스들을 제공하는 오픈 플랫폼. 
  
  * 스프링 시큐리티는 스프링에서 십여 년간 보안 노하우를 쌓아 와서 기본적인 틀 안에서 원하는 대로 인증, 권한 처리를 편리하게 관리할 수 있게 한다.

* 스프링 부트 시큐리티는 스프링 스큐리티에 스타터를 제공해 더 빠른 설정을 지원하는 프로젝트.

* 스프링 부트 시큐리티에서 가장 중요한 개념은 **인증**과 **권한부여**이다.

  * 인증 : 사용자(클라이언트)가 애플리케이션의 특정 동작에 관하여 허락(인증)된 사용자인지 확인하는 절차이다.

    * 보통 웹 사이트 로그인을 인증이라 볼 수 있다.

  * 권한 부여 : 데이터나 프로그램 등의 특정 자원이나 서비스에 접근할 수 있는 권한을 허용하는 것을 얘기한다.

    * 예를 들면, A는 VIP 회원이고 B는 일반 회원이라면 두 회원의 권한이 다르게 부여된다.
  
### [OAuth2](https://github.com/ber01/Study-Spring-Boot/tree/master/keyword/OAuth2)

  * OAuth2에 앞서 OAuth는 토큰을 사용한 범용적인 방법의 인증을 제공하는 표준 인증 프로토콜이다.

  * OAuth2는 OAuth 프로토콜의 버전 2이다.

  * OAuth2는 서드파티를 위한 범용적인 인증 표준이다.

  * OAuth2 동작 원리

    ![kakaotalk_20190118_152339876](https://user-images.githubusercontent.com/33312179/51379984-09f89680-1b54-11e9-9e62-c295018cf02d.png)

  * OAuth2에서 제공하는 4가지 승인 타입.

    * **권한 부여 코드 승인 타입(Authorization Code Grant Type)**

      *  클라이언트가 Resource Owner(자원 소유자)에게 직접 권한 부여를 요청하는 대신, Resource Owner(자원 소유자)가 Authorization Server(권한 서버)에서 인증을 받고 권한을 허가한다.

      * 소유자가 권한을 허가하게 되면 Authorization Code(권한 코드)가 발급되고, 이 Authorization Code(권한 코드)를 클라이언트에게 전달하게 된다.

      * 클라이언트는 이 코드를 권한 서버에 보내주면서 자신이 권한 허가를 받았다는 사실을 알리고 access token을 받게 된다.

      * access token을 바로 클라이언트로 곧바로 전달하지 않기 때문에 전달과정에서 생길 수 있는 잠재적인 유출 위험을 방지하는데 도움을 준다.

    * **암시적 승인 타입(Implicit Grant Type)**

      * Authorization Code를 간소화한 방식이다.

      * Authorization Code(권한 코드)가 별도로 발급되지 않고 access token이 바로 발급된다. 

        * 권한 부여 코드 방식에서는 access token을 얻기 위한 중간 매개체로 Authorization Code(권한 코드)를 사용했다.

      * 과정이 줄어들어 편해지는 대신 보안성은 낮아집니다.

    * **리소스 소유자 암호 자격 증명 승인 타입(Resource Owner Password Credentials Grant Type)**

      * 자원 소유자의 계정 아이디와 비밀번호 같은 계정 인증 정보가 access token을 얻기 위한 Authorization Grant(권한 증서)로 사용된다.

      * 계정정보를 애플리케이션에 직접 입력해야 하므로, 신뢰할 수 있어야 한다.

      * access token 을 얻은 후에는 리소스 요청을 위해 계정 아이디, 비밀번호를 클라이언트가 보관하고 있을 필요가 없다.

    * **클라이언트 자격 증명 승인 타입(Client Credentials Grant Type)**

      * 자원 소유자가 유저가 아닌, 클라이언트인 상황에서 활용되는 방식이다.

      * 클라이언트가 관리하는 리소스에만 접근할 경우로 권한이 한정되어 있을 때 활용할 수 있다. 

      * 즉, Client(클라이언트)가 곧 Resource Owner(자원 소유자)가 되는 상황이다.

      * 클라이언트는 자기를 인증할 수 있는 정보를 Authorization Server(권한 서버)에 보내면서 access token을 요청하게 된다. 

### Access Token

  * 로그인 세션에 대한 보안 자격을 증명하는 식별 코드를 의미한다.

  * 사용자, 사용자 그룹, 사용자 권한 및 경우에 따라 특정 API 사용을 보증하는 역할또한 한다.

  * 보호된 자원에 접근할 때 권한 확인용으로 사용되기도 한다.

  * 문자열 형태이며 클라이언트에 발급된 권한을 대표하게 된다.

  * 계정 아이디와 비밀번호 등 계정 인증에 필요한 형태들을 이 토큰 하나로 표현할 수 있다. 
  
  * 액세스 토큰으로 인해서 리소스 서버는 여러 가지 인증 방식에 각각 대응 하지 않아도 권한을 확인 할 수 있게 된다.

### [p136 ~ p137 코드 정리](https://github.com/ber01/Study-Spring-Boot/tree/master/keyword/p136)

### [각종 어노테이션 및 인터페이스](https://github.com/pdh6547/study-spring-boot/blob/master/Keyword/Homework/Annotaion%20and%20Interface.md)

  * @NestedConfigurationProperty

  * AuthorizationCodeResourceDetails

  * ResourceServerProperties

  * OAuth2 리소스 값

  * @Configuration

  * 동기, 비동기 통신

### [각종 어노테이션 및 인터페이스2](https://github.com/hagome0/Study-Spring-Boot/tree/master/keyword/Annotaion%20and%20Interface2)
  
  * @EnableWebSecurity

  * WebSecurityConfigurerAdapter

  * HttpServletRequest

  * XFrameOptionsHeaderWriter

  * CharacterEncodingFilter

  * CsrfFilter

### [각종 어노테이션 및 인터페이스3](https://github.com/woghd9072/study-spring-boot/tree/master/Keyword/Homework)

  * @EnableOAuth2Client

  * OAuth2ClientContext

  * BasicAuthenticationFilter

  * FilterRegistrationBean

  * Filter

  * CompositeFilter

  * OAuth2ClientAuthenticationProcessingFilter
  
  * OAuth2RestTemplate
  
  * UserInfoTokenService
 
---

## Ch. 6

### [용어정리 1](https://github.com/mkshin96/study-spring-boot/blob/master/%EC%9A%A9%EC%96%B4%20%EC%A0%95%EB%A6%AC/REST.md)

  * Rest

  * Restful

  * HATEOAS

### REST

  * REST는 웹과 같은 분산 하이퍼미디어 시스템에서 사용하는 통신 네트워크 아키텍처로, 네트워크 아키텍처의 원리 모음이다.

  * 웹은 전송 방식으로 HTTP를, 식별 방법으로 URI를 사용한다.

    * HTTP : HTTP는 웹에서 GET, POST, PUT, DELETE 등의 메소드를 사용하여 정보를 주고받는 프로토콜.

  * REST는 HTTP와 URI의 단순하고 간결한 장점을 계승한 네트워크 아키텍처이다. 

  * 따라서 다양한 요구사항에 대응하여 떄로는 단순하게, 때로는 서버와 클라이언트가 서로 통신하는 리소스에 대해 복잡한 방식으로 상호작용할 수 있다.

  * REST의 목적

    * 구성요소 상호작용의 규모 확장성

    * 인터페이스의 범용성 

    * 구성요소의 독립적인 배포

    * 중간적 구성요소를 이용한 응답 지연 감소, 보안 강화, 레거시 시스템 인캡술레이션

### RESTFul

  * REST의 구현 원칙을 제대로 지키면서 REST 아키택쳐를 만드는 것을 RESTful이라고 한다.

  * RESTful의 제약 조건

    * 클라이언트-서버(client-server)

    * 무상태성(stateless)

    * 캐시 가능(cacheabe)

    * 계층화 시스템(layered system)

    * 코드 온 디맨드(code on demand)

    * 인터페이스 일관성(uniform interface)

---