package com.community;

import com.community.controller.BookController;
import com.community.domain.Book;
import com.community.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.hamcrest.Matchers.contains;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookService bookService;

    @Test
    public void Book_MVC_테스트() throws Exception {
        Book book = new Book("Spring Boot Book", LocalDateTime.now());
        Integer a = new Integer(123);

        given(bookService.getBookList()).willReturn(Collections.singletonList(book));
        given(bookService.getIntegerList()).willReturn(Collections.singletonList(a));

        mvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(view().name("book")) // view name이 book인지 물어봄.
                .andExpect(model().attributeExists("bookList"))
                .andExpect(model().attributeExists("bookList2")) //
                .andExpect(model().attribute("bookList", contains(book)));

        mvc.perform(get("/books2"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("book")) // view name이 book인지 물어봄.
//                .andExpect(model().attributeExists("bookList3"))
                .andExpect(model().attribute("bookList3", contains(a)));
    }
}
