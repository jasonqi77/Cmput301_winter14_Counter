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
	 * Set the name of a counter
	 * @param name -- the name of counter
	 * @param index -- the position of the counter in collection
	 */
	public void setName(String name, int index)
	{
		counters.get(index).setName(name);
	}
	
	/**
	 * Set the count of a counter
	 * @param count -- the count needs to be set
	 * @param index -- the position of the counter in collection
	 */
	public void setCount(int count, int index)
	{
		counters.get(index).setCount(count);
	}
	
	/**
	 * Add a new current date to the counter 
	 * @param index -- the position of the counter in collection
	 */
	public void addDate(int index)
	{
		counters.get(index).addDate();
	}
	
	/**
	 * Clean all dates in a counter
	 * @param index -- the position of the counter in collection
	 */
	public void resetDate(int index)
	{
		counters.get(index).resetDate();
	}
	
	/**
	 * Delete a counter from collection 
	 * @param index -- the position of the counter in collection
	 */
	public void delete(int index)
	{
		counters.remove(index);
	}
	
	
	
	
	
	
}
