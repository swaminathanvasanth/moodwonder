package com.moodwonder.fi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MoodWonderMyCompanySurveyQuestions extends Activity {
	
	UserData userdata = new UserData();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_moodwonder_mycompany_survey);

		final SeekBar seekBar1 = (SeekBar) findViewById(R.id.seekBarTop2);
		final TextView seekBarValue1 = (TextView) findViewById(R.id.seekbarRating);
		
		String rating_1 = userdata.getMy_Company_survey_rating_1();
		int rating_one = (int) (Float.parseFloat(rating_1) * 10);
		seekBar1.setProgress(rating_one);
		seekBarValue1.setText(rating_1+"/5");

		seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub

				float seekValue1 = (float) ((seekBar1.getProgress()) * 0.1);
				seekBarValue1.setText(seekValue1 + "/5");

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}
		}

		);

		final SeekBar seekBar2 = (SeekBar) findViewById(R.id.seekBarBone);
		final TextView seekBarValue2 = (TextView) findViewById(R.id.seekbarRating2);
		
		String rating_2 = userdata.getMy_Company_survey_rating_2();
		int rating_two = (int) (Float.parseFloat(rating_2) * 10);
		seekBar2.setProgress(rating_two);
		seekBarValue2.setText(rating_2+"/5");



		seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub

				float seekValue2 = (float) ((seekBar2.getProgress()) * 0.1);
				seekBarValue2.setText(seekValue2 + "/5");

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}
		});

		final SeekBar seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
		final TextView seekBarValue3 = (TextView) findViewById(R.id.seekbarRating3);

		String rating_3 = userdata.getMy_Company_survey_rating_3();
		int rating_three = (int) (Float.parseFloat(rating_3) * 10);
		seekBar3.setProgress(rating_three);
		seekBarValue3.setText(rating_3+"/5");

		
		seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub

				float seekValue3 = (float) ((seekBar3.getProgress()) * 0.1);
				seekBarValue3.setText(seekValue3 + "/5");

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}
		}

		);
		
		final SeekBar seekBar4 = (SeekBar) findViewById(R.id.seekBarBtwo);
		final TextView seekBarValue4 = (TextView) findViewById(R.id.seekbarRating4);

		String rating_4 = userdata.getMy_Company_survey_rating_4();
		int rating_four = (int) (Float.parseFloat(rating_4) * 10);
		seekBar4.setProgress(rating_four);
		seekBarValue4.setText(rating_4+"/5");

		seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub

				float seekValue4 = (float) ((seekBar4.getProgress()) * 0.1);
				seekBarValue4.setText(seekValue4 + "/5");

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}
		}

		);
		

		final SeekBar seekBar5 = (SeekBar) findViewById(R.id.seekBar5);
		final TextView seekBarValue5 = (TextView) findViewById(R.id.seekbarRating5);
		
		String rating_5 = userdata.getMy_Company_survey_rating_5();
		int rating_five = (int) (Float.parseFloat(rating_5) * 10);
		seekBar5.setProgress(rating_five);
		seekBarValue5.setText(rating_5+"/5");

		seekBar5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub

				float seekValue5 = (float) ((seekBar5.getProgress()) * 0.1);
				seekBarValue5.setText(seekValue5 + "/5");

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}
		}

		);

		
		final SeekBar seekBar6 = (SeekBar) findViewById(R.id.seekBar6);
		final TextView seekBarValue6 = (TextView) findViewById(R.id.seekbarRating6);

		String rating_6 = userdata.getMy_Company_survey_rating_6();
		int rating_six = (int) (Float.parseFloat(rating_6) * 10);
		seekBar6.setProgress(rating_six);
		seekBarValue6.setText(rating_6+"/5");

		seekBar6.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub

				float seekValue6 = (float) ((seekBar6.getProgress()) * 0.1);
				seekBarValue6.setText(seekValue6 + "/5");

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}
		}

		);

		final SeekBar seekBar7 = (SeekBar) findViewById(R.id.seekBar7);
		final TextView seekBarValue7 = (TextView) findViewById(R.id.seekbarRating7);

		String rating_7 = userdata.getMy_Company_survey_rating_7();
		int rating_seven = (int) (Float.parseFloat(rating_7) * 10);
		seekBar7.setProgress(rating_seven);
		seekBarValue7.setText(rating_7+"/5");

		seekBar7.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub

				float seekValue7 = (float) ((seekBar7.getProgress()) * 0.1);
				seekBarValue7.setText(seekValue7 + "/5");

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}
		}

		);

		final SeekBar seekBar8 = (SeekBar) findViewById(R.id.seekBar8);
		final TextView seekBarValue8 = (TextView) findViewById(R.id.seekbarRating8);

		String rating_8 = userdata.getMy_Company_survey_rating_8();
		int rating_eight = (int) (Float.parseFloat(rating_8) * 10);
		seekBar8.setProgress(rating_two);
		seekBarValue8.setText(rating_8+"/5");

		seekBar8.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub

				float seekValue8 = (float) ((seekBar8.getProgress()) * 0.1);
				seekBarValue8.setText(seekValue8 + "/5");

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}
		}

		);

		final SeekBar seekBar9 = (SeekBar) findViewById(R.id.seekBar9);
		final TextView seekBarValue9 = (TextView) findViewById(R.id.seekbarRating9);

		String rating_9 = userdata.getMy_Company_survey_rating_9();
		int rating_nine = (int) (Float.parseFloat(rating_9) * 10);
		seekBar9.setProgress(rating_nine);
		seekBarValue9.setText(rating_9+"/5");

		seekBar9.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub

				float seekValue9 = (float) ((seekBar9.getProgress()) * 0.1);
				seekBarValue9.setText(seekValue9 + "/5");

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}
		}

		);

		
		final SeekBar seekBar10 = (SeekBar) findViewById(R.id.seekBar10);
		final TextView seekBarValue10 = (TextView) findViewById(R.id.seekbarRating10);

		String rating_10 = userdata.getMy_Company_survey_rating_10();
		int rating_ten = (int) (Float.parseFloat(rating_10) * 10);
		seekBar10.setProgress(rating_ten);
		seekBarValue10.setText(rating_10+"/5");

		seekBar10.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub

				float seekValue10 = (float) ((seekBar10.getProgress()) * 0.1);
				seekBarValue10.setText(seekValue10 + "/5");

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}
		}

		);

		
		final SeekBar seekBar11 = (SeekBar) findViewById(R.id.seekBar11);
		final TextView seekBarValue11 = (TextView) findViewById(R.id.seekbarRating11);

		String rating_11 = userdata.getMy_Company_survey_rating_11();
		int rating_eleven = (int) (Float.parseFloat(rating_11) * 10);
		seekBar11.setProgress(rating_eleven);
		seekBarValue11.setText(rating_11+"/5");

		seekBar11.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub

				float seekValue11 = (float) ((seekBar11.getProgress()) * 0.1);
				seekBarValue11.setText(seekValue11 + "/5");

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}
		}

		);

		
		final SeekBar seekBar12 = (SeekBar) findViewById(R.id.seekBar12);
		final TextView seekBarValue12 = (TextView) findViewById(R.id.seekbarRating12);

		String rating_12 = userdata.getMy_Company_survey_rating_12();
		int rating_twelve = (int) (Float.parseFloat(rating_12) * 10);
		seekBar12.setProgress(rating_twelve);
		seekBarValue12.setText(rating_12+"/5");

		seekBar12.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub

				float seekValue12 = (float) ((seekBar12.getProgress()) * 0.1);
				seekBarValue12.setText(seekValue12 + "/5");

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}
		}

		);

		
		final SeekBar seekBar13 = (SeekBar) findViewById(R.id.seekBar13);
		final TextView seekBarValue13 = (TextView) findViewById(R.id.seekbarRating13);

		String rating_13 = userdata.getMy_Company_survey_rating_13();
		int rating_thirteen = (int) (Float.parseFloat(rating_13) * 10);
		seekBar13.setProgress(rating_thirteen);
		seekBarValue13.setText(rating_13+"/5");

		seekBar13.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub

				float seekValue13 = (float) ((seekBar13.getProgress()) * 0.1);
				seekBarValue13.setText(seekValue13 + "/5");

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}
		}

		);


		ImageButton submit = (ImageButton) findViewById(R.id.submitButton);
		submit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new demoAsync().execute();
				
			}
		});

	}

	class demoAsync extends AsyncTask<Void, Void, Void>{
		
		
		ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			
			dialog.show(MoodWonderMyCompanySurveyQuestions.this, "Submit", "Submitting Data");
			super.onPreExecute();
		}

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			
			return null;
		}
		
	}
	
}
