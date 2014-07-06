package com.evara.randomdecider;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class HeadsTailsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_heads_tails);
		
		Intent getString = getIntent();
		String displayDecision = getString.getStringExtra("HeadsTails");
		
		TextView decision = (TextView) findViewById(R.id.txt_decision);
		decision.setText(displayDecision);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.heads_tails, menu);
		return true;
	}

}
