package com.community.controller;

import com.community.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String getBookList(Model model) {
        model.addAttribute("bookList", bookService.getBookList()); // bookList가 property
        model.addAttribute("bookList2", bookService.getBookList());
        model.addAttribute("bookList3", bookService.getIntegerList());
        return "book"; // view의 이름
    }

    @GetMapping("/books2")
    public String getIntegerList(Model model) {
        model.addAttribute("bookList3", bookService.getIntegerList());
        return "book"; // view의 이름
    }

}
