package com.example.androidsro.activity;

import com.example.androidsro.R;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlaybackActivity extends BaseActivity {
	
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
