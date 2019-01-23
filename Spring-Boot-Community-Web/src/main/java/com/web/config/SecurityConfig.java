package com.web.config;

import com.web.domain.enums.SocialType;
import com.web.oauth.ClientResources;
import com.web.oauth.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.CompositeFilter;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;

import static com.web.domain.enums.SocialType.*;

@Configuration
@EnableWebSecurity
@EnableOAuth2Client
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private OAuth2ClientContext oAuth2ClientContext;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        http.authorizeRequests()
                .antMatchers("/", "/login/**", "/css/**", "/images/**", "/js/**",
                        "/console/**").permitAll()
                .antMatchers("/facebook").hasAuthority(FACEBOOK.getRoleType())
                .antMatchers("/google").hasAuthority(GOOGLE.getRoleType())
                .antMatchers("/kakao").hasAuthority(KAKAO.getRoleType())
                .anyRequest().authenticated() // 위 요청은 인증되지 않은 사람에게도 열어주겠지만 하지만 이 이외의 요청은 인증된 사용자에게만 제공한다.
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
                .addFilterBefore(oauth2Filter(), BasicAuthenticationFilter.class)
                .csrf().disable();

    }

    @Bean
    public FilterRegistrationBean oauth2ClientFilterRegistration(
            OAuth2ClientContextFilter filter ){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);
        registration.setOrder(-100);
        return registration;
    }

    private Filter oauth2Filter() {
        CompositeFilter filter = new CompositeFilter();
        List<Filter> filters = new ArrayList<>();
        filters.add(oauth2Filter(facebook(), "/login/facebook", FACEBOOK));
        filters.add(oauth2Filter(google(), "/login/google", GOOGLE));
        filters.add(oauth2Filter(kakao(), "/login/kakao", KAKAO));
        filter.setFilters(filters);
        return filter;
    }

    private Filter oauth2Filter(ClientResources client, String path, SocialType socialType) {
        OAuth2ClientAuthenticationProcessingFilter filter =
                new OAuth2ClientAuthenticationProcessingFilter(path);
        OAuth2RestTemplate template = new OAuth2RestTemplate(client.getClient(), oAuth2ClientContext);
        filter.setRestTemplate(template);
        filter.setTokenServices(new UserTokenService(client, socialType));
        filter.setAuthenticationFailureHandler(((request, response, exception) ->
                response.sendRedirect("/error")));
        return filter;

    }

    @Bean
    @ConfigurationProperties("facebook")
    public ClientResources facebook() {
        return new ClientResources();
    }

    @Bean
    @ConfigurationProperties("google")
    public ClientResources google() {
        return new ClientResources();
    }

    @Bean
    @ConfigurationProperties("kakao")
    public ClientResources kakao() {
        return new ClientResources();
    }
}
