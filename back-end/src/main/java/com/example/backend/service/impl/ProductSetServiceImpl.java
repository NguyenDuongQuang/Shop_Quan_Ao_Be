package com.example.backend.service.impl;
import com.example.backend.config.Constants;
import com.example.backend.dto.ProductSetDto;
import com.example.backend.entity.ProductSet;
import com.example.backend.model.ProductSetSearchCriteriaModel;
import com.example.backend.repository.ProductSetRepository;
import com.example.backend.repository.criteria.ProductSetCriteriaRepository;
import com.example.backend.service.ProductSetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductSetServiceImpl implements ProductSetService {

    private final ProductSetRepository productSetRepository;

    private final ProductSetCriteriaRepository productSetCriteriaRepository;

    @Override
    public ProductSet getProductSetById(Integer id) {
        return productSetRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tập sản phẩm không tồn tại"));
    }

    @Override
    public ProductSet createProductSet(ProductSet productSet) throws Exception {
        log.info("Created new product set: {}", productSet);
        if (!productSetRepository.findByName(productSet.getName().trim()).isEmpty())
            throw new Exception(Constants.DUPLICATED_PRODUCT_SET);
        productSet.setName(productSet.getName().trim());
        productSet.setUpdatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
        return productSetRepository.save(productSet);
    }

    @Override
    public ProductSet updateProductSetId(ProductSetDto productSetDto, Integer id) throws Exception {
        ProductSet productSet = productSetRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tập sản phẩm không tồn tại"));

        if (!productSetRepository.findByName(productSetDto.getName().trim()).isEmpty()) {
            if (!productSet.getName().trim().equalsIgnoreCase(productSetDto.getName().trim()))
                throw new Exception(Constants.DUPLICATED_PRODUCT_SET);
        }

        BeanUtils.copyProperties(productSetDto, productSet);

        productSet.setUpdatedAt(new Date());
        productSet.setUpdatedBy(SecurityContextHolder.getContext().getAuthentication().getName());

        return productSetRepository.save(productSet);
    }

    @Override
    public Page<ProductSet> getAllProductSets(ProductSetSearchCriteriaModel productSetSearchCriteriaModel) {
        return productSetCriteriaRepository.findAllWithFilters(productSetSearchCriteriaModel);
    }

    @Override
    public List<ProductSet> getAll() {
        return productSetRepository.findAll();
    }
}
