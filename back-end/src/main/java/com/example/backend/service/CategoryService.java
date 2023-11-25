package com.example.backend.service;

import com.application.fusamate.model.CategorySearchCriteriaModel;
import com.example.backend.dto.admin.CategoryDto;
import com.example.backend.dto.admin.UpdateCategoryDto;
import com.example.backend.entity.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
  Category createCategory(CategoryDto categoryDto) throws Exception;
  Category getCategoryById(Integer Id);
  Category updateCategoryById(UpdateCategoryDto categoryDto, Integer Id) throws Exception;
  Page<Category> getCategories(CategorySearchCriteriaModel categorySearchCriteriaModel);
  List<Category> getCategoriesByStatus(int status);
}
