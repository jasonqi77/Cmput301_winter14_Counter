package com.example.conter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
/**
 * @author  bqi
 */
public class LoadActivity extends Activity
{
	private Button submitButton;
	private Button cancel;
	private EditText input;
	/**
	 * @uml.property  name="counter"
	 * @uml.associationEnd  
	 */
	private CounterCollection counter;
	private ListView counterName;
	private ArrayAdapter<Counter> adapter;
	private ArrayList<Counter> counters;
	/**
	 * @uml.property  name="fm"
	 * @uml.associationEnd  
	 */
	private FileManager fm = new FileManager(this);
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_load);
		
		counterName = (ListView) findViewById(R.id.counterName);
		input = (EditText) findViewById(R.id.input);
		 
		submitButton = (Button) findViewById(R.id.submit);
		submitButton.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View arg0) {
	            Intent intent = new Intent(LoadActivity.this,
	                    CounterActivity.class);
	            
	            String name = input.getText().toString();
	            if (name.equals(""))
	            {
	            	Toast.makeText(LoadActivity.this,
	                        "Name cannot be null !!!", Toast.LENGTH_SHORT)
	                        .show();
	            }
	            else
	            {
	            	counter = fm.loadFromFile();
	            	Boolean isFound = false;
	            	for (int i=0; i<counter.getCounters().size(); i++)
	            	{
	            		if (counter.getCounters().get(i).getName().equals(name))
	            			isFound = true;
	            	}
	            	if (isFound==false)
	            	{
	            		Toast.makeText(LoadActivity.this,
		                        "Name Doesn't Exists !!!", Toast.LENGTH_SHORT)
		                        .show();
	            	}
	            	else
	            	{
		            	intent.putExtra("counterName", name);		            
			            startActivity(intent);
	            	}		            	
	            }
	            		            
	        }
	    });
		
		cancel = (Button) findViewById(R.id.back);
	    cancel.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View arg0) {
	            Intent intent = new Intent(LoadActivity.this,
	                    MainActivity.class);
	            
	            startActivity(intent);
	        }
	    });
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		counter = fm.loadFromFile();
		counters = counter.getCounters();
		Collections.sort(counters, new CountComparator());
		adapter = new ArrayAdapter<Counter>(this,
				R.layout.list_item, counters);
		counterName.setAdapter(adapter);
	}
	
	
	/**
	 * 
	 * The comparator of counters. U
	 * Used to sort the counter based on the number of count.
	 */
	public static class CountComparator implements Comparator<Counter> {
	      @Override
	      public int compare(Counter s, Counter t) {
	         return t.getCount()-s.getCount();
	      }
	  }

	/**
	 * Disable the back key
	 */
	@Override
	public void onBackPressed() {
		Toast.makeText(LoadActivity.this,
                "Back Key is Disabled!!!", Toast.LENGTH_SHORT)
                .show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.load, menu);
		return true;
	}

}
