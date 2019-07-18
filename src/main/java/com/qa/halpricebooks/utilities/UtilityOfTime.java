package com.qa.halpricebooks.utilities;

//Hiding the details of Thread.sleep using this utility

public class UtilityOfTime {
	
	public static void short_Time_Wait()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void Medium_Time_Wait()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void long_Time_Wait()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
