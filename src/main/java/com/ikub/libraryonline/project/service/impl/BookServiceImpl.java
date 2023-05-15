package com.ikub.libraryonline.project.service.impl;

import com.ikub.libraryonline.project.domain.entity.Book;
import com.ikub.libraryonline.project.domain.entity.BookStatus;
import com.ikub.libraryonline.project.domain.dto.book.BookDTO;
import com.ikub.libraryonline.project.domain.dto.book.BookUpdateDTO;

import com.ikub.libraryonline.project.domain.entity.*;
import com.ikub.libraryonline.project.domain.exception.ResourceNotFoundException;
import com.ikub.libraryonline.project.domain.mapper.BookMapper;

import com.ikub.libraryonline.project.repository.*;
import com.ikub.libraryonline.project.service.BookService;
import com.ikub.libraryonline.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    private final CategoryRepository categoryRepository;
    private final UserService userService;


    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(
                String.format("Book with id %s not found",id)));
    }





    @Override
    public List<BookDTO> listAllBooks() {
        return bookRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"))
                .stream()
                .map(BookMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> getBooksByUserId(Integer id) {
        User u = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(
                String.format("User with id %s not found",id)));
        return u.getBooks()
               .stream().map(BookMapper::toDto)
               .collect(Collectors.toList());
    }

    @RolesAllowed({"ADMIN"})
    @Override
    public BookDTO addBook(BookDTO bookDTO, Integer categoryId) {
        Category category= categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException(
                String.format("Category with id %s not found",categoryId)));
        Book b = BookMapper.toEntity(bookDTO);
        b.setCategory(category);
        b.setUser(userService.getUserFromToken((Jwt)SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
        return BookMapper.toDto(bookRepository.save(b));
    }





    @RolesAllowed({"ADMIN"})
    @Override
    public BookUpdateDTO updateBook(Integer id, BookUpdateDTO bookUpdateDTO) {
        Book bookToUpdate = bookRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(
                        String.format("Property with id %s not found",id)));
        return BookMapper.toUpdateDto(bookRepository.save(BookMapper.toUpdateEntity(bookUpdateDTO,bookToUpdate)));
    }



    // @RolesAllowed({"ADMIN"})
   // @Override
   // public Void deleteBook(Integer id) {
        //bookRepository.findById(id)
              //  .ifPresentOrElse(u->bookRepository.deleteById(id),()-> new ResourceNotFoundException(
                               // String.format("Book with id %s not found",id)
                        //));
        //return null;
    //}

    @Override
    public List<BookDTO> findBookByCategory(Integer categoryId) {
        return bookRepository.findByCategoryId(categoryId)
                .stream().map(BookMapper::toDto)
                .collect(Collectors.toList());
    }




    @Override
    public List<BookDTO> findAllByPrice(Double price) {
        return bookRepository.findAllByPriceGreaterThan(price)
                .stream().map(BookMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> findBookByTitle(String title) {
        return bookRepository.findBookByTitle(title)
                .stream().map(BookMapper::toDto)
                .collect(Collectors.toList());
    }




    @RolesAllowed({"ADMIN"})
    @Override
    public BookStatus setBookStatus(Integer id, String status) {
        bookRepository.findById(id)
                .map(b-> {
                    b.setStatus(BookStatus.fromValue(status));
            return bookRepository.save(b);
        });
        return null;
    }





}
