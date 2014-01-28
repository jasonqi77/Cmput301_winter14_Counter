package com.example.conter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
/**
 * 
 * @author bqi
 *
 */
public class CounterActivity extends Activity
{
	private TextView name, count;
	private Button add, reset, rename, detail, cancel;
	private int num=0, index;
	private String cname;
	private CounterCollection counter;
	private FileManager fm = new FileManager(this);

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_counter);
		
		name = (TextView) findViewById(R.id.counterName);
		count = (TextView) findViewById(R.id.count);
				
		Intent intent = getIntent();
		cname = intent.getStringExtra("counterName");
		//num = intent.getIntExtra("count", num);
		num=0;
		
		counter = fm.loadFromFile();
		for (int i=0; i<counter.getCounters().size(); i++)
		{
			if (counter.getCounters().get(i).getName().equals(cname))
			{
				index = i;
				num = counter.getCounters().get(i).getCount();
			}
		}
		
		count.setText("" + num);
		name.setText(cname);
		
		add = (Button) findViewById(R.id.add);
	    add.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View arg0) {
	        	num++;
	        	counter.setCount(num, index);
	        	counter.addDate(index);
	        	fm.saveInFile(counter);
	        	count.setText("" + num);
	        }
	    });
	    
	    reset = (Button) findViewById(R.id.reset);
	    reset.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View arg0) {
	        	num=0;
	        	counter.setCount(num, index);
	        	counter.resetDate(index);
	        	fm.saveInFile(counter);
	        	count.setText("" + num);
	        	
	        }
	    });
		
	    rename = (Button) findViewById(R.id.rename);
	    rename.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View arg0) {
	            Intent intent = new Intent(CounterActivity.this,
	                    RenameActivity.class);
	            	            
	            intent.putExtra("counterName", cname);
	            //intent.putExtra("count", num);
	            
	            startActivity(intent);
	        }
	    });
	    
	    detail = (Button) findViewById(R.id.detail);
	    detail.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View arg0) {
	            Intent intent = new Intent(CounterActivity.this,
	                    SummaryActivity.class);
	            
	            intent.putExtra("counterName", cname);
	            startActivity(intent);
	        }
	    });
	    
	    cancel = (Button) findViewById(R.id.back);
	    cancel.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View arg0) {
	            Intent intent = new Intent(CounterActivity.this,
	                    MainActivity.class);
	            
	            startActivity(intent);
	        }
	    });
	    
	    
	}
	
	@Override
	public void onBackPressed() {
		Toast.makeText(CounterActivity.this,
                "Back Key is Disabled!!!", Toast.LENGTH_SHORT)
                .show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.counter, menu);
		return true;
	}

	

}
