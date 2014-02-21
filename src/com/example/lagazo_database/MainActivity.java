package com.example.lagazo_database;
test
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	DBInterface db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		db = new DBInterface(this);
		
		Button logIn = (Button)findViewById(R.id.MainBtnLogin);
		
		logIn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				EditText name = (EditText)findViewById(R.id.MainETName); 
				String _name = name.getText().toString();
				EditText dept = (EditText)findViewById(R.id.MainETDept); 
				String _dept = dept.getText().toString();
				EditText id = (EditText)findViewById(R.id.MainETID); 
				int _id = Integer.parseInt(id.getText().toString());
				Entry temp = new Entry(_id, _name, _dept);
				//Toast.makeText(getApplicationContext(), temp.getName(), Toast.LENGTH_LONG).show();
				db.addEntry(temp);
			}
		});	
		
		Button viewLogs = (Button)findViewById(R.id.MainBtnViewLogs);
		viewLogs.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				List<Entry> entries = db.getAllEntries();
				for(Entry entry:entries)
					Toast.makeText(getApplicationContext(), 
							entry.getName() , Toast.LENGTH_SHORT).show();
			}
		});
	
		//Entry entry = new Entry(1, "Daniel", "Engineering");
		//Toast.makeText(this, entry.getStamp().toString(), Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
