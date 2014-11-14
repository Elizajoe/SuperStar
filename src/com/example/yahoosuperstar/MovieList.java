package com.example.yahoosuperstar;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.yahoosuperstar.util.SystemUiHider;

public class MovieList extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Remove title bar
	    this.requestWindowFeature(Window.FEATURE_NO_TITLE);

	    //Remove notification bar
	    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_movie_list);

		// final View controlsView = findViewById(R.id.fullscreen_content_controls);
		final View contentView = findViewById(R.id.fullscreen_content);

		 String[] Movies_list = new String[] { "Superman Returns (Audition)","Joe's Halloween Party","Y! New Year Party","Food Party @Jenny's"};
         setListAdapter(new ArrayAdapter < String > (this,
                 android.R.layout.simple_list_item_1, Movies_list));
         getListView().setTextFilterEnabled(true);
	}

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        
        if(position == 2){
			Intent rolesIntent = new Intent(v.getContext(), RoleDetailYEPActivity.class);
			startActivity(rolesIntent);
        } else {
			Intent rolesIntent = new Intent(v.getContext(), RoleDetailActivity.class);
			startActivity(rolesIntent);
        }
    }
}
