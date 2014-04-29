package com.moodwonder.fi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class SignUp extends Activity {

	TextView signup;
	String email = null;
	HTTP_SignUp_Thread signupThread = new HTTP_SignUp_Thread();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);

		signup.findViewById(R.id.signup_email);
		ImageButton signupBtn = (ImageButton) findViewById(R.id.signupButton);
		signupBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				email = signup.getText().toString();
				signupThread.execute(email);

			}
		});
	}

}
