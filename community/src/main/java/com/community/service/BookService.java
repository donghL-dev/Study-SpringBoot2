package com.community.service;

import com.community.domain.Book;
import java.util.List;

public interface BookService {
    List<Book> getBookList();
    List<Integer> getIntegerList();
}
