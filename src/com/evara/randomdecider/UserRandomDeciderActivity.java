package com.evara.randomdecider;

import java.util.ArrayList;
import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class UserRandomDeciderActivity extends Activity {

	private ArrayList<String> listOfChoices;
	private Random randomDecider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_random_decider);
		Button generateButton = (Button) findViewById(R.id.button1);
		Button enterButton = (Button) findViewById(R.id.button2);

		Intent getInformation = getIntent();
		listOfChoices = getInformation.getStringArrayListExtra("ArrayList");

		randomDecider = new Random(System.currentTimeMillis());

		enterButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				EditText editText = (EditText) findViewById(R.id.editText1);
				String editTextString = editText.getText().toString();
				displayInformation(listOfChoices, editTextString);

				editText.setText("");
			}
		});

		generateButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				ArrayList<String> listOfDecisions = new ArrayList<String>();

				int indexOfDecision = randomDecider.nextInt(listOfChoices.size());
				String decision = listOfChoices.get(indexOfDecision);
				listOfDecisions.add(decision);

				Intent goToUserDecider = new Intent(UserRandomDeciderActivity.this, UserDeciderActivity.class);

				goToUserDecider.putStringArrayListExtra("ArrayListOfDecisions", listOfDecisions);

				startActivity(goToUserDecider);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_random_decider, menu);
		return true;
	}

	public void displayInformation(ArrayList<String> choices, String stringToAdd) {
		ListView listView = (ListView) findViewById(R.id.listView1);

		listOfChoices.add(stringToAdd);

		ArrayAdapter<String> arrayAdapter = 
				new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, listOfChoices);
		listView.setAdapter(arrayAdapter);
	}

}
