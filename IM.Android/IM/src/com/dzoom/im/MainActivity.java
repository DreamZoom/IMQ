package com.dzoom.im;

import java.util.ArrayList;
import java.util.List;

import com.dzoom.im.adapters.MainViewAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;

public class MainActivity extends FragmentActivity {

	List<Fragment> fragmentList = new ArrayList<Fragment>();
	ViewPager vPager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    vPager = (ViewPager)findViewById(R.id.vPager);
		
		fragmentList.add(new ConversationFragment());
		fragmentList.add(new NearFragment());
		fragmentList.add(new SettingFragment());
		fragmentList.add(new CenterFragment());
		
		vPager.setAdapter(new MainViewAdapter(getSupportFragmentManager(),fragmentList));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
