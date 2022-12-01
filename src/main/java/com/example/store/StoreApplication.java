package com.example.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 요구사항 분석
 *
 * 상품 등록/조회/수정이 가능해야한다.
 *
 * 상품의 field (Entity)
 * String itemName
 * int price
 * int quantity
 */
@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}

}
