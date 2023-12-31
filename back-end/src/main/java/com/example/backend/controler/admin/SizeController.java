package com.example.backend.controler.admin;

import com.example.backend.dto.SizeDto;
import com.example.backend.dto.UpdateSizeDto;
import com.example.backend.entity.Size;
import com.example.backend.model.ResponseChangeDataModel;
import com.example.backend.model.ResponseGetDataModel;
import com.example.backend.model.SizeSearchCriteriaModel;
import com.example.backend.service.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/size")
@CrossOrigin("*")
@RequiredArgsConstructor
@Validated
public class SizeController {
    private final SizeService sizeService;
    @GetMapping("/get-detail/{id}")
    public ResponseEntity<?> getSize(@PathVariable(name="id") Integer id){
        return ResponseEntity.ok().body(sizeService.getSize(id));
    }
    @PostMapping("/get-list")
    public ResponseEntity<?> getSizes(@RequestBody SizeSearchCriteriaModel sizeSearchCriteriaModel) {
        Page<Size> pageElements = sizeService.getColors(sizeSearchCriteriaModel);
        return ResponseEntity.ok().body(new ResponseGetDataModel(pageElements.getContent(),pageElements.getNumber(), pageElements.getTotalElements(), pageElements.getTotalPages()));
    }
    @PostMapping("/create")
    public ResponseEntity<?> createSize(@RequestBody SizeDto sizeDto) throws Exception {
        return ResponseEntity.ok().body(
                new ResponseChangeDataModel(sizeService.createSize(sizeDto), HttpStatus.OK.value()));

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateColor(@PathVariable(value = "id") Integer id, @RequestBody UpdateSizeDto sizeDto) throws Exception {
        return ResponseEntity.ok().body(new ResponseChangeDataModel( sizeService.updateSize(sizeDto, id),HttpStatus.OK.value()));
    }
    @GetMapping("/get-all")
    public ResponseEntity<?> getAllSize() {
        return ResponseEntity.ok().body(sizeService.getAllSize());
    }


}
