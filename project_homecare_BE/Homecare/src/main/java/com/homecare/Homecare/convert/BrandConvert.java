package com.homecare.Homecare.convert;

import org.springframework.stereotype.Component;

import com.homecare.Homecare.dto.BrandDTO;
import com.homecare.Homecare.dto.ProductDTO;
import com.homecare.Homecare.entity.BrandEntity;
import com.homecare.Homecare.entity.ProductEntity;

@Component
public class BrandConvert {
	public BrandEntity dtoToEntity(BrandDTO brandDTO) {
		BrandEntity brandEntity = new BrandEntity();
		brandEntity.setId(brandDTO.getId());
		brandEntity.setTitle(brandDTO.getTitle());
		return brandEntity ;
	} 
	public BrandDTO entityToDto(BrandEntity brandEntity) {
		BrandDTO brandDTO = new BrandDTO();
		brandDTO.setId(brandEntity.getId());
		brandDTO.setTitle(brandEntity.getTitle());
		return brandDTO ;
	}
}
