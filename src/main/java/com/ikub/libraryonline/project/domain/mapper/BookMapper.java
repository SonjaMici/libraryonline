package com.ikub.libraryonline.project.domain.mapper;

import com.ikub.libraryonline.project.domain.dto.book.CategoryDTO;
import com.ikub.libraryonline.project.domain.dto.book.BookDTO;
import com.ikub.libraryonline.project.domain.dto.book.BookUpdateDTO;

import com.ikub.libraryonline.project.domain.entity.Category;
import com.ikub.libraryonline.project.domain.entity.Book;

import com.ikub.libraryonline.project.domain.entity.BookStatus;

public class BookMapper {
    public static BookDTO toDto (Book b){
        return BookDTO.builder()
                .id(b.getId())
                .title(b.getTitle())
                .price(b.getPrice())
                .createdAt(b.getCreatedAt())
                .status(b.getStatus().getValue())
                .categoryDTO(b.getCategory()!=null?dto(b.getCategory()):null)
                .build();
    }

    public static Book toEntity (BookDTO p){
        return Book.builder()
                .id(p.getId())
                .title(p.getTitle())

                .createdAt(p.getCreatedAt())

                .status(BookStatus.fromValue(p.getStatus()))
                .price(p.getPrice())
                .build();
    }

    public static BookUpdateDTO toUpdateDto (Book b){
        return BookUpdateDTO.builder()
                .title(b.getTitle())

                .price(b.getPrice())
                .status(b.getStatus().getValue())
                .build();
    }
    public static Book toUpdateEntity (BookUpdateDTO updateDTO, Book b){
            b.setTitle(updateDTO.getTitle());

            b.setPrice(updateDTO.getPrice());
            b.setStatus(BookStatus.fromValue(updateDTO.getStatus()));
        return b;
    }
    public static CategoryDTO dto (Category c){
        return CategoryDTO.builder()
                .id(c.getId())
                .name(c.getName())
                .build();
    }

    public static Category toEntity (CategoryDTO c){
        return Category.builder()
                .id(c.getId())
                .name(c.getName())
                .build();
    }



}
