package com.example.backend.repository;
import com.example.backend.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColorRepository  extends JpaRepository<Color,Integer> {
    List<Color> findByNameLike(String name);
}
