package com.example.backend.controler.admin;

import com.example.backend.dto.PromotionCategoryDto;
import com.example.backend.dto.UpdatePromotionCategoryDto;
import com.example.backend.entity.PromotionCategory;
import com.example.backend.model.PromotionCategorySearchCriteriaModel;
import com.example.backend.model.ResponseChangeDataModel;
import com.example.backend.model.ResponseGetDataModel;
import com.example.backend.service.PromotionCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/promotion/category")
@CrossOrigin("*")
@RequiredArgsConstructor
@Validated
public class PromotionCategoryController {
    private final PromotionCategoryService promotionCategoryService;

    @PostMapping("/create")
    public ResponseEntity<?> createPromotionCategory(@RequestBody @Valid PromotionCategoryDto promotionCategoryDto) throws Exception {
        return ResponseEntity.ok().body(new ResponseChangeDataModel(promotionCategoryService.createPromotionCategory(promotionCategoryDto), HttpStatus.OK.value()));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePromotionCategory(@PathVariable(value = "id") Integer id, @RequestBody UpdatePromotionCategoryDto promotionCategoryDto) throws Exception {
        return ResponseEntity.ok().body(new ResponseChangeDataModel(promotionCategoryService.updatePromotionCategory(promotionCategoryDto, id), HttpStatus.OK.value()));
    }

    @GetMapping("/get-detail/{id}")
    public ResponseEntity<?> getPromotionCategory(@PathVariable(name = "id") @Positive Integer id) {
        return ResponseEntity.ok().body(promotionCategoryService.getPromotionCategory(id));
    }

    @PostMapping("/get-list")
    public ResponseEntity<?> getPromotionCategories(@RequestBody PromotionCategorySearchCriteriaModel promotionCategorySearchCriteriaModel) {
        Page<PromotionCategory> pageElements = promotionCategoryService.getPromotionCategories(promotionCategorySearchCriteriaModel);
        return ResponseEntity.ok().body(new ResponseGetDataModel(pageElements.getContent(), pageElements.getNumber(), pageElements.getTotalElements(), pageElements.getTotalPages()));
    }
}
