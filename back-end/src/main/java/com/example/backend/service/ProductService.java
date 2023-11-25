package com.example.backend.service;
import com.example.backend.dto.GetProductDto;
import com.example.backend.dto.ProductDto;
import com.example.backend.dto.UpdateProductDto;
import com.example.backend.entity.Product;
import com.example.backend.model.ProductSearchCriteriaModel;
import org.springframework.data.domain.Page;

public interface ProductService {

    Product createProduct(ProductDto productDto) throws Exception;

    GetProductDto getProductById(Long id);

    Product updateProduct(UpdateProductDto updateProductDto, Long id) throws Exception;

    Page<Product> getProducts (ProductSearchCriteriaModel productSearchCriteriaModel);

    Boolean updateAvailableById(Integer available, Long id);

}
