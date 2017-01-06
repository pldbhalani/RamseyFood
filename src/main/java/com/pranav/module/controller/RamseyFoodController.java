package com.pranav.module.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.pranav.exception.RamseyFoodException;
import com.pranav.util.LogMessage;

public class RamseyFoodController {
	
	/**
	 * This method will calculate maximum satisfactory amount for the given data in file
	 * @param filePath
	 * @throws RamseyFoodException
	 * @author pranavkumarb
	 */
	public void calculateSatisfactionAmount(String filePath) throws RamseyFoodException{
		
		File file = getFile(filePath);	
		
		BufferedReader bufferedReader = null;
		FileReader fileReader = null;
		
		//this will contain the total time allocated to eat food
		int timeAlloted = 0;
		
		//this will contain the total no. of available food
		int foodCount = 0;
		
		int matrix[][] = null;
		
		try {

			bufferedReader = new BufferedReader(new FileReader(file));

			String currentLine = bufferedReader.readLine();
			
			//this will read timeAlloted and foodCount
			String[] recordInfo = splitValues(currentLine);
			timeAlloted = getIntegerVal(recordInfo[0]);
			foodCount = getIntegerVal(recordInfo[1]);
			if(timeAlloted <= 0){
				throw new RamseyFoodException("Time allocated should be greater than 0");
			}
			if(foodCount<= 0){
				throw new RamseyFoodException("Total food available should be greater than 0");
			}
			
			int satisfactoryValue[] = new int[foodCount];
	        int timeRequired[] = new int[foodCount];
	        
			matrix = new int [foodCount + 1][timeAlloted + 1];
	        
	        int count = 0;
	        //this will read all satisfaction amount and time taken for the same
			while ((currentLine = bufferedReader.readLine()) != null) {
				recordInfo = splitValues(currentLine);
				satisfactoryValue[count] = getIntegerVal(recordInfo[0]);
				timeRequired[count++] = getIntegerVal(recordInfo[1]);
			}
			if(count != foodCount){
				throw new RamseyFoodException("Total food records should " + foodCount + " but it is " + count);
			}
	        
	        for (int food=1; food <= foodCount; food++){
	            for (int time=1; time <= timeAlloted; time++){
	                //if the current food eating time is less than or equal to running time
	                if (timeRequired[food-1] <= time){
	                    //Given a time, check if the value of the current food + value of the food that we could afford with the remaining time
	                    //is greater than the value without the current food itself
	                    matrix[food][time] = Math.max(satisfactoryValue[food-1] + matrix[food-1][time-timeRequired[food-1]], matrix[food-1][time]);
	                }
	                else {
	                    //if the current food's value is more than the running time, just carry forward the value without the current food
	                	matrix[food][time] = matrix[food-1][time];
	                }
	            }
	        }
	        
	        LogMessage.log("******* Maximum Satisfaction Value is " + matrix[foodCount][timeAlloted] + "*******");
			
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
		
	}
	
	/**
	 * This method will split given string with space and checks validation for exact to values
	 * @param valueString
	 * @returnString[]
	 * @throws RamseyFoodException
	 * @author pranavkumarb
	 */
	private String[] splitValues(String valueString) throws RamseyFoodException {
		if(valueString == null){
			throw new RamseyFoodException("Record not found");
		}
		String[] recordInfoArray = valueString.split(" ");
		if(recordInfoArray != null && recordInfoArray.length == 1){
			throw new RamseyFoodException(valueString + " this record is having only one value");
		}
		if(recordInfoArray != null && recordInfoArray.length > 2){
			throw new RamseyFoodException(valueString + " this record is having more than two value");
		}
		return recordInfoArray;
	}

	/**
	 * This method will convert string value to integer value
	 * @param val
	 * @return int
	 * @throws RamseyFoodException
	 * @author pranavkumarb
	 */
	private int getIntegerVal(String val) throws RamseyFoodException{
		int result = 0;
		try{
			result = Integer.valueOf(val);
		}catch (NumberFormatException e) {
			throw new RamseyFoodException(val + " is not an integer please give integer value only");
		}
		return result;
	}
	
	/**
	 * This method will read file from mention path
	 * @param fileName
	 * @return File
	 * @throws RamseyFoodException
	 * @author pranavkumarb
	 */
	private File getFile(String fileName) throws RamseyFoodException {

		ClassLoader classLoader = getClass().getClassLoader();
		File file = null;
		try {
			file = new File(classLoader.getResource(fileName).getFile());
		} catch (Exception e) {
			throw new RamseyFoodException("Mentioned File path not available");
		}
		return file;

	}

}
