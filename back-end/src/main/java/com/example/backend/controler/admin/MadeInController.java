package com.example.backend.controler.admin;

import com.example.backend.dto.MadeInDto;
import com.example.backend.dto.UpdateMadeInDto;
import com.example.backend.entity.MadeIn;
import com.example.backend.model.MadeInSearchCriteriaModel;
import com.example.backend.model.ResponseChangeDataModel;
import com.example.backend.model.ResponseGetDataModel;
import com.example.backend.service.MadeInService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/madein")
@RequiredArgsConstructor
@Validated
@CrossOrigin("*")
public class MadeInController {
    private final MadeInService madeInService;
    @GetMapping("/get-detail/{id}")
    public ResponseEntity<?> getMadeIn(@PathVariable(name="id") Integer id){
        return ResponseEntity.ok().body(madeInService.getMadeIn(id));
    }
    @PostMapping("/get-list")
    public ResponseEntity<?> getMadeIns(@RequestBody MadeInSearchCriteriaModel madeInSearchCriteriaModel) {
        Page<MadeIn> pageElements = madeInService.getMadeIns(madeInSearchCriteriaModel);
        return ResponseEntity.ok().body(new ResponseGetDataModel(pageElements.getContent(),pageElements.getNumber(), pageElements.getTotalElements(), pageElements.getTotalPages()));
    }
    @PostMapping("/create")
    public ResponseEntity<?> createMadeIn(@RequestBody @Valid MadeInDto madeInDto) throws Exception{
        return ResponseEntity.ok().body(new ResponseChangeDataModel(madeInService.createMadeIn(madeInDto),HttpStatus.OK.value()));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMadeIn(@PathVariable(value = "id") Integer id, @RequestBody UpdateMadeInDto madeIn) throws Exception {
        return ResponseEntity.ok().body(new ResponseChangeDataModel( madeInService.updateMadeIn(madeIn, id),HttpStatus.OK.value()));
    }
    @GetMapping("/get-all")
    public ResponseEntity<?> getAllMadein() {
        return ResponseEntity.ok().body(madeInService.getAllMadeIn());
    }


}
