package com.moodwonder.fi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MoodWonderMyMood extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		TextView textview = new TextView(this);
		textview.setText("This is My MyMood Tab");
		setContentView(textview);
	}
 
}
