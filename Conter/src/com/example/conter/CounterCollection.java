package com.example.conter;

import java.util.ArrayList;

/**
 * 
 * @author bqi
 *
 */
public class CounterCollection
{
	private ArrayList<Counter> counters;
	
	/**
	 * Constructor of CounterCollection 
	 */
	public CounterCollection()
	{
		this.counters = new ArrayList<Counter>();
		
	}
	
	/**
	 * Get all existing counters
	 * @return
	 * a list of existing counters
	 */
	public ArrayList<Counter> getCounters()
	{
		return counters;
	}

	/**
	 * add a new counter to the collection
	 * @param cd -- the new counter
	 */
	public void add(Counter cd)
	{
		counters.add(cd);
	}
	
	/**
	 * 
	 * @param name
	 * @param index
	 */
	public void setName(String name, int index)
	{
		counters.get(index).setName(name);
	}
	
	public void setCount(int count, int index)
	{
		counters.get(index).setCount(count);
	}
	
	public void addDate(int index)
	{
		counters.get(index).addDate();
	}
	
	public void resetDate(int index)
	{
		counters.get(index).resetDate();
	}
	
	public void delete(int index)
	{
		counters.remove(index);
	}
	
	
	
	
	
	
}
