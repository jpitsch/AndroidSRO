package com.example.androidsro.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import android.content.Context;
import android.os.AsyncTask;

public class MyAsyncTask extends AsyncTask<String, String, String> {

	private Context context;
	private String resultString;
	
	public MyAsyncTask(Context context) {
		this.context = context;
	}
	
	@Override
	protected String doInBackground(String... params) {
		
		String inputStr = "";
		
		try {
			URL url = new URL(params[0]);
	        
	        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
	        
	        JSONParser parser=new JSONParser();
	        JSONObject object = (JSONObject)parser.parse(in);
	        
	        inputStr = object.toJSONString();
	        
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
		return inputStr;
	}
}
