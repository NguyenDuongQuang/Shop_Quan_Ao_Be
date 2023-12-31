package com.example.backend.controler.admin;

import com.example.backend.dto.ProductDto;
import com.example.backend.dto.UpdateProductDto;
import com.example.backend.entity.Product;
import com.example.backend.model.ProductSearchCriteriaModel;
import com.example.backend.model.ResponseChangeDataModel;
import com.example.backend.model.ResponseGetDataModel;
import com.example.backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Validated
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody @Valid ProductDto productDto) throws Exception {
        return ResponseEntity.ok().body(
                new ResponseChangeDataModel(productService.createProduct(productDto), HttpStatus.OK.value()));
    }

    @GetMapping("/get-detail/{id}")
    public ResponseEntity<?> getProductById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(productService.getProductById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProductById(@RequestBody @Valid UpdateProductDto updateProductDto,
                                               @PathVariable Long id) throws Exception {
        return ResponseEntity.ok().body(
                new ResponseChangeDataModel(productService.updateProduct(updateProductDto, id), HttpStatus.OK.value())
        );
    }

    @PostMapping("/get-list")
    public ResponseEntity<?> getProducts(@RequestBody ProductSearchCriteriaModel productSearchCriteriaModel) {
        Page<Product> productPage = productService.getProducts(productSearchCriteriaModel);
        return ResponseEntity.ok().body(new ResponseGetDataModel(productPage.getContent(), productPage.getNumber(),
                productPage.getTotalElements(), productPage.getTotalPages()));
    }

    @PutMapping("/updateAvailable/{product-id}")
    public ResponseEntity<?> updateAvailableById(@RequestParam Integer available, @PathVariable(name = "product-id") Long id) {
        return ResponseEntity.ok().body(
                new ResponseChangeDataModel(productService.updateAvailableById(available, id), HttpStatus.OK.value()));
    }

}
