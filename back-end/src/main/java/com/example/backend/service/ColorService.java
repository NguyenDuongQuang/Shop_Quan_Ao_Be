package com.example.backend.service;
import com.example.backend.dto.ColorDto;
import com.example.backend.dto.UpdateColorDto;
import com.example.backend.entity.Color;
import com.example.backend.model.ColorSearchCriteriaModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ColorService {
    Color getColor(Integer id);
    Color createColor(ColorDto color) throws Exception;
    Color updateColor(UpdateColorDto updateColorDto, Integer id) throws Exception;
    Page<Color> getColors(ColorSearchCriteriaModel colorSearchCriteriaModel);

    List<Color> getAllColor();
}
