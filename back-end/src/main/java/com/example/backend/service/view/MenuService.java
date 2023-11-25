package com.example.backend.service.view;

import com.example.backend.dto.sale.BrandSaleDto;
import com.example.backend.dto.sale.MadeInSaleDto;
import com.example.backend.dto.sale.ProductSetSaleDto;

import java.util.List;

public interface MenuService {

    List<ProductSetSaleDto> getActiveProductSetsAndCategory();

    List<BrandSaleDto> getActiveBrands();

    List<MadeInSaleDto> getActiveMadeIns();

}
