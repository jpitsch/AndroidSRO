package com.example.androidsro;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlaybackActivity extends Activity {
	
	String vidAddress = "https://s3-us-west-1.amazonaws.com/jwplayeroverlay/jw-text-overlay/test.mp4";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video_playback);
		
		VideoView vidView = (VideoView)findViewById(R.id.myVideo);
		MediaController vidControl = new MediaController(this);
		vidControl.setAnchorView(vidView);
		vidView.setMediaController(vidControl);
		
		Uri vidUri = Uri.parse(vidAddress);
		
		vidView.setVideoURI(vidUri);
		vidView.start();
	}
}
