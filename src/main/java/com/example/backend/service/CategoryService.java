package com.example.backend.service;

import com.example.backend.dto.CategoryDto;
import com.example.backend.dto.UpdateCategoryDto;
import com.example.backend.entity.Category;
import com.example.backend.model.CategorySearchCriteriaModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
  Category createCategory(CategoryDto categoryDto) throws Exception;
  Category getCategoryById(Integer Id);
  Category updateCategoryById(UpdateCategoryDto categoryDto, Integer Id) throws Exception;
  Page<Category> getCategories(CategorySearchCriteriaModel categorySearchCriteriaModel);
  List<Category> getCategoriesByStatus(int status);
}
