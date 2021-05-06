package com.homecare.Homecare.Controller;

import java.util.List;



import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.homecare.Homecare.dto.EmployeeDTO;

import com.homecare.Homecare.reponse.success.SuccessResponse;

import com.homecare.Homecare.service.EmployeeService;


@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService ;
@GetMapping("/employee/{id}")
public SuccessResponse<EmployeeDTO> findByID(@PathVariable String id) {
	return employeeService.findById(id) ;
}
@GetMapping("/employee")
public SuccessResponse<EmployeeDTO> findAll() {
	return employeeService.findAllUser() ;
}
@PostMapping("/add/employee")
public SuccessResponse addUser(@RequestBody EmployeeDTO employeeDTO) {
	return this.employeeService.save(employeeDTO) ;
}
@DeleteMapping("/employee/{idEmployee}")
@ResponseBody
public SuccessResponse deleteEmployee(@PathVariable("idEmployee") String idEmployee) {
    return this.employeeService.deleteEmployee(idEmployee);
}
@PutMapping("/{id}/edit/employee")
public SuccessResponse edit(@RequestBody EmployeeDTO employeeDTO) {
    return this.employeeService.edit(employeeDTO);
}
}

