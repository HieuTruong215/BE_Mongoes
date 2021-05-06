package com.homecare.Homecare.convert;

import org.springframework.stereotype.Component;

import com.homecare.Homecare.dto.ComboDTO;
import com.homecare.Homecare.dto.EmployeeDTO;
import com.homecare.Homecare.entity.ComboEntity;
import com.homecare.Homecare.entity.EmployeeEntity;

@Component
public class EmployeeConvert {
	public EmployeeEntity dtotoEntity(EmployeeDTO employeeDTO) {
		EmployeeEntity employeeEntity = new EmployeeEntity() ;
		employeeEntity.setId(employeeDTO.getId());
		employeeEntity.setFullName(employeeDTO.getFullName());
		employeeEntity.setPhone(employeeDTO.getPhone());
		employeeEntity.setBirthday(employeeDTO.getBirthday());
		employeeEntity.setProvince(employeeDTO.getProvince());
		employeeEntity.setDaytowork(employeeDTO.getDaytowork());
		employeeEntity.setIndentity(employeeDTO.getIndentity());
		employeeEntity.setSalary(employeeDTO.getSalary());
		employeeEntity.setDepartment(employeeDTO.getDepartment());
		employeeEntity.setImage(employeeDTO.getImage());
		employeeEntity.setAddress(employeeDTO.getAddress());
		employeeEntity.setGender(employeeDTO.getGender());
		employeeEntity.setEmail(employeeDTO.getEmail());
		return employeeEntity ;
	}
	public EmployeeDTO entitytoDTO(EmployeeEntity employeeEntity) {
		EmployeeDTO employeeDTO = new EmployeeDTO() ;
		employeeDTO.setId(employeeEntity.getId());
		employeeDTO.setSalary(employeeEntity.getSalary());
		employeeDTO.setIndentity(employeeEntity.getIndentity());
		employeeDTO.setFullName(employeeEntity.getFullName());
		employeeDTO.setPhone(employeeEntity.getPhone());
		employeeDTO.setBirthday(employeeEntity.getBirthday());
		employeeDTO.setProvince(employeeEntity.getProvince());
		employeeDTO.setDaytowork(employeeEntity.getDaytowork());
		employeeDTO.setDepartment(employeeEntity.getDepartment());
		employeeDTO.setImage(employeeEntity.getImage());
		employeeDTO.setAddress(employeeEntity.getAddress());
		employeeDTO.setGender(employeeEntity.getGender());
		employeeDTO.setEmail(employeeEntity.getEmail());
		return employeeDTO ;
	}
}