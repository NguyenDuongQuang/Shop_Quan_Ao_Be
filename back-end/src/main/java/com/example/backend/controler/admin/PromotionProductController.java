package com.example.backend.controler.admin;

import com.example.backend.dto.PromotionProductDto;
import com.example.backend.dto.UpdatePromotionProductDto;
import com.example.backend.entity.PromotionProduct;
import com.example.backend.model.PromotionProductSearchCriteriaModel;
import com.example.backend.model.ResponseChangeDataModel;
import com.example.backend.model.ResponseGetDataModel;
import com.example.backend.service.PromotionProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/promotion/product")
@CrossOrigin("*")
@RequiredArgsConstructor
@Validated
public class PromotionProductController {
    private final PromotionProductService promotionProductService;

    @PostMapping("/create")
    public ResponseEntity<?> createPromotionProduct(@RequestBody @Valid PromotionProductDto promotionProductDto) throws Exception {
        return ResponseEntity.ok().body(new
                ResponseChangeDataModel(promotionProductService.createPromotionProduct(promotionProductDto), HttpStatus.OK.value()));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePromotionProduct(@PathVariable(value = "id") Long id,
                                                    @RequestBody UpdatePromotionProductDto promotionProductDto) throws Exception {
        return ResponseEntity.ok().body(new ResponseChangeDataModel(
                promotionProductService.updatePromotionProduct(promotionProductDto, id), HttpStatus.OK.value()));
    }

    @GetMapping("/get-detail/{id}")
    public ResponseEntity<?> getPromotionProduct(@PathVariable(name = "id") @Positive Long id) {
        return ResponseEntity.ok().body(promotionProductService.getPromotionProduct(id));
    }

    @PostMapping("/get-list")
    public ResponseEntity<?> getPromotionProducts(@RequestBody PromotionProductSearchCriteriaModel promotionProductSearchCriteriaModel) {
        Page<PromotionProduct> pageElements = promotionProductService.getPromotionProducts(promotionProductSearchCriteriaModel);
        return ResponseEntity.ok().body(new ResponseGetDataModel(pageElements.getContent(), pageElements.getNumber(),
                pageElements.getTotalElements(), pageElements.getTotalPages()));
    }
}
