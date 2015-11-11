package com.example.service;

import java.io.Serializable;

import org.springframework.util.StringUtils;

public class BookSearchCriteria implements Serializable {
    private static final long serialVersionUID = -2919384314176135945L;

    private String title;

    private Integer publicationYear;

    public void setTitle(String title) {

        this.title = title;
    }

    public void setPublicationYear(Integer publicationYear) {

        this.publicationYear = publicationYear;
    }

    public String getTitle() {

        return this.title;
    }

    public Integer getPublicationYear() {

        return this.publicationYear;
    }

    public boolean openSearch() {

        return hasNoTitle() && hasNoPublicationYear();
    }

    public boolean hasOnlyPublicationYear() {

        return hasPublicationYear() && hasNoTitle();
    }

    public boolean hasOnlyTitle() {

        return hasTitle() && hasNoPublicationYear();
    }

    private boolean hasNoPublicationYear() {

        return !hasPublicationYear();
    }

    public boolean hasPublicationYear() {

        return this.publicationYear != null;
    }

    public boolean hasTitle() {

        return StringUtils.hasText(this.title);
    }

    private boolean hasNoTitle() {

        return !hasTitle();
    }
}