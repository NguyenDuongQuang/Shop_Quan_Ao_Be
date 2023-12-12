package com.example.backend.repository;
import com.example.backend.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    @Query(value = "select * from order_detail where order_id = ? and is_deleted = false", nativeQuery = true)
    List<OrderDetail> findByIDBill(Long id);

}