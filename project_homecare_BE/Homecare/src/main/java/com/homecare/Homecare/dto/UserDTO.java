package com.homecare.Homecare.dto;



import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private String id;

	private String username;

	private String email;

	private String password;
	
	private List<ComboDTO> combos;

}
