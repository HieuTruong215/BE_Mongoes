package com.homecare.Homecare.convert;

import org.springframework.stereotype.Component;

import com.homecare.Homecare.dto.ProductDTO;
import com.homecare.Homecare.dto.UserDTO;
import com.homecare.Homecare.entity.ProductEntity;
import com.homecare.Homecare.entity.UserEntity;



@Component
public class UserConvert {
	public UserEntity dtoToEntity(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(userDTO.getId());
		userEntity.setUsername(userDTO.getUsername());
		userEntity.setEmail(userDTO.getEmail());
		userEntity.setPassword(userDTO.getPassword());
		userEntity.setCombos(userDTO.getCombos());
		
		return userEntity ;
	} 
	public UserDTO entityToDto(UserEntity userEntity) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(userEntity.getId());
		userDTO.setUsername(userEntity.getUsername());
		userDTO.setEmail(userEntity.getEmail());
		userDTO.setPassword(userEntity.getPassword());
		userDTO.setCombos(userEntity.getCombos());
		
		return userDTO ;
	} 
}
