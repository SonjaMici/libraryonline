package com.ikub.libraryonline.project.repository;

import com.ikub.libraryonline.project.domain.dto.book.BookDTO;
import com.ikub.libraryonline.project.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface
BookRepository extends JpaRepository<Book,Integer> {

    @Query(name = "book_findBookByCategory")
    List<Book> findByCategoryId (Integer categoryId);

    List<BookDTO> findBookByTitle(String title);
    List<Book> findAllByPriceGreaterThan(Double price);

}
