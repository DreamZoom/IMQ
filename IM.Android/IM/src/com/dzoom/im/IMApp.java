package com.dzoom.im;

import imsdk.data.IMSDK;
import android.app.Application;

public class IMApp extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		IMSDK.init(getApplicationContext(), "c8c4c68deca57d45c0e7802d"); 
	}

}
