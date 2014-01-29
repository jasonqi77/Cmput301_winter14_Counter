package com.example.conter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/**
 * @author  bqi
 */
public class CreateActivity extends Activity
{
	private EditText input;
	private Button submitButton;
	private Button cancel;
	/**
	 * @uml.property  name="counter"
	 * @uml.associationEnd  
	 */
	private CounterCollection counter;
	/**
	 * @uml.property  name="fm"
	 * @uml.associationEnd  
	 */
	private FileManager fm = new FileManager(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create);
		
		 input = (EditText) findViewById(R.id.input);
		 
		 submitButton = (Button) findViewById(R.id.submit);
		    submitButton.setOnClickListener(new OnClickListener() {
		        @Override
		        public void onClick(View arg0) {
		            Intent intent = new Intent(CreateActivity.this,
		                    CounterActivity.class);
		            
		            String name = input.getText().toString();;
		            if (name.equals(""))
		            {
		            	Toast.makeText(CreateActivity.this,
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
		            	if (isFound==true)
		            	{
		            		Toast.makeText(CreateActivity.this,
			                        "Name Exists !!!", Toast.LENGTH_SHORT)
			                        .show();
		            	}
		            	else
		            	{
		            		Counter counterDetail = new Counter(name);
		            		counter.add(counterDetail);
		            		fm.saveInFile(counter);
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
		            Intent intent = new Intent(CreateActivity.this,
		                    MainActivity.class);
		            
		            startActivity(intent);
		        }
		    });
	}
	
	/**
	 * Disable the back key
	 */
	@Override
	public void onBackPressed() {
		Toast.makeText(CreateActivity.this,
                "Back Key is Disabled!!!", Toast.LENGTH_SHORT)
                .show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create, menu);
		return true;
	}

}
