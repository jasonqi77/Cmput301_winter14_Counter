package com.example.conter;

import java.util.ArrayList;

/**
 * @author  bqi
 */
public class Counter
{
	/**
	 * @uml.property  name="count"
	 */
	private int count;
	/**
	 * @uml.property  name="name"
	 */
	private String name="";
	/**
	 * @uml.property  name="date"
	 */
	private ArrayList<CountOccurredDate> date;
	/**
	 * @uml.property  name="newDate"
	 * @uml.associationEnd  
	 */
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
	 * @return    the counter's current count
	 * @uml.property  name="count"
	 */
	public int getCount()
	{
	
		return count;
	}
	
	/**
	 * set the counter's count
	 * @param count  -- the number of count
	 * @uml.property  name="count"
	 */
	public void setCount(int count)
	{
	
		this.count = count;
	}
	
	/**
	 * get the counter's name
	 * @return  the counter's name
	 * @uml.property  name="name"
	 */
	public String getName()
	{
	
		return name;
	}
	
	/**
	 * set thecounter's name
	 * @param name  -- counter's name
	 * @uml.property  name="name"
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
	 * @return  the list of times that all counts occured
	 * @uml.property  name="date"
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
