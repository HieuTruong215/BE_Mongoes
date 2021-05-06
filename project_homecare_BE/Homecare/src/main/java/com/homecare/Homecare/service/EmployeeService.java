package com.homecare.Homecare.service;

import java.util.List;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homecare.Homecare.convert.EmployeeConvert;
import com.homecare.Homecare.dto.EmployeeDTO;

import com.homecare.Homecare.entity.EmployeeEntity;

import com.homecare.Homecare.exception.BadRequestException;
import com.homecare.Homecare.exception.NotFoundException;
import com.homecare.Homecare.reponse.success.SuccessResponse;
import com.homecare.Homecare.repository.EmployeeRepository;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository ;
	@Autowired
	private EmployeeConvert employeeConvert ;
	
	@Transactional
	public SuccessResponse edit(EmployeeDTO employeeDTO) {
		if(this.findById(employeeDTO.getId()) == null) throw new NotFoundException("") ;
		{
		Optional<EmployeeEntity> optionalCustomerEntity = employeeRepository.findById(employeeDTO.getId());
		EmployeeEntity employeeEntity = optionalCustomerEntity.orElseThrow(() -> new BadRequestException("ID not correct"));
		employeeEntity.setFullName(employeeDTO.getFullName());
		employeeEntity.setPhone(employeeDTO.getPhone());
		employeeEntity.setBirthday(employeeDTO.getBirthday());
		employeeEntity.setProvince(employeeDTO.getProvince());
		employeeEntity.setDaytowork(employeeDTO.getDaytowork());
		employeeEntity.setDepartment(employeeDTO.getDepartment());
		employeeEntity.setIndentity(employeeDTO.getIndentity());
		employeeEntity.setSalary(employeeDTO.getSalary());
		employeeEntity.setImage(employeeDTO.getImage());
		employeeEntity.setAddress(employeeDTO.getAddress());
		employeeEntity.setGender(employeeDTO.getGender());
		employeeEntity.setEmail(employeeDTO.getEmail());
		employeeConvert.entitytoDTO(employeeRepository.save(employeeEntity));
	}
		return new SuccessResponse();
	}
	@Transactional
	 public SuccessResponse deleteEmployee(String employeeId) {
	        Optional<EmployeeEntity> employeeEntityOptional = this.employeeRepository.findById(employeeId);
	        if (!employeeEntityOptional.isPresent()) {
	            throw new NotFoundException("Profile");
	        }

	        this.employeeRepository.deleteById(employeeId);

	        return new SuccessResponse();
	    }
	
	@Transactional
	public SuccessResponse save(EmployeeDTO employeeDTO) {
	    EmployeeEntity employeeEntity = new EmployeeEntity();
	    if ( employeeDTO.getFullName() == null ) {
	        throw new BadRequestException("Invalid input");
	    }
	    else {
	        UUID id = UUID.randomUUID();
	        employeeDTO.setId(id.toString());
	        employeeEntity.setId(employeeDTO.getId());
			employeeEntity.setFullName(employeeDTO.getFullName());
			employeeEntity.setPhone(employeeDTO.getPhone());
			employeeEntity.setBirthday(employeeDTO.getBirthday());
			employeeEntity.setProvince(employeeDTO.getProvince());
			employeeEntity.setDaytowork(employeeDTO.getDaytowork());
			employeeEntity.setDepartment(employeeDTO.getDepartment());
			employeeEntity.setIndentity(employeeDTO.getIndentity());
			employeeEntity.setSalary(employeeDTO.getSalary());
			employeeEntity.setImage(employeeDTO.getImage());
			employeeEntity.setAddress(employeeDTO.getAddress());
			employeeEntity.setGender(employeeDTO.getGender());
			employeeEntity.setEmail(employeeDTO.getEmail());
	        employeeRepository.save(employeeEntity);
	    }
	    SuccessResponse successResponse = new SuccessResponse();
	    successResponse.setCode(201);
	    return successResponse;
	}
	
		public SuccessResponse findById(String idEmployee) {
			Optional<EmployeeEntity> optionalEmployee = employeeRepository.findById(idEmployee);
			if (optionalEmployee.isPresent()) {
				return new SuccessResponse(this.employeeConvert.entitytoDTO(optionalEmployee.get()));
			}
			return new SuccessResponse();
		}
		 public SuccessResponse findAllUser(){
		        SuccessResponse successResponse = new SuccessResponse();
		        successResponse.setData(employeeRepository.findAll());
		        return successResponse;
		    }
	
}
