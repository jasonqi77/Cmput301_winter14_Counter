package com.example.conter;

import java.util.Date;

/**
 * 
 * @author bqi
 *
 */
public class CountOccurredDate extends Date
{

	public CountOccurredDate()
	{
		super();

		// TODO Auto-generated constructor stub
	}

	public CountOccurredDate(long milliseconds)
	{

		super(milliseconds);
		// TODO Auto-generated constructor stub
	}
	

	public CountOccurredDate(int year, int month, int date, int hrs, int min)
	{
		super(year,month,date,hrs,min);
	}
	
	public CountOccurredDate(int year, int month, int date)
	{
		super(year,month,date);
	}
	
	public CountOccurredDate(int year, int month, int date, int hrs, int min, int sec)
	{
		super(year,month,date,hrs,min,sec);
	}
	
	public CountOccurredDate(String s)
	{
		super(s);
	}
}
