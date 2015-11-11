package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import com.example.model.Book;
import com.example.model.QBook;
import com.example.service.BookSearchCriteria;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Predicate;

public class BookRepositoryImpl implements BookSearchRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> find(BookSearchCriteria bookSearchCriteria) {

        JPAQuery query = new JPAQuery(this.entityManager);
        QBook book = QBook.book;
        return query.from(book).where(applySearchCriteriaToQuery(bookSearchCriteria, book)).list(book);
    }

    private Predicate[] applySearchCriteriaToQuery(BookSearchCriteria searchCriteria, QBook book) {

        List<Predicate> predicates = new ArrayList<>();
        if (searchCriteria.hasPublicationYear()) {
            predicates.add(book.publicationYear.eq(searchCriteria.getPublicationYear()));
        }
        if (searchCriteria.hasTitle()) {
            predicates.add(book.title.containsIgnoreCase(searchCriteria.getTitle()));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
