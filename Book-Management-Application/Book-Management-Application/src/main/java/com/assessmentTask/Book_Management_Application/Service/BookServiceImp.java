package com.assessmentTask.Book_Management_Application.Service;

import com.assessmentTask.Book_Management_Application.Entity.Book;
import com.assessmentTask.Book_Management_Application.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

    @Service
    public class BookServiceImp implements BooksService{

        private final BookRepo bookRepository;

        @Autowired
        public BookServiceImp(BookRepo bookRepository) {
            this.bookRepository=bookRepository;
        }

        @Override
        public List<Book> getBooks() {
            return bookRepository.findAll();
        }

        public Book addBook(Book book) {
            if (book == null || StringUtils.isEmpty(book.getTitle()) || StringUtils.isEmpty(book.getAuthor())) {
                throw new IllegalArgumentException("Book data is invalid");
            }

            Book savedBook = bookRepository.save(book);

            if (savedBook == null) {
                throw new IllegalStateException("Failed to save book");
            }

            return savedBook;
        }


        @Override
        @Transactional
        public Book updateBook(Long id, Book book) {
            if (id == null || id <= 0) {
                throw new IllegalArgumentException("Invalid book ID");
            }

            if (book == null) {
                throw new IllegalArgumentException("Book object cannot be null");
            }

            Optional<Book> optionalBook = bookRepository.findById(id);
            if (optionalBook.isPresent()) {
                Book existingBook = optionalBook.get();
                existingBook.setTitle(book.getTitle());
                existingBook.setAuthor(book.getAuthor());
                existingBook.setDescription(book.getDescription());
                return bookRepository.save(existingBook);
            } else {
                throw new IllegalArgumentException("Book with ID " + id + " not found");
            }
        }

        @Override
        @Transactional
        public boolean deleteBook(Long id) {
            if (id == null || id <= 0) {
                throw new IllegalArgumentException("Invalid book ID");
            }
            Optional<Book> optionalBook = bookRepository.findById(id);
            if (optionalBook.isPresent()) {
                bookRepository.deleteById(id);
                return true;
            } else {
                throw new IllegalArgumentException("Book with ID " + id + " not found");
            }
        }
    }

