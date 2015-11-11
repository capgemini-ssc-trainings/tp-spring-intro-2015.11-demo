package com.example.repository;

import java.util.List;

import com.example.model.Book;
import com.example.service.BookSearchCriteria;

public interface BookSearchRepository {
    List<Book> find(BookSearchCriteria bookSearchCriteria);
}
