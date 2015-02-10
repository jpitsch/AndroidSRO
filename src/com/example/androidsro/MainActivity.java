package com.example.androidsro;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ListView;

//public class MainActivity extends Activity implements SurfaceHolder.Callback, OnPreparedListener{
public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView listView = (ListView) findViewById(R.id.listview);
		listView.setAdapter(new ImageAdapter(this));
		//GridView gridView = (GridView) findViewById(R.id.gridview);
		//gridView.setAdapter(new ImageAdapter(this));
	}
}
