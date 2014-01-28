package com.example.conter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/**
 * 
 * @author bqi
 *
 */
public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button createButton = (Button) findViewById(R.id.Create);
	    createButton.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View arg0) {
	            Intent intent = new Intent(MainActivity.this,
	                    CreateActivity.class);
	            startActivity(intent);
	        }
	    });
	    
	    Button loadButton = (Button) findViewById(R.id.Load);
	    loadButton.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View arg0) {
	            Intent intent = new Intent(MainActivity.this,
	                    LoadActivity.class);
	            startActivity(intent);
	        }
	    });
	    
	    Button deleteButton = (Button) findViewById(R.id.Delete);
	    deleteButton.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View arg0) {
	            Intent intent = new Intent(MainActivity.this,
	                    DeleteActivity.class);
	            startActivity(intent);
	        }
	    });
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

}
