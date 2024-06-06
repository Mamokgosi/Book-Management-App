package com.assessmentTask.Book_Management_Application.Resolvers;


import com.assessmentTask.Book_Management_Application.Entity.Book;
import com.assessmentTask.Book_Management_Application.Service.BooksService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GraphqlMutationResolver implements GraphQLMutationResolver {

    private final BooksService bookService;

    @Autowired
    public GraphqlMutationResolver(BooksService bookService) {
        this.bookService = bookService;
    }

    public Book addBook(String title, String author, String description) {
        return bookService.addBook(new Book(null, title, author, description));
    }

    public Book updateBook(Long id, String title, String author, String description) {
        Book book = new Book(id, title, author, description);
        return bookService.updateBook(id, book);
    }

    public boolean deleteBook(Long id) {
        return bookService.deleteBook(id);
    }
  }

