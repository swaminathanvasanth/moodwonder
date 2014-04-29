package com.moodwonder.fi;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class HTTP_MyManager extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub

		HTTP_SignIn_Thread signin = new HTTP_SignIn_Thread();
		//signin.execute();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Creating HTTP client
		HttpClient httpClient = new DefaultHttpClient();

		// Creating HTTP Post
		HttpGet httpGet = new HttpGet(
				"http://www.moodwonder.com/api/my_company/?hash="+signin.hash);

		Log.d("Hash", "http://www.moodwonder.com/api/my_company/?hash="+signin.hash);

		// Making HTTP Request
		try {
			HttpResponse response = httpClient.execute(httpGet);

			String jsonString = EntityUtils.toString(response.getEntity());

			// writing response to log
			Log.d("Http Response:", jsonString);
		} catch (ClientProtocolException e) {
			// writing exception to log
			e.printStackTrace();
		} catch (IOException e) {
			// writing exception to log
			e.printStackTrace();

		}

		super.run();
	}

}
