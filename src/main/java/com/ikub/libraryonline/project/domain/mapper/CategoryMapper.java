package com.ikub.libraryonline.project.domain.mapper;

import com.ikub.libraryonline.project.domain.dto.book.CategoryDTO;
import com.ikub.libraryonline.project.domain.entity.Category;

public class CategoryMapper {
    public static Category toEntity (CategoryDTO c){
        return Category.builder()
                .id(c.getId())
                .name(c.getName())
                .build();
    }
    public static CategoryDTO toDto (Category c){
        return CategoryDTO.builder()
                .id(c.getId())
                .name(c.getName())
                .build();
    }

}
