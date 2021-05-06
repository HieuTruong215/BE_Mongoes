package com.homecare.Homecare.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homecare.Homecare.convert.BrandConvert;
import com.homecare.Homecare.convert.UserConvert;
import com.homecare.Homecare.dto.BrandDTO;
import com.homecare.Homecare.dto.UserDTO;
import com.homecare.Homecare.entity.UserEntity;
import com.homecare.Homecare.entity.UserEntity;
import com.homecare.Homecare.exception.BadRequestException;
import com.homecare.Homecare.exception.NotFoundException;
import com.homecare.Homecare.reponse.success.SuccessResponse;
import com.homecare.Homecare.repository.BrandRepository;
import com.homecare.Homecare.repository.UserDetailRepository;
import com.homecare.Homecare.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserDetailRepository userRepository;
	@Autowired
	private UserConvert userConvert;

	public SuccessResponse findAllUser() {
		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setData(userRepository.findAll());
		return successResponse;
	}
	
//	@Transactional
//	public SuccessResponse save(UserDTO userDTO) {
//		UserEntity userEntity = new UserEntity();
//		if (userDTO.getUsername() == null)
//			throw new BadRequestException("Invalid Input");
//		else {
//			UUID id = UUID.randomUUID();
//			userDTO.setId(id.toString());
//			userEntity.setId(brandDTO.getId());
//			userEntity.setTitle(brandDTO.getTitle());
//			userEntity = brandConvert.dtoToEntity(brandDTO);
//			brandRepository.save(userEntity);
//
//		}
//		SuccessResponse successResponse = new SuccessResponse();
//		successResponse.setCode(201);
//		return successResponse;
//	}

	@Transactional
	public SuccessResponse edit(UserDTO userDTO) {
		if (this.findById(userDTO.getId()) == null)
			throw new NotFoundException("");
		{
			Optional<UserEntity> optionalUserEntity = userRepository.findById(userDTO.getId());
			UserEntity userEntity = optionalUserEntity
					.orElseThrow(() -> new BadRequestException("id not correct"));
			userEntity.setCombos(userDTO.getCombos());
			userConvert.entityToDto(userRepository.save(userEntity));
		}
		return new SuccessResponse();
	}
	public SuccessResponse findById(String id) {
		Optional<UserEntity> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			return new SuccessResponse(this.userConvert.entityToDto(optionalUser.get()));
		}
		return new SuccessResponse();
	}
}
