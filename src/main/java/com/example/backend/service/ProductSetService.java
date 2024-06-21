package com.example.backend.service;

import com.example.backend.dto.ProductSetDto;
import com.example.backend.entity.ProductSet;
import com.example.backend.model.ProductSetSearchCriteriaModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductSetService {
    ProductSet getProductSetById(Integer id);
    ProductSet createProductSet(ProductSet productSet) throws Exception;
    ProductSet updateProductSetId(ProductSetDto productSetDto, Integer id) throws Exception;
    Page<ProductSet> getAllProductSets(ProductSetSearchCriteriaModel productSetSearchCriteriaModel);
    List<ProductSet> getAll();
}
