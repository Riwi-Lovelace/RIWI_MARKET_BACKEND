package com.riwi.RiwiMarket;


import com.riwi.RiwiMarket.api.controllers.StoreController;
import com.riwi.RiwiMarket.api.dtos.responses.StoreResponse;
import com.riwi.RiwiMarket.domain.entities.Store;
import com.riwi.RiwiMarket.domain.repositories.StoreRepository;
import com.riwi.RiwiMarket.infrastructure.services.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;


@SpringBootApplication
public class RiwiMarketApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RiwiMarketApplication.class, args);
	}
		


}
