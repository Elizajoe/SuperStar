package com.example.yahoosuperstar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.yahoosuperstar.util.SystemUiHider;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class MovieList extends Activity {
	/**
	 * Whether or not the system UI should be auto-hidden after
	 * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
	 */
	private static final boolean AUTO_HIDE = true;

	/**
	 * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
	 * user interaction before hiding the system UI.
	 */
	private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

	/**
	 * If set, will toggle the system UI visibility upon interaction. Otherwise,
	 * will show the system UI visibility upon interaction.
	 */
	private static final boolean TOGGLE_ON_CLICK = true;

	/**
	 * The flags to pass to {@link SystemUiHider#getInstance}.
	 */
	private static final int HIDER_FLAGS = SystemUiHider.FLAG_HIDE_NAVIGATION;

	/**
	 * The instance of the {@link SystemUiHider} for this activity.
	 */
	private SystemUiHider mSystemUiHider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_movie_list);

		final View controlsView = findViewById(R.id.fullscreen_content_controls);
		final View contentView = findViewById(R.id.fullscreen_content);

		
		 String[] Movies_list = new String[] { "SuperMan Returns","Batman Begins","The Hobbit","Maleficient"};
		 
		 ArrayAdapter<String> MovieListArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Movies_list);
		 ListView MovieListItems =(ListView)findViewById(R.id.listView1);
		 MovieListItems.setAdapter(MovieListArrayAdapter);
		 
		 MovieListItems.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View v,int position, long id) {
					
					//configName = path+"/"+configList[position];
					//System.out.println(" hey heyy Selecting config name at :" + configName);
					
					
					//Intent selectionIntent = new Intent(v.getContext(),Trees.class);
					Intent rolesIntent = new Intent(v.getContext(),Roles.class);
					//selectionIntent.setData(Uri.parse(configName));
					startActivity(rolesIntent);
					
					System.out.println("this is my selection now what??");
					
					
					
					
				}
			});
			
		 
		 
		 

	}

	Handler mHideHandler = new Handler();
	Runnable mHideRunnable = new Runnable() {
		@Override
		public void run() {
			mSystemUiHider.hide();
		}
	};

}
