package com.example.androidsro.activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.example.androidsro.R;
import com.example.androidsro.model.AssetDetail;
import com.example.androidsro.model.Category;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CarouselActivity extends BaseActivity {
	
	private static String goGetCategoriesCallURL = "http://10.0.2.2:8080/getfakecategories/";
	private static String goGetAssetDetailsCallURL = "http://10.0.2.2:8080/getfakeassetdetails/";

	private ProgressDialog pDialog;

	//Array of JSON objects from service call
	JSONArray jsonResponseCategories;
	JSONArray jsonResponseAssetDetails;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_carousel_);
		 
		new CallCategoryWebserviceAPI().execute();
	}
	
	public HorizontalScrollView createRow(String category) {
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
	            RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		
		LinearLayout layout = new LinearLayout(this);
		layout.setLayoutParams(lp);
		
		HorizontalScrollView scrollview = new HorizontalScrollView(this);
		scrollview.setLayoutParams(lp);
		scrollview.setId(1);
		
		ImageView imageView;
		for(int i=0; i<mThumbIds.length; i++) {
			imageView = new ImageView(this);
			imageView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
			imageView.setImageResource(mThumbIds[i]);
			
			imageView.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View view) {
					//Intent assetDetailsIntent = new Intent(this, AssetDetailActivity.class);
				}
			});
			
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
			JSONParser parser=new JSONParser();
			
			try {
				URL getCategoriesUrl = new URL(goGetCategoriesCallURL);
		        BufferedReader categoriesIn = new BufferedReader(new InputStreamReader(getCategoriesUrl.openStream()));
		        jsonResponseCategories = (JSONArray)parser.parse(categoriesIn);
		        
		        URL getAssetDetailsUrl = new URL(goGetAssetDetailsCallURL);
		        BufferedReader assetDetailsIn = new BufferedReader(new InputStreamReader(getAssetDetailsUrl.openStream()));
		        jsonResponseAssetDetails = (JSONArray)parser.parse(assetDetailsIn);
		        
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
            
    		for(int i=0; i<jsonResponseCategories.size(); i++) {
    			JSONObject object = (JSONObject)jsonResponseCategories.get(i);
    			String key = (String)object.get("Name");
    			
    			TextView rowTitle = new TextView(CarouselActivity.this);
    			rowTitle.setText(key);
    			rowTitle.setId(20+i);
    			rowTitle.setLayoutParams(lp);
    			
    			mainLayout.addView(rowTitle);
    			
    			HorizontalScrollView hsView = createRow(key);
    			hsView.setLayoutParams(lp);
    			mainLayout.addView(hsView);
    		}
        }
	}
	
	public List<AssetDetail> convertJsonToAssetDetail(JSONArray assetDetailsJson) {
		List<AssetDetail> assetList = new ArrayList<AssetDetail>();
		
		for(int i=0; i<assetDetailsJson.size(); i++) {
			JSONObject object = (JSONObject)assetDetailsJson.get(i);
			
			AssetDetail detail = new AssetDetail();
			
			if(object.containsKey("AssetId")) {
				detail.setAssetId((String)object.get("AssetId"));
			}
			
			if(object.containsKey("Title")) {
				detail.setAssetId((String)object.get("Title"));
			}
			
			if(object.containsKey("CategoryId")) {
				detail.setAssetId((String)object.get("CategoryId"));
			}
			
			if(object.containsKey("AppKey")) {
				detail.setAssetId((String)object.get("AppKey"));
			}
			
			assetList.add(detail);
		}
		
		return assetList;
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
            R.drawable.sample_0, R.drawable.sample_1
    };
}
