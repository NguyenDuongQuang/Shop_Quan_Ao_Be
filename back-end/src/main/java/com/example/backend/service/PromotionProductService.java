package com.example.backend.service;

import com.example.backend.dto.PromotionProductDto;
import com.example.backend.dto.UpdatePromotionProductDto;
import com.example.backend.entity.PromotionProduct;
import com.example.backend.model.PromotionProductSearchCriteriaModel;
import org.springframework.data.domain.Page;

public interface PromotionProductService {
    PromotionProduct getPromotionProduct(Long id);
    PromotionProduct createPromotionProduct(PromotionProductDto promotionProductDto) throws Exception;
    PromotionProduct updatePromotionProduct(UpdatePromotionProductDto updatePromotionProductDto, Long id) throws Exception;
    Page<PromotionProduct> getPromotionProducts(PromotionProductSearchCriteriaModel promotionProductSearchCriteriaModel);
}
