package com.assessmentTask.Book_Management_Application.Resolvers;

import com.assessmentTask.Book_Management_Application.Entity.Book;
import com.assessmentTask.Book_Management_Application.Service.BooksService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class GraphqLqueryResolver implements GraphQLQueryResolver {
        private final BooksService bookService;

        @Autowired
        public GraphqLqueryResolver(BooksService bookService) {
            this.bookService = bookService;
        }

        public List<Book> getAllBooks() {
            List<Book> books = bookService.getBooks();
            if (books == null) {
                return Collections.emptyList();
            }
            return books;
        }
    }
