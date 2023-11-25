package com.example.backend.service;


import com.application.fusamate.model.BrandSearchCriteriaModel;
import com.example.backend.dto.admin.BrandDto;
import com.example.backend.dto.admin.UpdateBrandDto;
import com.example.backend.entity.Brand;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BrandService {

    Brand createBrand(BrandDto brand) throws Exception;

    Brand getBrandById(Integer id);

    Brand updateBrandById(UpdateBrandDto brandDto, Integer id) throws Exception;

    Page<Brand> getBrands(BrandSearchCriteriaModel brandSearchCriteriaModel);

    List<Brand> getBrandsByStatus(int status);
}
