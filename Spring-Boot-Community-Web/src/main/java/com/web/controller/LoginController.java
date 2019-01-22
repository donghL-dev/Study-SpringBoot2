package com.web.controller;

import com.web.annotation.SocialUser;
import com.web.domain.User;
import com.web.domain.enums.SocialType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController { // User정보를 가져와 세션에 저장하는 코드

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping(value = "/{facebook|google|kakao}/complete")
    public String loginComplete(@SocialUser User user){
        return "redirect:/board/list";
    }
}
