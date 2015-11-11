package com.example.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book implements Serializable {
    private static final long serialVersionUID = 7591474657266902346L;

    @Id
    @GeneratedValue
    private Long id;

    private String authors;

    private String title;

    private int publicationYear;

    // for Hibernate
    protected Book() {

    }

    public Book(Long id, String authors, String title, int publicationYear) {

        this(authors, title, publicationYear);
        this.id = id;
    }

    public Book(String authors, String title, int publicationYear) {

        this.authors = authors;
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public Long getId() {

        return this.id;
    }

    public String getAuthors() {

        return this.authors;
    }

    public String getTitle() {

        return this.title;
    }

    public int getPublicationYear() {

        return this.publicationYear;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.authors == null) ? 0 : this.authors.hashCode());
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + this.publicationYear;
        result = prime * result + ((this.title == null) ? 0 : this.title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (this.authors == null) {
            if (other.authors != null)
                return false;
        } else if (!this.authors.equals(other.authors))
            return false;
        if (this.id == null) {
            if (other.id != null)
                return false;
        } else if (!this.id.equals(other.id))
            return false;
        if (this.publicationYear != other.publicationYear)
            return false;
        if (this.title == null) {
            if (other.title != null)
                return false;
        } else if (!this.title.equals(other.title))
            return false;
        return true;
    }
}
