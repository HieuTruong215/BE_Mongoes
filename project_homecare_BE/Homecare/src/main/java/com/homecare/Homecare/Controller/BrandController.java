package com.homecare.Homecare.Controller;

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

import com.homecare.Homecare.dto.BrandDTO;
import com.homecare.Homecare.dto.ProductDTO;
import com.homecare.Homecare.reponse.success.SuccessResponse;
import com.homecare.Homecare.service.BrandService;
import com.homecare.Homecare.service.ProductService;

@RestController
@RequestMapping("/api/v1")
public class BrandController {
	@Autowired
	private BrandService brandService;

	@GetMapping("/brand")
	public SuccessResponse<BrandDTO> findAll() {
		return brandService.findAllBrand();
	}

	@GetMapping("/brand/{id}")
	public SuccessResponse<BrandDTO> findById(@PathVariable String id) {
		return brandService.findById(id);
	}

	@PostMapping("/add/brand")
	public SuccessResponse addBrand(@RequestBody BrandDTO brandDTO) {
		return this.brandService.save(brandDTO);
	}

@DeleteMapping("/brand/{idBrand}")
@ResponseBody
public SuccessResponse deleteBrand(@PathVariable("idBrand") String idBrand) {
    return this.brandService.deleteBrand(idBrand);
}
@PutMapping("/{id}/edit/brand")
public SuccessResponse edit(@RequestBody BrandDTO brandDTO) {
    return this.brandService.edit(brandDTO);
}

}
