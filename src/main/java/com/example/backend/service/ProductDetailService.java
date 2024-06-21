package com.example.backend.service;

import com.example.backend.dto.ProductDetailDto;
import com.example.backend.dto.UpdateProductDetailDto;
import com.example.backend.entity.ProductDetail;
import com.example.backend.model.ProductDetailSearchCriteriaModel;
import org.springframework.data.domain.Page;

public interface ProductDetailService {

    ProductDetail createProductDetail(Long productId, ProductDetailDto productDetailDto) throws Exception;

    ProductDetail getProductDetailById(Long id);

    ProductDetail updateProductDetailById(UpdateProductDetailDto updateProductDetailDto, Long id) throws Exception;

    Page<ProductDetail> getProductDetailsByProductId(Long productId, ProductDetailSearchCriteriaModel productDetailSearchCriteriaModel);

}
