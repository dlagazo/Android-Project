package com.example.lagazo_database;

import java.sql.Date;
import java.util.Calendar;

public class Entry {

	/**
	 * @param args
	 */
	public int id;
	public String Name;
	public String Dept;
	public java.util.Date Stamp;
	
	public Entry(int _id, String _name, String _dept, java.util.Date _stamp)
	{
		id = _id;
		Name = _name;
		Dept = _dept;
		Stamp = _stamp;
	}
	
	public Entry(int _id, String _name, String _dept)
	{
		id = _id;
		Name = _name;
		Dept = _dept;
		Stamp = Calendar.getInstance().getTime();
	}
	
	public int getID()
	{
		return id;
	}
	
	public void setID(int _id)
	{
		id = _id;
	}
	
	public String getName()
	{
		return Name;
	}
	
	public void setName(String _name)
	{
		Name = _name;
	}
	
	public String getDept()
	{
		return Dept;
	}
	
	public void setDept(String _dept)
	{
		Dept = _dept;
	}
	
	public java.util.Date getStamp()
	{
		return Stamp;
	}
	
	public void setStamp()
	{
		Stamp = Calendar.getInstance().getTime();
	}

}
