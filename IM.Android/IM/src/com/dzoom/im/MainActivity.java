package com.dzoom.im;

import imsdk.data.IMMyself;
import imsdk.data.IMMyself.OnActionListener;

import java.util.ArrayList;
import java.util.List;


import cn.bmob.v3.Bmob;

import com.dzoom.im.adapters.MainViewAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.widget.Toast;

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
		
		Login();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void Login(){
		IMMyself.setCustomUserID("wxllzf");
		IMMyself.setPassword("123456");
		IMMyself.login(true, 5, new OnActionListener() {
			@Override
			public void onSuccess() {
		
				Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
				
			}

			@Override
			public void onFailure(String error) {
				if (error.equals("Timeout")) {
					error = "登录超时";
				} else if (error.equals("Wrong Password")) {
					error = "密码错误";
				}

				
				Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
			}
		});
	}

}
