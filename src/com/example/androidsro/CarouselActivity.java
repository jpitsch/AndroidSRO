package com.example.androidsro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CarouselActivity extends BaseActivity {
	
	private static String goGetCategoriesCallURL = "http://10.0.2.2:8080/getfakecategories/";

	private ProgressDialog pDialog;

	//Array of JSON objects from webservice call
	JSONArray jsonResponse;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_carousel_);
		
//		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
//	            RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//		
//		LinearLayout mainLayout = (LinearLayout)findViewById(R.id.scrolllayout);
		 
		new CallCategoryWebserviceAPI().execute();
	}
	
	public HorizontalScrollView createRow(int rowNum) {
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
	            RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		
		LinearLayout layout = new LinearLayout(this);
		layout.setLayoutParams(lp);
		
		HorizontalScrollView scrollview = new HorizontalScrollView(this);
		scrollview.setLayoutParams(lp);
		scrollview.setId(10+rowNum);
		
		ImageView imageView;
		for(int i=0; i<mThumbIds.length; i++) {
			imageView = new ImageView(this);
			imageView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
			imageView.setImageResource(mThumbIds[i]);
			
			layout.addView(imageView);
		}

		scrollview.addView(layout);
		
		return scrollview;
	}
	
	private class CallCategoryWebserviceAPI extends AsyncTask<Void, Void, Void> {
		
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(CarouselActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
 
        }

		@Override
		protected Void doInBackground(Void... params) {
			
			try {
				URL url = new URL(goGetCategoriesCallURL);
		        
		        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		        
		        JSONParser parser=new JSONParser();
		        jsonResponse = (JSONArray)parser.parse(in);
		        
		        
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		@Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            
    		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
    				RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
    		
    		LinearLayout mainLayout = (LinearLayout)findViewById(R.id.scrolllayout);
            
    		for(int i=0; i<jsonResponse.size(); i++) {
    			JSONObject object = (JSONObject)jsonResponse.get(i);
    			String key = (String)object.get("Name");
    			
    			TextView rowTitle = new TextView(CarouselActivity.this);
    			rowTitle.setText(key);
    			rowTitle.setId(20+i);
    			rowTitle.setLayoutParams(lp);
    			
    			mainLayout.addView(rowTitle);
    			
    			HorizontalScrollView hsView = createRow(i);
    			hsView.setLayoutParams(lp);
    			mainLayout.addView(hsView);
    		}
        }
	}
	
    private Integer[] mThumbIds = {
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7
    };
}
