package com.assessmentTask.Book_Management_Application.Repository;

import com.assessmentTask.Book_Management_Application.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo  extends JpaRepository<Book, Long> {
}
