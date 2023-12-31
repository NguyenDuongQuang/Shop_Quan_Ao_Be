package com.example.backend.controler.admin;

import com.example.backend.dto.BrandDto;
import com.example.backend.dto.UpdateBrandDto;
import com.example.backend.entity.Brand;
import com.example.backend.model.BrandSearchCriteriaModel;
import com.example.backend.model.ResponseChangeDataModel;
import com.example.backend.model.ResponseGetDataModel;
import com.example.backend.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
@Validated
@CrossOrigin("*")
public class BrandController {

    private final BrandService brandService;

    @PostMapping("/create")
    public ResponseEntity<?> insertBrand(@RequestBody @Valid BrandDto brand) throws Exception {
        return ResponseEntity.ok().body(
                new ResponseChangeDataModel(brandService.createBrand(brand), HttpStatus.OK.value()));
    }

    @GetMapping("/get-detail/{id}")
    public ResponseEntity<?> getBrandById(@PathVariable @Positive Integer id) {
        return ResponseEntity.ok().body(brandService.getBrandById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBrandById(@PathVariable @Positive Integer id, @RequestBody UpdateBrandDto brandDto) throws Exception {
        return ResponseEntity.ok().body(
                new ResponseChangeDataModel(brandService.updateBrandById(brandDto, id), HttpStatus.OK.value())
        );
    }

    @PostMapping("/get-list")
    public ResponseEntity<?> getAllBrands(@RequestBody BrandSearchCriteriaModel brandSearchCriteriaModel) {
        Page<Brand> brandPage = brandService.getBrands(brandSearchCriteriaModel);
        return ResponseEntity.ok().body(new ResponseGetDataModel(brandPage.getContent(), brandPage.getNumber(),
                brandPage.getTotalElements(), brandPage.getTotalPages()));
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllActiveBrands() {
        return ResponseEntity.ok().body(brandService.getBrandsByStatus(1));
    }

}
