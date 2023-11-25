package com.example.backend.service;

import com.example.backend.dto.VoucherDto;
import com.example.backend.entity.Voucher;
import com.example.backend.model.VoucherSearchCriteriaModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VoucherService {

    List<Voucher> createVoucherForLeadCustomers();

    List<Voucher> getUsableVouchersByEmail(String email);

    List<Voucher> getUsableVoucherForAnonymous();

    Voucher createVoucher(VoucherDto voucherDto);

    Voucher updateVoucher(Long id, VoucherDto voucherDto);

    Page<Voucher> getVouchers(VoucherSearchCriteriaModel voucherSearchCriteriaModel);

    Voucher getVoucherDetail(Long id);

}
