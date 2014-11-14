package com.example.yahoosuperstar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;

public class Database extends SQLiteOpenHelper {
	

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "Applications";
 
    // Contacts table name
   // private static final String TABLE_APPLICANTS = "Application_Details";
    

	public Database(Context context, String name, CursorFactory factory,int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		  String CREATE_APPLICANT_TABLE = "CREATE TABLE TABLE_APPLICANTS ( " + "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "Name TEXT, " + "Email TEXT, " + "Credit TEXT, )";
		    db.execSQL(CREATE_APPLICANT_TABLE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

	
}
