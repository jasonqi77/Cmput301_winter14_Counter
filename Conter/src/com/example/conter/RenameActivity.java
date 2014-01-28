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
 * 
 * @author bqi
 *
 */
public class RenameActivity extends Activity
{
	private String cname, oldName;
	private int num;
	private EditText name;
	private Button submit;
	private CounterCollection counter;
	private int index;
	private FileManager fm = new FileManager(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rename);
		
		name = (EditText) findViewById(R.id.input);
		submit = (Button) findViewById(R.id.submit);
		
		Intent intent = getIntent();
		oldName = intent.getStringExtra("counterName");
		counter = fm.loadFromFile();
		
	    submit.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View arg0) {
	            Intent intent = new Intent(RenameActivity.this,
	                    CounterActivity.class);
	            
	            cname = name.getText().toString();
	            if (cname.equals(""))
	            {
	            	Toast.makeText(RenameActivity.this,
	                        "Name cannot be null!!!", Toast.LENGTH_SHORT)
	                        .show();
	            }
	            else
	            {
	            	boolean isFound = false;
	            	for (int i=0; i<counter.getCounters().size(); i++)
	        		{
	        			if (counter.getCounters().get(i).getName().equals(oldName))
	        			{
	        				index = i;
	        			}
	        			if (counter.getCounters().get(i).getName().equals(cname))
	        			{
	    					isFound = true;
	        			}
	        		}
	            	if (isFound == true)
	            	{
	            		Toast.makeText(RenameActivity.this,
		                        "Name Exists !!!", Toast.LENGTH_SHORT)
		                        .show();
	            	}
	            	else
	            	{
	            		counter.setName(cname, index);
	            		fm.saveInFile(counter);
	            		intent.putExtra("counterName", cname);
			            startActivity(intent);
	            	}
	            	
	            }
	            
	        }
	    });
				
	}
	
	/**
	 * Disable the back key
	 */
	@Override
	public void onBackPressed() {
		Toast.makeText(RenameActivity.this,
                "Back Key is Disabled!!!", Toast.LENGTH_SHORT)
                .show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rename, menu);
		return true;
	}

}
