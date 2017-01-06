package com.pranav.module.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pranav.exception.RamseyFoodException;
import com.pranav.util.LogMessage;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RamseyFoodControllerTests {
	
	@Test
	public void testCalculateSatisfactionAmount() {
		RamseyFoodController ramseyFoodController = new RamseyFoodController();
		
		try {
			ramseyFoodController.calculateSatisfactionAmount("files/data.txt");
		} catch (RamseyFoodException e) {
			LogMessage.error("testCalculateSatisfactionAmount - " + e.getMessage());
		}
	}
	
	@Test
	public void testFileNotFound() {
		RamseyFoodController ramseyFoodController = new RamseyFoodController();
		
		try {
			ramseyFoodController.calculateSatisfactionAmount("files/data1.txt");
		} catch (RamseyFoodException e) {
			LogMessage.error("testFileNotFound - " + e.getMessage());
		}
	}
	
	@Test
	public void testEmptyFile() {
		RamseyFoodController ramseyFoodController = new RamseyFoodController();
		
		try {
			ramseyFoodController.calculateSatisfactionAmount("files/emptyFile.txt");
		} catch (RamseyFoodException e) {
			LogMessage.error("testEmptyFile - " + e.getMessage());
		}
	}
	
	@Test
	public void testZeroTimeAllocated() {
		RamseyFoodController ramseyFoodController = new RamseyFoodController();
		
		try {
			ramseyFoodController.calculateSatisfactionAmount("files/zeroTimeAllocated.txt");
		} catch (RamseyFoodException e) {
			LogMessage.error("testZeroTimeAllocated - " + e.getMessage());
		}
	}
	
	@Test
	public void testZeroFoodCount() {
		RamseyFoodController ramseyFoodController = new RamseyFoodController();
		
		try {
			ramseyFoodController.calculateSatisfactionAmount("files/zeroFoodCount.txt");
		} catch (RamseyFoodException e) {
			LogMessage.error("testZeroFoodCount - " + e.getMessage());
		}
	}
	
	@Test
	public void testMismatchWithRecordAndFoodCount() {
		RamseyFoodController ramseyFoodController = new RamseyFoodController();
		
		try {
			ramseyFoodController.calculateSatisfactionAmount("files/mismatchWithRecordAndFoodCount.txt");
		} catch (RamseyFoodException e) {
			LogMessage.error("testMismatchWithRecordAndFoodCount - " + e.getMessage());
		}
	}
	
	@Test
	public void testMoreThanTwoValuesInRecord() {
		RamseyFoodController ramseyFoodController = new RamseyFoodController();
		
		try {
			ramseyFoodController.calculateSatisfactionAmount("files/moreThanTwoValuesInRecord.txt");
		} catch (RamseyFoodException e) {
			LogMessage.error("testMoreThanTwoValuesInRecord - " + e.getMessage());
		}
	}
	
	@Test
	public void testLessThanOneValueInRecord() {
		RamseyFoodController ramseyFoodController = new RamseyFoodController();
		
		try {
			ramseyFoodController.calculateSatisfactionAmount("files/lessThanOneValueInRecord.txt");
		} catch (RamseyFoodException e) {
			LogMessage.error("testLessThanOneValueInRecord - " + e.getMessage());
		}
	}
	
	@Test
	public void testNotAnIntegerValue() {
		RamseyFoodController ramseyFoodController = new RamseyFoodController();
		
		try {
			ramseyFoodController.calculateSatisfactionAmount("files/notAnIntegerValue.txt");
		} catch (RamseyFoodException e) {
			LogMessage.error("testNotAnIntegerValue - " + e.getMessage());
		}
	}

}
