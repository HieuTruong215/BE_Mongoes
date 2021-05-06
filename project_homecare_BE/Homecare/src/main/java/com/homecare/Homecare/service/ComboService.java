package com.homecare.Homecare.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homecare.Homecare.convert.ComboConvert;
import com.homecare.Homecare.dto.ComboDTO;
import com.homecare.Homecare.entity.BrandEntity;
import com.homecare.Homecare.entity.ComboEntity;
import com.homecare.Homecare.exception.BadRequestException;
import com.homecare.Homecare.exception.NotFoundException;
import com.homecare.Homecare.reponse.success.SuccessResponse;
import com.homecare.Homecare.repository.ComboRepository;


@Service
public class ComboService {
	@Autowired
	private ComboRepository comboRepository;
	@Autowired
	private ComboConvert comboConvert;

	@Transactional
	public SuccessResponse edit(ComboDTO comboDTO) {
		if (this.findById(comboDTO.getId()) == null)
			throw new NotFoundException("");
		{
			Optional<ComboEntity> optionalComboEntity = comboRepository.findById(comboDTO.getId());
			ComboEntity comboEntity = optionalComboEntity.orElseThrow(() -> new BadRequestException("ID not correct"));
			comboEntity.setName(comboDTO.getName());
			comboEntity.setPrice(comboDTO.getPrice());
			comboEntity.setId(comboDTO.getId());
			comboEntity.setImage(comboDTO.getImage());
			comboEntity.setTime(comboDTO.getTime());
			comboEntity.setInformation(comboDTO.getInformation());
			comboConvert.entitytoDTO(comboRepository.save(comboEntity));
		}
		return new SuccessResponse();
	}

	@Transactional
	public SuccessResponse save(ComboDTO comboDTO) {
		ComboEntity comboEntity = new ComboEntity();
		if(comboDTO.getName() == null || comboDTO.getPrice() == null || comboDTO.getTime() == null) {
			throw new BadRequestException("Ivalid Input") ;
		}
		else {
			UUID id = UUID.randomUUID();
			comboDTO.setId(id.toString());
			comboEntity.setName(comboDTO.getName());
			comboEntity.setImage(comboDTO.getImage());
			comboEntity.setPrice(comboDTO.getPrice());
			comboEntity.setTime(comboDTO.getTime());
			comboEntity.setInformation(comboDTO.getInformation());
			comboRepository.save(comboEntity);
		}
		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setCode(201);
		return successResponse ;
	}

	public SuccessResponse findById(String idCombo) {
		Optional<ComboEntity> optionalCombo = comboRepository.findById(idCombo);
		if (optionalCombo.isPresent()) {
			return new SuccessResponse(this.comboConvert.entitytoDTO(optionalCombo.get()));
		}
		return new SuccessResponse();
	}

	public SuccessResponse findAllCombo() {
		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setData(comboRepository.findAll());
		return successResponse;
	}

		@Transactional
		 public SuccessResponse deleteCombo(String idCombo) {
		        Optional<ComboEntity> comboEntityOptional = this.comboRepository.findById(idCombo);
		        if (!comboEntityOptional.isPresent()) {
		            throw new NotFoundException("Combo");
		        }
		        this.comboRepository.deleteById(idCombo);
		        return new SuccessResponse();
		    }
	}
