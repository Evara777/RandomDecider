package com.evara.randomdecider;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelectionActivity extends Activity {

	private Random randomDecider = new Random(System.currentTimeMillis());

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selection);


		TextView merow = (TextView) findViewById(R.id.txt_meow);
		
		//Button to generate heads or tails on the next screen.
		Button headsOrTails = (Button) findViewById(R.id.button1);
		headsOrTails.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {

				int decision = randomDecider.nextInt(2);
				String output;
				if (decision == 0) {
					output = "Heads";
				}
				else {
					output = "Tails";
				}

				Intent goToHeadsTailsActivity = new Intent(SelectionActivity.this, HeadsTailsActivity.class);
				goToHeadsTailsActivity.putExtra("HeadsTails", output);
				
				startActivity(goToHeadsTailsActivity);
			}
		});

		
		//Button to go to the user input screen.
		Button userInput = (Button) findViewById(R.id.button2);
		userInput.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent goToUserInput = new Intent(SelectionActivity.this, UserRandomDeciderActivity.class);
				
				ArrayList<String> arrayListToUse = new ArrayList<String>();
				
				goToUserInput.putStringArrayListExtra("ArrayList", arrayListToUse);
				
				startActivity(goToUserInput);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.selection, menu);
		return true;
	}

}
