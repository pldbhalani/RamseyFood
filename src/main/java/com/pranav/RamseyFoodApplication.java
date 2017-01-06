package com.pranav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pranav.exception.RamseyFoodException;
import com.pranav.module.controller.RamseyFoodController;
import com.pranav.util.LogMessage;

@SpringBootApplication
public class RamseyFoodApplication {

	/**
	 * @param args
	 * @author pranavkumarb
	 */
	public static void main(String[] args) {
		SpringApplication.run(RamseyFoodApplication.class, args);
		
		RamseyFoodController ramseyFoodController = new RamseyFoodController();
		try {
			ramseyFoodController.calculateSatisfactionAmount("files/data.txt");
		} catch (RamseyFoodException e) {
			LogMessage.error(e.getMessage());
		}
	}
	
}
