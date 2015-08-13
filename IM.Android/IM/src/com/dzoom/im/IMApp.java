package com.dzoom.im;

import cn.bmob.v3.Bmob;
import imsdk.data.IMSDK;
import android.app.Application;

public class IMApp extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		Bmob.initialize(this, "50acffdf5bafbae4f1a58936d9638380");
		IMSDK.init(getApplicationContext(), "c8c4c68deca57d45c0e7802d"); 
	}

}
