package com.example.backend.repository;
import com.example.backend.entity.CartGeneral;
import com.example.backend.entity.CartProduct;
import com.example.backend.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import lombok.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, Long> {
    @Transactional
    @Modifying
    @Query("delete from CartProduct c where c.cartGeneral = ?1")
    void deleteByCartGeneral(@NonNull CartGeneral cartGeneral);

    Optional<CartProduct> findByCartGeneral_UserAuthTokenAndProductDetail_Id(@NonNull String userAuthToken, @NonNull Long id);

    @Transactional
    @Modifying
    @Query("delete from CartProduct c where c.productDetail = ?1")
    void deleteByProductDetail(@NonNull ProductDetail productDetail);
}