package com.homecare.Homecare.convert;

import org.springframework.stereotype.Component;

import com.homecare.Homecare.dto.ProductDTO;
import com.homecare.Homecare.entity.ProductEntity;

@Component
public class ProductConvert {
	public ProductEntity dtoToEntity(ProductDTO productDTO) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setId(productDTO.getId());
		productEntity.setTitle(productDTO.getTitle());
		return productEntity ;
	} 
	public ProductDTO entityToDto(ProductEntity productEntity) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(productEntity.getId());
		productDTO.setTitle(productEntity.getTitle());
		return productDTO ;
	}
}
