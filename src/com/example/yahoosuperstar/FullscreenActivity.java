package com.example.yahoosuperstar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.yahoosuperstar.util.SystemUiHider;

public class FullscreenActivity extends Activity {
	
	private Button button;
	private Button find_movie_button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Remove title bar
	    this.requestWindowFeature(Window.FEATURE_NO_TITLE);

	    //Remove notification bar
	    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_fullscreen);

		// final View controlsView = findViewById(R.id.fullscreen_content_controls);
		final View contentView = findViewById(R.id.fullscreen_content);
		
		find_movie_button = (Button) findViewById(R.id.button2);
		find_movie_button.setOnClickListener( new OnClickListener() {
			
			public void onClick(View v) {
				try{
				Intent intent1 = new Intent(v.getContext(), MovieList.class);
				//Intent intent = new Intent(v.getContext(), MovieList.class);
				//intent.putExtra("JSONData", mBlogData.toString());
				startActivity(intent1);
				}catch(Exception e){
					System.out.println(e);
				}
				
			}
		});
	}
}
