package com.pranav;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pranav.module.bo.FoodInfo;

@SpringBootApplication
public class RamseyFoodApplication {

	/**
	 * @param args
	 * @author pranavkumarb
	 */
	public static void main(String[] args) {
		SpringApplication.run(RamseyFoodApplication.class, args);
		
		String filePath = "E:\\data.txt";
		BufferedReader bufferedReader = null;
		FileReader fileReader = null;

		//This list will used to store the data which is read from text file
		List<FoodInfo> foodInfos = new ArrayList<FoodInfo>();
		
		//this will contain the total time allocated to eat food
		int timeAlloted = 0;
		
		//this will contain the total no. of available food
		int foodCount = 0;
		try {

			fileReader = new FileReader(filePath);
			bufferedReader = new BufferedReader(fileReader);
			bufferedReader = new BufferedReader(new FileReader(filePath));

			String currentLine = bufferedReader.readLine();
			
			//this will read timeAlloted and foodCount
			String[] recordInfo = currentLine.split(" ");
			timeAlloted = Integer.valueOf(recordInfo[0]);
			foodCount = Integer.valueOf(recordInfo[1]); 
			
			
			//this will read all satisfaction amount and time taken for the same
			//and it will calculate satisfaction factor for the same
			while ((currentLine = bufferedReader.readLine()) != null) {
				recordInfo = currentLine.split(" ");
				FoodInfo foodInfo = new FoodInfo();
				foodInfo.setSatisfactionAmount(Integer.valueOf(recordInfo[0]));
				foodInfo.setTimeTaken(Integer.valueOf(recordInfo[1]));
				foodInfo.setSatisfactionFactor(Float.valueOf(recordInfo[0])/Float.valueOf(recordInfo[1]));
				foodInfos.add(foodInfo);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null)
					bufferedReader.close();
				if (fileReader != null)
					fileReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		//this will sort FoodInfo based on satisfaction factor in ascending order
		Collections.sort(foodInfos);
		
		//this will reverse the order to descending order
		Collections.reverse(foodInfos);
		
		//this will used to store time will be used to eat food
		int resultTime = 0;
		
		//this will used to store  resultant maximum satisfaction value
		int resultSatisfactionValue = 0;
		
		int resultFoodCount = 0;
		//this will calculate 
		for (FoodInfo foodInfo : foodInfos) {
			if(timeAlloted >= (resultTime + foodInfo.getTimeTaken())){
				resultFoodCount++;
				resultTime += foodInfo.getTimeTaken();
				resultSatisfactionValue += foodInfo.getSatisfactionAmount();
			}
		}
		
		System.out.println("Time used is " + resultTime + ",  Maximum Satisfaction Value is " + resultSatisfactionValue + ", total food is " + foodCount + ", total eaten food is " + resultFoodCount);
	}
}
