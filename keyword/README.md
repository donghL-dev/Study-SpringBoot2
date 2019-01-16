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

### JPA(Java Persistent API)

  * 어플리케이션과 JDBC 사이에서 동작하는 도구

  * 자바 플랫폼 SE와 자바 플랫폼 EE를 사용하는 응용프로그램에서 관계형 데이터베이스의 관리를 표현하는 자바 API이다. 
  * 기존에 EJB에서 제공되던 엔터티 빈을 대체하는 기술이다.
  * ORM 표준 기술로 Hibernate, OpenJPA, EclipseLink, TopLink Essentials과 같은 구현체가 있고 이에 표준 인터페이스가 바로 JPA이다.
  * ORM(Object Relational Mapping)이란 RDB 테이블을 객체지향적으로 사용하기 위한 기술이다. 
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

  * @RequestMapping(method = RequestMethod.GET) 의 축약형으로써, 애너테이션만 보고 무슨 메소드 요청인지 바로 알아볼 수 있다.

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

### Thymeleaf

### Template, Template Engine

### [의존 라이브러리](https://github.com/dongh9508/Study-SpringBoot2/tree/master/keyword/LINK/dependency-library)
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
---