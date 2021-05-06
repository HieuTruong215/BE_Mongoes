package com.homecare.Homecare.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homecare.Homecare.convert.BrandConvert;
import com.homecare.Homecare.dto.BrandDTO;
import com.homecare.Homecare.entity.BrandEntity;
import com.homecare.Homecare.entity.EmployeeEntity;
import com.homecare.Homecare.exception.BadRequestException;
import com.homecare.Homecare.exception.NotFoundException;
import com.homecare.Homecare.reponse.success.SuccessResponse;
import com.homecare.Homecare.repository.BrandRepository;

@Service
public class BrandService {

	@Autowired
	private BrandRepository brandRepository;
	@Autowired
	private BrandConvert brandConvert;

	@Transactional
	public SuccessResponse edit(BrandDTO brandDTO) {
		if (this.findById(brandDTO.getId()) == null)
			throw new NotFoundException("");
		{
			Optional<BrandEntity> optionalBrandEntity = brandRepository.findById(brandDTO.getId());
			BrandEntity brandEntity = optionalBrandEntity
					.orElseThrow(() -> new BadRequestException("id not correct"));
			brandEntity.setTitle(brandDTO.getTitle());
			brandConvert.entityToDto(brandRepository.save(brandEntity));
		}
		return new SuccessResponse();
	}

	@Transactional
	 public SuccessResponse deleteBrand(String brandId) {
	        Optional<BrandEntity> brandEntityOptional = this.brandRepository.findById(brandId);
	        if (!brandEntityOptional.isPresent()) {
	            throw new NotFoundException("Profile");
	        }

	        this.brandRepository.deleteById(brandId);

	        return new SuccessResponse();
	    }
	
	@Transactional
	public SuccessResponse save(BrandDTO brandDTO) {
		BrandEntity brandEntity = new BrandEntity();
		if (brandDTO.getTitle() == null)
			throw new BadRequestException("Invalid Input");
		else {
			UUID id = UUID.randomUUID();
			brandDTO.setId(id.toString());
			brandEntity.setId(brandDTO.getId());
			brandEntity.setTitle(brandDTO.getTitle());
			brandEntity = brandConvert.dtoToEntity(brandDTO);
			brandRepository.save(brandEntity);

		}
		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setCode(201);
		return successResponse;
	}

	public SuccessResponse findById(String idBrand) {
		Optional<BrandEntity> optionalBrand = brandRepository.findById(idBrand);
		if (optionalBrand.isPresent()) {
			return new SuccessResponse(this.brandConvert.entityToDto(optionalBrand.get()));
		}
		return new SuccessResponse();
	}

	public SuccessResponse findAllBrand() {
		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setData(brandRepository.findAll());
		return successResponse;
	}
}
