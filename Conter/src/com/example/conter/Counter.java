package com.example.conter;

import java.util.ArrayList;

/**
 * 
 * @author bqi
 *
 */
public class Counter
{
	private int count;
	private String name="";
	private ArrayList<CountOccurredDate> date;
	private CountOccurredDate newDate;
	
	/**
	 * Constructor of CounterDetail, initialize all variables.
	 * @param name -- the counter's name
	 */
	public Counter(String name)
	{
		this.name=name;
		this.count=0;
		this.date = new ArrayList<CountOccurredDate>();
		this.newDate= new CountOccurredDate();
	}
	
	/**
	 * get counter's current count
	 * @return 
	 * the counter's current count
	 */
	public int getCount()
	{
	
		return count;
	}
	
	/**
	 * set the counter's count
	 * @param count -- the number of count
	 */
	public void setCount(int count)
	{
	
		this.count = count;
	}
	
	/**
	 * get the counter's name
	 * @return
	 * the counter's name
	 */
	public String getName()
	{
	
		return name;
	}
	
	/**
	 * set thecounter's name
	 * @param name -- counter's name
	 */
	public void setName(String name)
	{
	
		this.name = name;
	}
	
	/**
	 * record the current date when each time count increasing
	 */
	public void addDate()
	{	
		newDate = new CountOccurredDate(System.currentTimeMillis());
		date.add(newDate);
	}
	
	/**
	 * get the time of each count occurred
	 * @return
	 * the list of times that all counts occured
	 */
	public ArrayList<CountOccurredDate> getDate()
	{
		return date;
	}
	
	/**
	 * clean the time of each count occurred
	 */
	public void resetDate()
	{
		date.clear();
	}
	

	/**
	 * override the toString method for the ArrayAdapter.
	 */
	@Override
	public String toString()
	{
		return name + "\t\t\t\t\tCount:" + count;
	}

}
