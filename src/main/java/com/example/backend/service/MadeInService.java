package com.example.backend.service;
import com.example.backend.dto.MadeInDto;
import com.example.backend.dto.UpdateMadeInDto;
import com.example.backend.entity.MadeIn;
import com.example.backend.model.MadeInSearchCriteriaModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MadeInService {
    MadeIn getMadeIn(Integer id);
    MadeIn createMadeIn(MadeInDto madeInDto) throws Exception;
    MadeIn updateMadeIn(UpdateMadeInDto madeInDto, Integer id) throws Exception;
    Page<MadeIn> getMadeIns(MadeInSearchCriteriaModel madeInSearchCriteriaModel);
    List<MadeIn> getAllMadeIn();

}

