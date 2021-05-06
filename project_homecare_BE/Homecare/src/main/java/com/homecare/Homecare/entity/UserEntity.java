package com.homecare.Homecare.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.homecare.Homecare.dto.ComboDTO;
import com.homecare.Homecare.dto.RoleDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class UserEntity {
	@Id
	private String id ; 
	@NotBlank
	private String username ;
	@NotBlank
	private String email ;
	@NotBlank
	private String password ;
	@NotBlank
	private List<ComboDTO> combos;
	
	
}

