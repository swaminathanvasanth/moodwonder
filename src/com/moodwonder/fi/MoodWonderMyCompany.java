package com.moodwonder.fi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MoodWonderMyCompany extends Activity {

	public String one = null;
	public String one_rating = null;
	
	public int one_Value;
	public int two_Value;
	public int three_Value;
	
	public int oneB_Value;
	public int twoB_Value;
	public int threeB_Value;
	
	public SeekBar seekBarTopOne;
	public SeekBar seekBarTopTwo;
	public SeekBar seekBarTopThree;

	public SeekBar seekBarBOne;
	public SeekBar seekBarBTwo;
	public SeekBar seekBarBThree;
	
	public String two = null;
	public String two_rating = null;
	public String three = null;
	public String three_rating = null;

	public String one_Bottom = null;
	public String one_rating_Bottom = null;
	public String two_Bottom = null;
	public String two_rating_Bottom = null;
	public String three_Bottom = null;
	public String three_rating_Bottom = null;

	UserData userdata = new UserData();

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater moodwonder_menu = getMenuInflater();
		moodwonder_menu.inflate(R.menu.moodwonder_menu, menu);
		return super.onCreateOptionsMenu(menu);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.AboutUs:
			Intent aboutus_intent = new Intent(MoodWonderMyCompany.this,
					AboutUsActivity.class);
			startActivity(aboutus_intent);
			break;
		case R.id.Settings:
			Intent settings_intent = new Intent(MoodWonderMyCompany.this,
					SettingsActivity.class);
			startActivity(settings_intent);
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_moodwonder_mycompany);

		one = userdata.getMy_Company_Top_key_1();
		two = userdata.getMy_Company_Top_key_2();
		three = userdata.getMy_Company_Top_key_3();
		// Log.d("Get Key One", one);
		one_Bottom = userdata.getMy_Company_Bottom_key_1();
		two_Bottom = userdata.getMy_Company_Bottom_key_2();
		three_Bottom = userdata.getMy_Company_Bottom_key_3();

		one_rating = userdata.getMy_Company_Top_rating_1();
		two_rating = userdata.getMy_Company_Top_rating_2();
		three_rating = userdata.getMy_Company_Top_rating_3();

		one_rating_Bottom = userdata.getMy_Company_Bottom_rating_1();
		two_rating_Bottom = userdata.getMy_Company_Bottom_rating_2();
		three_rating_Bottom = userdata.getMy_Company_Bottom_rating_3();

		TextView Top_one = (TextView) (findViewById(R.id.myCompany_Top1));
		TextView Top_one_rating = (TextView) (findViewById(R.id.myCompany_Top_rating1));
		TextView Top_two = (TextView) (findViewById(R.id.myCompany_Top2));
		TextView Top_two_rating = (TextView) (findViewById(R.id.myCompany_Top_rating2));
		TextView Top_three = (TextView) (findViewById(R.id.myCompany_Top3));
		TextView Top_three_rating = (TextView) (findViewById(R.id.myCompany_Top_rating3));

		TextView Top_oneB = (TextView) (findViewById(R.id.myCompany_Bottom1));
		TextView Top_one_ratingB = (TextView) (findViewById(R.id.myCompany_Bottom_rating1));

		TextView Top_twoB = (TextView) (findViewById(R.id.myCompany_Bottom2));
		TextView Top_threeB = (TextView) (findViewById(R.id.myCompany_Bottom3));

		TextView Top_two_ratingB = (TextView) (findViewById(R.id.myCompany_Bottom_rating2));
		TextView Top_three_ratingB = (TextView) (findViewById(R.id.myCompany_Bottom_rating3));

		Top_one.setText(one);
		Top_two.setText(two);
		Top_one_rating.setText(one_rating);
		Top_two_rating.setText(two_rating);

		Top_three.setText(three);
		Top_three_rating.setText(three_rating);

		Top_oneB.setText(one_Bottom);

		Top_one_ratingB.setText(one_rating_Bottom);

		Top_twoB.setText(two_Bottom);
		Top_threeB.setText(three_Bottom);

		Top_two_ratingB.setText(two_rating_Bottom);
		Top_three_ratingB.setText(three_rating_Bottom);

		seekBarTopOne = (SeekBar) findViewById(R.id.seekBarTop1);
		one_Value = (int) (Float.parseFloat(one_rating) * 10);
		seekBarTopOne.setProgress(one_Value);
		//seekBarTopOne.setEnabled(false);
		
		seekBarTopTwo = (SeekBar) findViewById(R.id.seekBarTop2);
		two_Value = (int) (Float.parseFloat(two_rating) * 10);
		seekBarTopTwo.setProgress(two_Value);
		//seekBarTopTwo.setEnabled(false);
			
		seekBarTopThree = (SeekBar) findViewById(R.id.seekBarTop3);
		three_Value = (int) (Float.parseFloat(three_rating) * 10);
		seekBarTopThree.setProgress(three_Value);
		//seekBarTopThree.setEnabled(false);
		
		
		seekBarBOne = (SeekBar) findViewById(R.id.seekBarBone);
		oneB_Value = (int) (Float.parseFloat(one_rating_Bottom) * 10);
		seekBarBOne.setProgress(oneB_Value);
		//seekBarTopOne.setEnabled(false);
		
		seekBarBTwo = (SeekBar) findViewById(R.id.seekBarBtwo);
		twoB_Value = (int) (Float.parseFloat(two_rating_Bottom) * 10);
		seekBarBTwo.setProgress(twoB_Value);
		//seekBarTopTwo.setEnabled(false);
			
		seekBarBThree = (SeekBar) findViewById(R.id.SeekBarBthree);
		threeB_Value = (int) (Float.parseFloat(three_rating_Bottom) * 10);
		seekBarBThree.setProgress(threeB_Value);
		//seekBarTopThree.setEnabled(false);
		
		
		
		ImageButton answerAll = (ImageButton) findViewById(R.id.ImageAnswerAll);
		answerAll.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent surveyActivity = new Intent(MoodWonderMyCompany.this,
						MoodWonderMyCompanySurveyQuestions.class);
				startActivity(surveyActivity);
			}
		});
	}

}
