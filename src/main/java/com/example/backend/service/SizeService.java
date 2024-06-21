package com.example.backend.service;

import com.example.backend.dto.SizeDto;
import com.example.backend.dto.UpdateSizeDto;
import com.example.backend.entity.Size;
import com.example.backend.model.SizeSearchCriteriaModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SizeService {
    Size getSize(Integer id);
    Size createSize(SizeDto sizeDto) throws Exception;
    Size updateSize(UpdateSizeDto updateSizeDto, Integer id) throws Exception;
    Page<Size> getColors(SizeSearchCriteriaModel sizeSearchCriteriaModel);
    List<Size> getAllSize();

}
