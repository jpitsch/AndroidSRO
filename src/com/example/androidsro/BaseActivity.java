package com.example.androidsro;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class BaseActivity extends Activity {
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		switch (item.getItemId()) {
	        case R.id.action_settings:
	            //showSettings();
	            return true;
	        case R.id.menu_carousel:
	        	Intent carouselIntent = new Intent(this, CarouselActivity.class);
	        	startActivity(carouselIntent);
	            //showCarousel();
	            return true;
	        case R.id.menu_video:
	        	Intent videoIntent = new Intent(this, VideoPlaybackActivity.class);
	        	startActivity(videoIntent);
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
		}
	}

}
