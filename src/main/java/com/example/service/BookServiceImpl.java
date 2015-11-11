package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.model.Book;
import com.example.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Transactional
@Service
public class BookServiceImpl implements BookService {
  @Autowired
  private BookRepository bookRepository;

  @Override
  public void saveOrUpdate(Book book) {

    this.bookRepository.save(book);
  }

  @Override
  public Book read(Long id) {

    return this.bookRepository.findOne(id);
  }

  @Override
  public void delete(Long id) {

    this.bookRepository.delete(id);
  }

  @Override
  public List<Book> find(BookSearchCriteria bookSearchCriteria) {

    return this.bookRepository.find(bookSearchCriteria);
  }
}
