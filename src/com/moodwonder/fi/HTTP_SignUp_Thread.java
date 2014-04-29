package com.moodwonder.fi;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

public class HTTP_SignUp_Thread extends AsyncTask<String, Void, Void> {

	@Override
	protected Void doInBackground(String... params) {

		// TODO Auto-generated method stub
		// Creating HTTP client
		HttpClient POSThttpClient = new DefaultHttpClient();

		// Creating HTTP Post
		HttpPost httpPost = new HttpPost("http://www.moodwonder.com/api/signup/");

		return null;
	}

}
