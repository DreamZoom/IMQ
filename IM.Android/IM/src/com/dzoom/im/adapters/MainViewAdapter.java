package com.dzoom.im.adapters;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

public class MainViewAdapter extends FragmentPagerAdapter {

	List<Fragment> listView;
	
	public MainViewAdapter(FragmentManager fm,List<Fragment> list) {
		// TODO Auto-generated constructor stub
		super(fm);
		listView=list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(listView==null) return 0;
		return listView.size();
	}



	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return listView.get(arg0);
	}

}
