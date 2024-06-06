package com.assessmentTask.Book_Management_Application.Service;
import com.assessmentTask.Book_Management_Application.Entity.Book;

import java.util.List;

public interface BooksService {

        List<Book> getBooks();

        Book addBook(Book book);

        Book updateBook(Long id, Book book);

        boolean deleteBook(Long id);
}
