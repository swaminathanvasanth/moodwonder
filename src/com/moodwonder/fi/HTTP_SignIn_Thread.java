package com.moodwonder.fi;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

public class HTTP_SignIn_Thread extends AsyncTask<Void, Void, Void> {

	public String POST_SignIn = null;
	public String Get_MyCompany_JSON = null;
	public String Get_MyManager_JSON = null;
	public String Get_MyMood_JSON = null;
	public String Get_MyTeam_JSON = null;
	public String Get_MySurvey_JSON = null;
	public String hash = null;
	public String code = null;
	public String user_name;
	public String pass_word;
	public String[] my_Company_Top_key = new String[3];
	public String[] my_Company_Top_rating = new String[3];

	public String[] my_Company_Bottom_key = new String[3];
	public String[] my_Company_Bottom_rating = new String[3];
	public String[] my_Company_survey_rating = new String[13];

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub

		super.onPreExecute();
	}

	MoodWonderMyCompany mycompany = new MoodWonderMyCompany();

	public void getData(String username, String password) {
		this.user_name = username;
		this.pass_word = password;
	}

	@Override
	public Void doInBackground(Void... params) {

		// TODO Auto-generated method stub

		// ///////////////////////////// HTTP POST ///////////////////////////

		// Creating HTTP client
		HttpClient POSThttpClient = new DefaultHttpClient();
		HttpClient GETHttpClient = new DefaultHttpClient();

		// Creating HTTP Post
		HttpPost httpPost = new HttpPost("http://test.moodwonder.com/api/login");

		// Building post parameters, key and value pair
		List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(2);
		nameValuePair.add(new BasicNameValuePair("email", user_name));// "kimmo@moodwonder.com"
																		// "kimmokauhanen@gmail.com"
		nameValuePair.add(new BasicNameValuePair("password", pass_word));// t1t1nalkku
																			// /"T1t1sana"

		// Url Encoding the POST parameters
		try {

			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
		} catch (UnsupportedEncodingException e) {
			// writing error to Log
			e.printStackTrace();
		}

		// Making HTTP Request
		try {
			HttpResponse response = POSThttpClient.execute(httpPost);

			POST_SignIn = EntityUtils.toString(response.getEntity());
			// writing response to log
			Log.d("Http Response:", POST_SignIn);

			JSONObject CodeObj = new JSONObject(POST_SignIn);
			code = CodeObj.getString("code");
			JSONObject dataObj = CodeObj.getJSONObject("data");
			hash = dataObj.getString("hash");
			// writing response to log
			UserData userdata = new UserData();
			userdata.setHash(hash);
			Log.d("Seperating Hash from JSON Object:", hash);
			Log.d("Seperating Code:", code);

			// /////////////////////// GET /////////////////////

			String MyCompany_GET = "http://test.moodwonder.com/api/my_company?hash="
					+ hash;
			HttpGet MyCompany_GET_request = new HttpGet(MyCompany_GET);
			HttpResponse MyCompany_GET_response = GETHttpClient
					.execute(MyCompany_GET_request);
			Get_MyCompany_JSON = EntityUtils.toString(MyCompany_GET_response
					.getEntity());

			Log.d("Requesting myCompany JSON list through HTTP GET:",
					MyCompany_GET);
			Log.d("Http GET Response:", Get_MyCompany_JSON);

			JSONObject jsonObj = new JSONObject(Get_MyCompany_JSON);

			JSONObject jsondata = jsonObj.getJSONObject("data");
			JSONArray jsonArray_companyTopStatements = jsondata
					.getJSONArray("companyTopStatements");

			for (int i = 0; i < jsonArray_companyTopStatements.length(); i++) {
				JSONObject companyTopStatements = jsonArray_companyTopStatements
						.getJSONObject(i);

				my_Company_Top_key[i] = companyTopStatements.getString("key");

				my_Company_Top_rating[i] = companyTopStatements
						.getString("answer");
				// userdata.setMy_Company_Top_key_1(my_Company_Top_key[1]);
				Log.d("Key", my_Company_Top_key[i]);
				Log.d("Rating", my_Company_Top_rating[i]);
			}

			userdata.setMy_Company_Top_key_1(my_Company_Top_key[0]);
			userdata.setMy_Company_Top_key_2(my_Company_Top_key[1]);
			userdata.setMy_Company_Top_key_3(my_Company_Top_key[2]);

			userdata.setMy_Company_Top_rating_1(my_Company_Top_rating[0]);
			userdata.setMy_Company_Top_rating_2(my_Company_Top_rating[1]);
			userdata.setMy_Company_Top_rating_3(my_Company_Top_rating[2]);

			// mycompany.getTop(my_Company_Top_key[0], my_Company_Top_key[1],
			// my_Company_Top_key[2]);

			JSONArray jsonArray_companyBottomStatements = jsondata
					.getJSONArray("companyBottomStatements");

			for (int i = 0; i < jsonArray_companyBottomStatements.length(); i++) {
				JSONObject companyBottomStatements = jsonArray_companyBottomStatements
						.getJSONObject(i);

				my_Company_Bottom_key[i] = companyBottomStatements
						.getString("key");
				my_Company_Bottom_rating[i] = companyBottomStatements
						.getString("answer");
				Log.d("Key", my_Company_Bottom_key[i]);
				Log.d("Rating", my_Company_Bottom_rating[i]);
			}

			userdata.setMy_Company_Bottom_key_1(my_Company_Bottom_key[0]);
			userdata.setMy_Company_Bottom_key_2(my_Company_Bottom_key[1]);
			userdata.setMy_Company_Bottom_key_3(my_Company_Bottom_key[2]);

			userdata.setMy_Company_Bottom_rating_1(my_Company_Bottom_rating[0]);
			userdata.setMy_Company_Bottom_rating_2(my_Company_Bottom_rating[1]);
			userdata.setMy_Company_Bottom_rating_3(my_Company_Bottom_rating[2]);

			String MyManager_GET = "http://test.moodwonder.com/api/my_manager?hash="
					+ hash;
			HttpGet MyManager_GET_request = new HttpGet(MyManager_GET);
			HttpResponse MyManager_GET_response = GETHttpClient
					.execute(MyManager_GET_request);
			Get_MyManager_JSON = EntityUtils.toString(MyManager_GET_response
					.getEntity());

			Log.d("Requesting myManager JSON list through HTTP GET:",
					MyManager_GET);
			Log.d("Http GET Response:", Get_MyManager_JSON);

			String MyMood_GET = "http://test.moodwonder.com/api/my_mood?hash="
					+ hash;
			HttpGet MyMood_GET_request = new HttpGet(MyMood_GET);
			HttpResponse MyMood_GET_response = GETHttpClient
					.execute(MyMood_GET_request);
			Get_MyMood_JSON = EntityUtils.toString(MyMood_GET_response
					.getEntity());

			Log.d("Requesting myMood JSON list through HTTP GET:", MyMood_GET);
			Log.d("Http GET Response:", Get_MyMood_JSON);

			String MyTeam_GET = "http://test.moodwonder.com/api/my_team?hash="
					+ hash;
			HttpGet MyTeam_GET_request = new HttpGet(MyTeam_GET);
			HttpResponse MyTeam_GET_response = GETHttpClient
					.execute(MyTeam_GET_request);
			Get_MyTeam_JSON = EntityUtils.toString(MyTeam_GET_response
					.getEntity());

			Log.d("Requesting myTeam JSON list through HTTP GET:", MyTeam_GET);
			Log.d("Http GET Response:", Get_MyTeam_JSON);

			String MySurvey_GET = "http://test.moodwonder.com/api/survey/240?hash="
					+ hash;
			HttpGet MySurvey_GET_request = new HttpGet(MySurvey_GET);
			HttpResponse MySurvey_GET_response = GETHttpClient
					.execute(MySurvey_GET_request);

			Get_MySurvey_JSON = EntityUtils.toString(MySurvey_GET_response
					.getEntity());

			Log.d("Requesting mySurvey JSON list through HTTP GET:",
					MySurvey_GET);
			Log.d("Http GET Response:", Get_MySurvey_JSON);

			JSONObject jsonObj_survey = new JSONObject(Get_MySurvey_JSON);

			JSONObject jObj_main = new JSONObject(Get_MySurvey_JSON);
			JSONObject jOb_data = jObj_main.getJSONObject("data");
			JSONObject jOb_survey = jOb_data.getJSONObject("survey");

			JSONArray jArray_questionAnswers = jOb_survey
					.getJSONArray("questionAnswers");

			for (int i = 0; i < jArray_questionAnswers.length(); i++) {

				JSONObject questionAnswer = jArray_questionAnswers
						.getJSONObject(i);

				my_Company_survey_rating[i] = questionAnswer
						.getString("answer");
				
				if(i==0){
				userdata.setMy_Company_survey_rating_1(my_Company_survey_rating[i]);
				Log.d("Rating Set", my_Company_survey_rating[i]);
				}
				
				if(i==1){
					userdata.setMy_Company_survey_rating_2(my_Company_survey_rating[i]);
					Log.d("Rating Set", my_Company_survey_rating[i]);
					}
				
				if(i==2){
					userdata.setMy_Company_survey_rating_3(my_Company_survey_rating[i]);
					Log.d("Rating Set", my_Company_survey_rating[i]);
					}
					
				if(i==3){
					userdata.setMy_Company_survey_rating_4(my_Company_survey_rating[i]);
					Log.d("Rating Set", my_Company_survey_rating[i]);
					}
					
				if(i==4){
					userdata.setMy_Company_survey_rating_5(my_Company_survey_rating[i]);
					Log.d("Rating Set", my_Company_survey_rating[i]);
					}
					
				if(i==5){
					userdata.setMy_Company_survey_rating_6(my_Company_survey_rating[i]);
					Log.d("Rating Set", my_Company_survey_rating[i]);
					}
					
				if(i==6){
					userdata.setMy_Company_survey_rating_7(my_Company_survey_rating[i]);
					Log.d("Rating Set", my_Company_survey_rating[i]);
					}
					
				if(i==7){
					userdata.setMy_Company_survey_rating_8(my_Company_survey_rating[i]);
					Log.d("Rating Set", my_Company_survey_rating[i]);
					}
					
				if(i==8){
					userdata.setMy_Company_survey_rating_9(my_Company_survey_rating[i]);
					Log.d("Rating Set", my_Company_survey_rating[i]);
					}
					
				if(i==9){
					userdata.setMy_Company_survey_rating_10(my_Company_survey_rating[i]);
					Log.d("Rating Set", my_Company_survey_rating[i]);
					}
					
				if(i==10){
					userdata.setMy_Company_survey_rating_11(my_Company_survey_rating[i]);
					Log.d("Rating Set", my_Company_survey_rating[i]);
					}
					
				if(i==11){
					userdata.setMy_Company_survey_rating_12(my_Company_survey_rating[i]);
					Log.d("Rating Set", my_Company_survey_rating[i]);
					}
					
				if(i==12){
					userdata.setMy_Company_survey_rating_13(my_Company_survey_rating[i]);
					Log.d("Rating Set", my_Company_survey_rating[i]);
					}
					
					
				
				Log.d("Rating", my_Company_survey_rating[i]);
			}

		} catch (ClientProtocolException e) {
			// writing exception to log
			e.printStackTrace();
		} catch (IOException e) {
			// writing exception to log
			e.printStackTrace();

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ///////////////////////////// HTTP POST ///////////////////////////

		return null;
	}
}
