package com.example.backend.repository;
import com.example.backend.entity.CustomerVoucherRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerVoucherRecordRepository extends JpaRepository<CustomerVoucherRecord, Long> {
    List<CustomerVoucherRecord> findByEmailLikeIgnoreCaseAndCodeLikeIgnoreCase(@NonNull String email, @NonNull String code);
}