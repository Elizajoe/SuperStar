package com.example.yahoosuperstar;

import java.io.FileNotFoundException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ApplyActivity extends Activity {

	ImageView imgFavorite;
	Boolean flagTakePicture = false;
	Boolean flagUploadPicture = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_apply);
		imgFavorite = (ImageView)findViewById(R.id.imageView1);

		Button takePicture = (Button)findViewById(R.id.buttonUpload);
		Button choose = (Button)findViewById(R.id.buttonChoose);

		imgFavorite.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				flagTakePicture = true;
				takePicture();
			}
		});

		takePicture.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				flagTakePicture = true;
				takePicture();
			}
		});

		choose.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				flagUploadPicture = true;
				choose();
			}
		});
	}
	public void takePicture(){
		Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(intent, 0);
	}
	public void choose(){
		Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
		photoPickerIntent.setType("image/*");
		startActivityForResult(photoPickerIntent, 1);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);

		// take
		if(flagTakePicture){
			if(data != null && data.getExtras() != null)
			{ 
				Bitmap bp = (Bitmap) data.getExtras().get("data");
				imgFavorite.setImageBitmap(bp);
			}
		}

		// choose existing
		else if(flagUploadPicture){
			switch(requestCode) { 
			case 1:
				if(resultCode == RESULT_OK){
					try {
						final Uri imageUri = data.getData();
						final InputStream imageStream = getContentResolver().openInputStream(imageUri);
						final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
						imgFavorite.setImageBitmap(selectedImage);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}

				}
			}
		}

		flagTakePicture = false;
		flagUploadPicture = false;
		
		
		EditText editText1 = (EditText) findViewById(R.id.editText1);
		String name = editText1.getText().toString();
		EditText editText2 = (EditText) findViewById(R.id.editText2);
		String email = editText2.getText().toString();
		EditText editText3 = (EditText) findViewById(R.id.editText3);
		String Name = editText3.getText().toString();
		EditText editText4 = (EditText) findViewById(R.id.editText4);
		String reditCard = editText4.getText().toString();
		EditText editText5 = (EditText) findViewById(R.id.editText5);
		String ExpDate = editText5.getText().toString();
		
		
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.apply1, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		//if (id == R.id.action_settings) {
		//return true;
		//}
		return super.onOptionsItemSelected(item);
	}
}
