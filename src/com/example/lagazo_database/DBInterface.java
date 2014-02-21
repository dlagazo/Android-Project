package com.example.lagazo_database;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBInterface extends SQLiteOpenHelper {
	private static final String DBName = "Logbook";
	private static final String TableName = "Entries";
	private static final int DBVersion = 1;
	
	private static final String key = "key";
	private static final String id = "id";
	private static final String name = "name";
	private static final String dept = "dept";
	private static final String stamp = "stamp";
	

	public DBInterface(Context context)
	{
		super(context, DBName, null, DBVersion);
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CREATE_LOGBOOK = "CREATE TABLE ENTRIES(key integer primary key" +
				", id integer, name string, dept string, stamp timestamp);";
		db.execSQL(CREATE_LOGBOOK);
	}
	
	public void addEntry(Entry entry)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(id, entry.getID());
		values.put(name, entry.getName());
		values.put(dept, entry.getDept());
		values.put(stamp, entry.getStamp().toString());
		db.insert(TableName, null, values);
		db.close();
	}
	
	public List<Entry> getAllEntries()
	{
		List<Entry> temp = new ArrayList<Entry>();
		String getAll = "SELECT * FROM ENTRIES";
		
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(getAll, null);
		if(cursor.moveToFirst())
		{
			do{
				Entry entry = new Entry(Integer.parseInt(cursor.getString(1)),
						cursor.getString(2), cursor.getString(3),
						new java.util.Date(cursor.getString(4)));
				temp.add(entry);
			} while(cursor.moveToNext());
				
		}
		return temp;
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
}
