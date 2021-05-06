package com.homecare.Homecare.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.homecare.Homecare.dto.ComboDTO;
import com.homecare.Homecare.reponse.success.SuccessResponse;
import com.homecare.Homecare.service.ComboService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/v1")
public class ComboController {
	@Autowired
	private ComboService comboService;

	@GetMapping("/combo")
	public SuccessResponse<ComboDTO> findAll() {
		return comboService.findAllCombo();
	}
	
	@PutMapping("/{id}/edit/combo")
	public SuccessResponse<ComboDTO> edit(@RequestBody ComboDTO comboDTO) {
	    return this.comboService.edit(comboDTO);
	} 
	
	@GetMapping("/combo/{id}")
	public SuccessResponse<ComboDTO> findByID(@PathVariable String id) {
		return comboService.findById(id);

	}
	@DeleteMapping("/combo/{id}")
	@ResponseBody
	public SuccessResponse deleteBrand(@PathVariable("id") String idCombo) {
	    return this.comboService.deleteCombo(idCombo);
	}

	@PostMapping("/add/combo")
	public SuccessResponse save(@RequestBody ComboDTO comboDTO) {
		return comboService.save(comboDTO);
	}
	
}
