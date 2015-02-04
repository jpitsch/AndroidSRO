package com.example.androidsro;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.MediaExtractor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.MediaController;
import android.widget.VideoView;

//public class MainActivity extends Activity implements SurfaceHolder.Callback, OnPreparedListener{
public class MainActivity extends Activity {

	private MediaPlayer mediaPlayer;
	private SurfaceHolder vidHolder;
	private SurfaceView vidSurface;
	String vidAddress = "https://s3-us-west-1.amazonaws.com/jwplayeroverlay/jw-text-overlay/test.mp4";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//vidSurface = (SurfaceView) findViewById(R.id.surfView);
		//vidHolder = vidSurface.getHolder();
		//vidHolder.addCallback(this);
		
		VideoView vidView = (VideoView)findViewById(R.id.myVideo);
		MediaController vidControl = new MediaController(this);
		vidControl.setAnchorView(vidView);
		vidView.setMediaController(vidControl);
		
		Uri vidUri = Uri.parse(vidAddress);
		
		vidView.setVideoURI(vidUri);
		vidView.start();
	}

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
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	

//	@Override
//	public void onPrepared(MediaPlayer mp) {
//		
//		mediaPlayer.start();
//		
//	}
//
//	@Override
//	public void surfaceCreated(SurfaceHolder holder) {
//		
//		try {
//		    mediaPlayer = new MediaPlayer();
//		    mediaPlayer.setDisplay(vidHolder);
//		    mediaPlayer.setDataSource(vidAddress);
//		    mediaPlayer.prepare();
//		    mediaPlayer.setOnPreparedListener(this);
//		    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//		} 
//		catch(Exception e){
//		    e.printStackTrace();
//		}
//		
//	}
//
//	@Override
//	public void surfaceChanged(SurfaceHolder holder, int format, int width,
//			int height) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void surfaceDestroyed(SurfaceHolder holder) {
//		// TODO Auto-generated method stub
//		
//	}
}
