package com.donghun.controller;

import com.donghun.annotation.SocialUser;
import com.donghun.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/loginSuccess")
    public String loginComplete(@SocialUser User user) {
        return "redirect:/board/list";
    }

    @GetMapping("/logout")
    public String logout() {
        return "login";
    }
}
