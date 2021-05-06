package com.homecare.Homecare.convert;

import org.springframework.stereotype.Component;

import com.homecare.Homecare.dto.ComboDTO;
import com.homecare.Homecare.entity.ComboEntity;

@Component
public class ComboConvert {
	public ComboEntity dtotoEntity(ComboDTO comboDTO) {
		ComboEntity comboEntity = new ComboEntity() ;
		comboEntity.setId(comboDTO.getId()) ;
		comboEntity.setName(comboDTO.getName());
		comboEntity.setPrice(comboDTO.getPrice());
		comboEntity.setTime(comboDTO.getTime());
		comboEntity.setImage(comboDTO.getImage());
		comboEntity.setInformation(comboDTO.getInformation());
		return comboEntity ;
	}
	public ComboDTO entitytoDTO(ComboEntity comboEntity) {
		ComboDTO comboDTO = new ComboDTO() ;
		comboDTO.setId(comboEntity.getId());
		comboDTO.setName(comboEntity.getName());
		comboDTO.setPrice(comboEntity.getPrice());
		comboDTO.setImage(comboEntity.getImage());
		comboDTO.setTime(comboEntity.getTime());
		comboDTO.setInformation(comboEntity.getInformation());
		return comboDTO ;
		
	}
}
