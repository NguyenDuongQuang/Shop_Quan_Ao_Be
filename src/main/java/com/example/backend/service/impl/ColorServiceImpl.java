package com.example.backend.service.impl;

import com.example.backend.config.Constants;
import com.example.backend.dto.ColorDto;
import com.example.backend.dto.UpdateColorDto;
import com.example.backend.entity.Color;
import com.example.backend.model.ColorSearchCriteriaModel;
import com.example.backend.repository.ColorRepository;
import com.example.backend.repository.criteria.ColorCriteriaRepository;
import com.example.backend.service.ColorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ColorServiceImpl implements ColorService {
    private final ColorRepository colorRepository;
    private final ColorCriteriaRepository colorCriteriaRepository;

    @Override
    public Color getColor(Integer id) {
        return colorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Color does not exist!"));
    }

    @Override
    public Color createColor(ColorDto colorDto) throws Exception {
        Color color = new Color();

        if (!colorRepository.findByNameLike(colorDto.getName().trim()).isEmpty()) {
            throw new Exception(Constants.DUPLICATED_COLOR);
        }

        BeanUtils.copyProperties(colorDto, color);
        color.setName(color.getName().trim());
        color.setUpdatedBy(SecurityContextHolder.getContext().getAuthentication().getName());

        log.info("Created new color: {}", color);
        return colorRepository.save(color);
    }

    @Override
    public Color updateColor(UpdateColorDto updateColorDto, Integer id) throws Exception {
        Color color = colorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Color does not exist!"));

        if (!colorRepository.findByNameLike(updateColorDto.getName().trim()).isEmpty()) {
            if (!updateColorDto.getName().trim().equalsIgnoreCase(color.getName().trim()))
                throw new Exception(Constants.DUPLICATED_COLOR);
        }

        BeanUtils.copyProperties(updateColorDto, color);
        color.setName(color.getName().trim());
        color.setUpdatedAt(new Date());
        color.setUpdatedBy(SecurityContextHolder.getContext().getAuthentication().getName());

        log.info("Updated employee: {}", color);
        return colorRepository.save(color);

    }

    @Override
    public Page<Color> getColors(ColorSearchCriteriaModel colorSearchCriteriaModel) {
        return colorCriteriaRepository.findAllWithFilters(colorSearchCriteriaModel);


    }
    @Override
    public List<Color> getAllColor() {
        return colorRepository.findAll();
    }
}
