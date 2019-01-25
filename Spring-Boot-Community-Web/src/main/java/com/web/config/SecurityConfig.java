package com.web.config;

import com.web.domain.enums.SocialType;
import com.web.oauth2.CustomOAuth2Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.CompositeFilter;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.web.domain.enums.SocialType.*;

@Configuration
@EnableWebSecurity
//@EnableOAuth2Client // @EnableOAuth2Client을 사용하면 빈을 두 개 생성해야 한다. 그 중 첫번째 빈을 생성하는 방법이 oauth2ClientFilterRegistration 메소드이고 두번째 방법은
////  OAuth2RestTemplate template = new OAuth2RestTemplate(client.getClient(), oAuth2ClientContext); 여기서 한다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        http.authorizeRequests()
                .antMatchers("/",  "/oauth2/**", "/login/**", "/css/**", "/images/**", "/js/**",
                        "/console/**").permitAll()
                .antMatchers("/facebook").hasAuthority(FACEBOOK.getRoleType())
                .antMatchers("/google").hasAuthority(GOOGLE.getRoleType())
                .antMatchers("/kakao").hasAuthority(KAKAO.getRoleType())
                .anyRequest().authenticated() // 위 요청은 인증되지 않은 사람에게도 열어주겠지만 하지만 이 이외의 요청은 인증된 사용자에게만 제공한다.
                .and()
                .oauth2Login()
                .defaultSuccessUrl("/loginSuccess")
                .failureUrl("/loginFailure")
                .and()
                .headers().frameOptions().disable()
                .and()
                .exceptionHandling() // 인증되지 않은 사람이 허용하지 않은 요청이 들어왔을 때는 /login으로 강제로 돌려버리게 하는 예외처리핸들링을 해버린다.
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint(
                        "/login"))
                .and()
                .formLogin() // 로그인에 성공하면 설정된 경로로 포워딩 된다.
                .successForwardUrl("/board/list") // 로그인이 되면 인증된 사용자니까, board/list로 보내버린다.
                .and()
                .logout()  // 로그아웃이 해야할 때 처리하는 방식이 된다.
                .logoutUrl("/logout") // 로그아웃이 수행될 URI
                .logoutSuccessUrl("/login") // 로그아웃이 성공했을 때 포워됭될 URL
                .deleteCookies("JSESSIONID") // 로그아웃이 성공했을 때 삭제될 쿠키값
                .invalidateHttpSession(true) // 설정된 세션의 무효화를 수행하게끔 설정되어 있다.
                .and()
                .addFilterBefore(filter, CsrfFilter.class) // 첫번쨰 인자보다 먼저 시작될 필터를 등록한다. 문자 인코딩 필터보다 Csrf 필터를 먼저 실행하도록 설정한다.
                .csrf().disable();

    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository(
            OAuth2ClientProperties oAuth2ClientProperties, @Value("${custom.oauth2.kakao.client-id}") String kakaoClientId) {
        List<ClientRegistration> registrations = oAuth2ClientProperties.getRegistration().keySet().stream()
                .map(client -> getRegistration(oAuth2ClientProperties, client))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        registrations.add(CustomOAuth2Provider.KAKAO.getBuilder("kakao").clientId(kakaoClientId).clientSecret("test").jwkSetUri("test").build());

        return new InMemoryClientRegistrationRepository(registrations);
    }

    private ClientRegistration getRegistration(OAuth2ClientProperties clientProperties, String client) {
        if("google".equals(client)) {
            OAuth2ClientProperties.Registration registration = clientProperties.getRegistration().get("google");
            return CommonOAuth2Provider.GOOGLE.getBuilder(client)
                    .clientId(registration.getClientId())
                    .clientSecret(registration.getClientSecret())
                    .scope("email", "profile")
                    .build();
        }
        if("facebook".equals(client)) {
            OAuth2ClientProperties.Registration registration = clientProperties.getRegistration().get("facebook");
            return CommonOAuth2Provider.FACEBOOK.getBuilder(client)
                    .clientId(registration.getClientId())
                    .clientSecret(registration.getClientSecret())
                    .userInfoUri("https://graph.facebook.com/me?fields=id,name,email,link")
                    .scope("email")
                    .build();
        }
        return null;
    }


}
