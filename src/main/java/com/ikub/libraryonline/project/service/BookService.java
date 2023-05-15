package com.ikub.libraryonline.project.service;


import com.ikub.libraryonline.project.domain.entity.Book;
import com.ikub.libraryonline.project.domain.entity.BookStatus;
import com.ikub.libraryonline.project.domain.dto.book.BookDTO;
import com.ikub.libraryonline.project.domain.dto.book.BookUpdateDTO;

import java.util.List;

public interface BookService {

    Book findById(Integer id);
    List<BookDTO> listAllBooks();
    List<BookDTO> getBooksByUserId(Integer id);
    BookUpdateDTO updateBook (Integer id, BookUpdateDTO bookUpdateDTO);

    Void deleteBook (Integer id);
    List<BookDTO> findBookByCategory(Integer categoryId);
    List<BookDTO> findAllByPrice(Double price);
    List<BookDTO> findBookByTitle(String title);

    BookStatus setBookStatus (Integer id, String status);
    BookDTO addBook (BookDTO bookDTO,Integer categoryId);
}
