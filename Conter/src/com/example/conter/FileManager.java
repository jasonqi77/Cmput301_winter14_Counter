package com.example.conter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.content.Context;

import com.google.gson.Gson;

/**
 * @author  bqi
 */
public class FileManager
{

	private static final String FILENAME = "counter3.sav";
	/**
	 * @uml.property  name="counter"
	 * @uml.associationEnd  
	 */
	private CounterCollection counter;
	private Gson gson = new Gson();
	private Context context;
	
	/**
	 * Constructor of FileManager
	 * @param context -- the context of the calling activity
	 */
	public FileManager(Context context)
	{
		this.context = context;
	}
	
	/**
	 * Load the counter collection from the file
	 * @return
	 * The counter collection
	 */
	public CounterCollection loadFromFile() {
        //counters = new ArrayList<CounterDetail>();
		counter = new CounterCollection();
        //formattedText = new ArrayList<String>();
        try {
                FileInputStream fis = context.openFileInput(FILENAME);
                BufferedReader in = new BufferedReader(new InputStreamReader(fis));
                String line = in.readLine();
                while (line != null) {
                	counter = gson.fromJson(line, CounterCollection.class);
                        //CounterDetail json = gson.fromJson(line, CounterDetail.class);
                        //counters.add(json);
                        //formattedText.add(tweetView.formatTweet(json));
                        line = in.readLine();
                }

        } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return counter;
	}	
	
	/**
	 * Save the counter collection to the file
	 * @param counters -- counter collection
	 */
	public void saveInFile(CounterCollection counters) {
		try {
			FileOutputStream fos = context.openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			String json = gson.toJson(counters);
			//fos.write(new String(date.toString() + " | " + text)
				//	.getBytes());
			out.write(json+ "\n");
			out.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
