package com.evara.randomdecider;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class UserDeciderActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_decider);
		ListView listView = (ListView) findViewById(R.id.listView1);
		
		Intent getInformation = getIntent();
		ArrayList<String> listOfDecisions= getInformation.getStringArrayListExtra("ArrayListOfDecisions");
		
		ArrayAdapter<String> arrayAdapter = 
				new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, listOfDecisions);
		listView.setAdapter(arrayAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_decider, menu);
		return true;
	}

}
