package com.example.conter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
/**
 * @author  bqi
 */
public class SummaryActivity extends Activity
{
	/**
	 * @uml.property  name="counter"
	 * @uml.associationEnd  
	 */
	private CounterCollection counter;
	private ArrayList<Counter> counters;
	private ArrayList<Date> date;
	private ArrayList<String> hour;
	private ArrayList<String> week;
	private ArrayList<String> month;
	private ArrayList<String> day;
	private ArrayList<String> summary;
	private String name;
	private int index;
	private int curr_hour;
	private int curr_week;
	private int curr_month;
	private int curr_day;
	private int curr_year;
	private static int count_hour;
	private static int count_week;
	private static int count_month;
	private static int count_day;
	private String[] mon = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};
	private ListView detail;
	private ArrayAdapter<String> adapter;
	private int diff;
	/**
	 * @uml.property  name="testDate"
	 * @uml.associationEnd  
	 */
	private Date testDate;
	/**
	 * @uml.property  name="fm"
	 * @uml.associationEnd  
	 */
	private FileManager fm = new FileManager(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_summary);
		
		counter = fm.loadFromFile();
		counters = counter.getCounters();
		Intent intent = getIntent();
		name = intent.getStringExtra("counterName");
		detail = (ListView) findViewById(R.id.detail);

		hour = new ArrayList<String>();
		week = new ArrayList<String>();
		month = new ArrayList<String>();
		day = new ArrayList<String>();
		curr_year=0;
		curr_hour=0;
		curr_week=0;
		curr_day=0;
		curr_month=0;
		count_day=0;
		count_hour=0;
		count_week=0;
		count_month=0;
		diff =0;
		
		summary = new ArrayList<String>();
		
		adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, summary);
		detail.setAdapter(adapter);
		
		for (int i=0; i<counters.size(); i++)
		{
			if (counters.get(i).getName().equals(name))
			{
				index = i;
			}
		}
		date = counters.get(index).getDate();
		
		Collections.sort(date, new DateComparator());
		
		if (date.size()>=1)
		{
			curr_month = date.get(0).getMonth();
			curr_day = date.get(0).getDate();
			curr_week = date.get(0).getDate();
			curr_hour = date.get(0).getHours();
			curr_year = date.get(0).getYear();
			count_hour++;
			count_week++;
			count_month++;
			count_day++;
			testDate = date.get(0);
			testDate = new Date(testDate.getYear(), testDate.getMonth(), testDate.getDate());
			diff = 6 - testDate.getDay();
			testDate.setDate(testDate.getDate()+diff);
		}
		
		// A for loop used to decides if the next press date is in the same year/month/week/day/hour
		for (int i=1; i<date.size(); i++)
		{
			if (date.get(i).getYear() == curr_year)
			{
				if (date.get(i).getMonth() == curr_month)
				{
					count_month++;
					
					if (date.get(i).getDate() == curr_day)
					{
						count_day++;
						count_week++;
						if (date.get(i).getHours() ==curr_hour)
						{
							count_hour++;
							
						}
						else 
						{
							if (curr_hour>=12)
							{
								hour.add(mon[curr_month] + " " + curr_day + " " + (curr_hour-12) + ":00PM -- " + count_hour);				
							}
								
							else
							{
								hour.add(mon[curr_month] + " " + curr_day + " " + curr_hour + ":00AM -- " + count_hour);
							}
							resetHour();
							curr_hour = date.get(i).getHours();
							count_hour++;
						}
					}
					else
					{
						if (testDate.compareTo(new Date(date.get(i).getYear(), date.get(i).getMonth(), date.get(i).getDate())) >=0 )
							
						{
							count_week++;
						}
						else
						{
							week.add("Week of " + mon[curr_month] + " " + curr_week + " -- " + count_week);
							resetWeek();
							testDate = date.get(i);
							testDate = new Date(testDate.getYear(), testDate.getMonth(), testDate.getDate());
							diff = 6 - testDate.getDay();
							testDate.setDate(testDate.getDate()+diff);
							curr_week = date.get(i).getDate();
							count_week++;
						}
						
						if (curr_hour>=12)
						{
							hour.add(mon[curr_month] + " " + curr_day + " " + (curr_hour-12) + ":00PM -- " + count_hour);				
						}
							
						else
						{
							hour.add(mon[curr_month] + " " + curr_day + " " + curr_hour + ":00AM -- " + count_hour);
						}
						day.add(mon[curr_month] + " " + curr_day + " -- " + count_day);
						resetHour();
						resetDay();
						curr_day = date.get(i).getDate();
						curr_hour = date.get(i).getHours();
						count_day++;
						count_hour++;
					}
				}
				else
				{
					Toast.makeText(SummaryActivity.this,
	                        "" + curr_day, Toast.LENGTH_SHORT)
	                        .show();
					if (testDate.compareTo(new Date(date.get(i).getYear(), date.get(i).getMonth(), date.get(i).getDate())) >=0 )
					{
						count_week++;
					}
					else
					{
						week.add("Week of " + mon[curr_month] + " " + curr_week + " -- " + count_week);
						resetWeek();
						testDate = date.get(i);
						testDate = new Date(testDate.getYear(), testDate.getMonth(), testDate.getDate());
						diff = 6 - testDate.getDay();
						testDate.setDate(testDate.getDate()+diff);
						curr_week = date.get(i).getDate();
						count_week++;
					}
					if (curr_hour>=12)
					{
						hour.add(mon[curr_month] + " " + curr_day + " " + (curr_hour-12) + ":00PM -- " + count_hour);				
					}
						
					else
					{
						hour.add(mon[curr_month] + " " + curr_day + " " + curr_hour + ":00AM -- " + count_hour);
					}
					day.add(mon[curr_month] + " " + curr_day + " -- " + count_day);
					month.add("Month of " + mon[curr_month] + " -- " + count_month);
					resetDay();
					resetHour();
					resetMonth();

						curr_month = date.get(i).getMonth();
						curr_day = date.get(i).getDate();
						curr_hour = date.get(i).getHours();
						count_month++;
						count_day++;
						count_hour++;				
				}
			}
			else
			{
				if (testDate.compareTo(new Date(date.get(i).getYear(), date.get(i).getMonth(), date.get(i).getDate())) >=0 )
				{
					count_week++;
				}
				else
				{
					week.add("Week of " + mon[curr_month] + " " + curr_week + " -- " + count_week);
					resetWeek();
					testDate = date.get(i);
					testDate = new Date(testDate.getYear(), testDate.getMonth(), testDate.getDate());
					diff = 6 - testDate.getDay();
					testDate.setDate(testDate.getDate()+diff);
					curr_week = date.get(i).getDate();
					count_week++;
				}
				if (curr_hour>=12)
				{
					hour.add(mon[curr_month] + " " + curr_day + " " + (curr_hour-12) + ":00PM -- " + count_hour);				
				}
					
				else
				{
					hour.add(mon[curr_month] + " " + curr_day + " " + curr_hour + ":00AM -- " + count_hour);
				}
				day.add(mon[curr_month] + " " + curr_day + " -- " + count_day);
				month.add("Month of " + mon[curr_month] + " -- " + count_month);
				resetDay();
				resetHour();
				resetMonth();

					curr_month = date.get(i).getMonth();
					curr_day = date.get(i).getDate();
					curr_hour = date.get(i).getHours();
					curr_year = date.get(i).getYear();
					count_month++;
					count_day++;
					count_hour++;		
			} 
			
		}
		
		
		//searching finished 
		if (count_hour != 0)
		{
			if (curr_hour>=12)
			{
				hour.add(mon[curr_month] + " " + curr_day + " " + (curr_hour-12) + ":00PM -- " + count_hour);				
			}
				
			else
			{
				hour.add(mon[curr_month] + " " + curr_day + " " + curr_hour + ":00AM -- " + count_hour);
			}
		}
		if (count_week != 0)
		{
			week.add("Week of " + mon[curr_month] + " " + curr_day + " -- " + count_week);
		}
		if (count_day != 0)
		{
			day.add(mon[curr_month] + " " + curr_day + " -- " + count_day);
		}
		if (count_month != 0)
		{
			month.add("Month of " + mon[curr_month] + " -- " + count_month);
		}
		summary.add("Count Per Hour:");
		
		/////////////////////////////////////////////////
		for (int i = 0; i<hour.size(); i++)
		{
			summary.add("     " + hour.get(i));
		}
		summary.add("Count Per Week:");
		
		for (int i = 0; i<week.size(); i++)
		{
			summary.add("     " + week.get(i));
		}
		
		summary.add("Count Per Day:");
		for (int i = 0; i<day.size(); i++)
		{
			summary.add("     " + day.get(i));
		}
		adapter.notifyDataSetChanged();
		
		summary.add("Count Per Month:");
		
		for (int i = 0; i<month.size(); i++)
		{
			summary.add("     " + month.get(i));
		}
		
	}
	
	/**
	 * The comparator of Date
	 * Used to sort the pressed dates of a counter
	 */
	public static class DateComparator implements Comparator<Date> {
	      @Override
	      public int compare(Date s, Date t) {
	         return s.compareTo(t);
	      }
	  }
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		
	}
	
	/**
	 * reset the count for one day
	 */
	static void resetDay()
	{
		count_day=0;
	}
	
	/**
	 * reset the count of one hour
	 */
	static void resetHour()
	{
		count_hour=0;
	}
	
	/**
	 * reset the count of one week
	 */
	static void resetWeek()
	{
		count_week=0;
	}
	
	/**
	 * reset the count of one month
	 */
	static void resetMonth()
	{
		count_month=0;
	}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.summary, menu);
		return true;
	}

}
