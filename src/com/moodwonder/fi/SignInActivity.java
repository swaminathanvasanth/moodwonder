package com.moodwonder.fi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SignInActivity extends Activity {

	public String user_name;
	public String pass_word;
	EditText user;
	EditText pwd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_in);
		user = (EditText) findViewById(R.id.username);
		pwd = (EditText) findViewById(R.id.password);

		user.setText("kimmokauhanen@gmail.com");
		pwd.setText("T1t1sana");
		
		/* Sign-In */
		ImageButton signinbutton = (ImageButton) findViewById(R.id.signinButton);
		signinbutton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				HTTP_SignIn_Thread signin = new HTTP_SignIn_Thread();
				user_name = user.getText().toString();
				pass_word = pwd.getText().toString();

				Log.d("User Name", user_name);
				Log.d("PassWord", pass_word);

				signin.getData(user_name, pass_word);
				signin.execute();
				
				try {

					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (signin.code.endsWith("1")) {

					Intent signInActivity = new Intent(SignInActivity.this,
							MoodWonderHome.class);
					startActivity(signInActivity);
					Toast.makeText(getApplicationContext(), "LOGIN SUCCESSFUL",
							Toast.LENGTH_LONG).show();
				}

				else {
					Toast.makeText(getApplicationContext(),
							"INVALID USERNAME or PASSWORD", Toast.LENGTH_LONG)
							.show();
				}
			}
		});

		/* Sign-In */
		/* Sign-Up */
		ImageButton signupbutton = (ImageButton) findViewById(R.id.signupButton);
		signupbutton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent signUpActivity = new Intent(SignInActivity.this,
						SignUp.class);
				startActivity(signUpActivity);
			}
		});
		/* Sign-Up */

	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.sign_in, menu);
		return super.onCreateOptionsMenu(menu);
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch(item.getItemId()){
		case R.id.action_preference:
			startActivity(new Intent(this, PrefsActivity.class));
		
		}
		return super.onOptionsItemSelected(item);
	}

}
