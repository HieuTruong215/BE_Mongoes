package com.homecare.Homecare.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homecare.Homecare.dto.EmployeeDTO;
import com.homecare.Homecare.dto.ProductDTO;
import com.homecare.Homecare.reponse.success.SuccessResponse;
import com.homecare.Homecare.service.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
@Autowired
private ProductService productService ;

@GetMapping("/product")
public SuccessResponse<ProductDTO> findAll(){
	return productService.findAllProduct();
}
@GetMapping("/product/{id}")
public SuccessResponse<ProductDTO> findById(@PathVariable String id){
	return productService.findById(id) ;
}
@PostMapping("/add/product")
public SuccessResponse addProduct(@RequestBody ProductDTO productDTO) {
	return this.productService.save(productDTO) ;
}


@PutMapping("/{id}/edit/product")
public SuccessResponse edit(@RequestBody ProductDTO productDTO) {
    return this.productService.edit(productDTO);
}
@DeleteMapping("/product/{id}")
public SuccessResponse deleteBrand(@PathVariable("idProduct") String idProduct) {
    return this.productService.deleteProduct(idProduct);
}
}
