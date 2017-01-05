package com.pranav.module.bo;

/**
 * This class will be used to store data which is read from text file.<br>
 * <code>satisfactionAmount</code> is satisfaction value.<br>
 * <code>timeTaken</code> is time taken for eating a particular food.<br>
 * <code>satisfactionFactor</code> is calculated as <code>satisfactionAmount</code> divided by <code>timeTaken</code>
 * @author pranavkumarb
 */
public class FoodInfo implements Comparable<FoodInfo>{

	
	private int satisfactionAmount;
	
	private int timeTaken;
	
	/**
	 * <code>satisfactionFactor</code> is calculated as <code>satisfactionAmount</code> divided by <code>timeTaken</code>
	 */
	private float satisfactionFactor;

	public int getSatisfactionAmount() {
		return satisfactionAmount;
	}

	public void setSatisfactionAmount(int satisfactionAmount) {
		this.satisfactionAmount = satisfactionAmount;
	}

	public int getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(int timeTaken) {
		this.timeTaken = timeTaken;
	}

	public float getSatisfactionFactor() {
		return satisfactionFactor;
	}

	public void setSatisfactionFactor(float satisfactionFactor) {
		this.satisfactionFactor = satisfactionFactor;
	}

	@Override
	public int compareTo(FoodInfo foodInfo) {
		return Float.compare(this.satisfactionFactor, foodInfo.getSatisfactionFactor());
	}

	
}
