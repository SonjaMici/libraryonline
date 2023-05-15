package com.ikub.libraryonline.project.service;

import com.ikub.libraryonline.project.domain.dto.book.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO addCategory (CategoryDTO categoryDTO);
    Void deleteCategory (Integer id);
    List<CategoryDTO> listAllCategories();
}
