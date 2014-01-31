package com.example.conter;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author  bqi
 */
public class CounterCollection
{
	/**
	 * @uml.property  name="counters"
	 */
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
	 * @return  a list of existing counters
	 * @uml.property  name="counters"
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

	/**
	 * @uml.property  name="counter"
	 * @uml.associationEnd  multiplicity="(0 -1)" aggregation="composite" inverse="counterCollection:com.example.conter.Counter"
	 */
	private Collection<Counter> counter;

	/**
	 * Getter of the property <tt>counter</tt>
	 * @return  Returns the counter.
	 * @uml.property  name="counter"
	 */
	public Collection<Counter> getCounter()
	{

		return counter;
	}

	/**
	 * Setter of the property <tt>counter</tt>
	 * @param counter  The counter to set.
	 * @uml.property  name="counter"
	 */
	public void setCounter(Collection<Counter> counter)
	{

		this.counter = counter;
	}
	
	
	
	
	
	
}
