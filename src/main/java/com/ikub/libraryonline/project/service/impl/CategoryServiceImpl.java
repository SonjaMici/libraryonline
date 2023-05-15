package com.ikub.libraryonline.project.service.impl;

import com.ikub.libraryonline.project.domain.dto.book.CategoryDTO;
import com.ikub.libraryonline.project.domain.mapper.CategoryMapper;
import com.ikub.libraryonline.project.repository.CategoryRepository;
import com.ikub.libraryonline.project.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        return CategoryMapper.toDto(categoryRepository.save(CategoryMapper.toEntity(categoryDTO)));
    }

    @Override
    public Void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
        return null;
    }

    @Override
    public List<CategoryDTO> listAllCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryMapper::toDto).collect(Collectors.toList());
    }
}
