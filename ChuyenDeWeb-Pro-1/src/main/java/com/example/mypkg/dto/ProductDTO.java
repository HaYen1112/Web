package com.example.mypkg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
	private Long id;
	private String code;
	private String productName;
	private Float price;
	private String img;
}
