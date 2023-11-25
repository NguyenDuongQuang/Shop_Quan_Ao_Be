
package com.example.backend.repository;
import com.example.backend.entity.MadeIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MadeInRepository  extends JpaRepository<MadeIn,Integer> {
    List<MadeIn> findByNameLike(String name);
}
