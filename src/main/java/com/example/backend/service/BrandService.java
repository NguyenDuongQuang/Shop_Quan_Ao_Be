package com.example.backend.service;

import com.example.backend.dto.BrandDto;
import com.example.backend.dto.UpdateBrandDto;
import com.example.backend.entity.Brand;
import com.example.backend.model.BrandSearchCriteriaModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BrandService {

    Brand createBrand(BrandDto brand) throws Exception;

    Brand getBrandById(Integer id);

    Brand updateBrandById(UpdateBrandDto brandDto, Integer id) throws Exception;

    Page<Brand> getBrands(BrandSearchCriteriaModel brandSearchCriteriaModel);

    List<Brand> getBrandsByStatus(int status);
}
