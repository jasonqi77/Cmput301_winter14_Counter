package com.example.conter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
/**
 * @author  bqi
 */
public class SummaryActivity extends Activity
{
	/**
	 * @uml.property  name="counter"
	 * @uml.associationEnd  
	 */
	private ArrayList<String> summary;
	private String name;
	private ListView detail;
	private ArrayAdapter<String> adapter;
	private SummaryHandler sh;
	/**
	 * @uml.property  name="testDate"
	 * @uml.associationEnd  
	 */
	
	@Override
	protected void onCreate(Bundle savedInstanceState)	
	{
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_summary);
	
		Intent intent = getIntent();
		name = intent.getStringExtra("counterName");
		detail = (ListView) findViewById(R.id.detail);
		sh = new SummaryHandler(this, name);
		summary = sh.getSummary();
	
		adapter = new ArrayAdapter<String>(this, R.layout.list_item, summary);
		detail.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}
		
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();	
	}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.summary, menu);
		return true;
	}

}
