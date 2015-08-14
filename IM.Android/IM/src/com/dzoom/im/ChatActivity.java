package com.dzoom.im;

import imsdk.views.IMChatView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class ChatActivity extends Activity{

	String chatUserID;
	
	private IMChatView mChatView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		chatUserID = getIntent().getStringExtra("ChatUserID");

		// 创建一个IMChatView实例
		mChatView = new IMChatView(this, chatUserID);

		// 为IMChatView实例配置参数
		mChatView.setMaxGifCountInMessage(10);
		mChatView.setUserMainPhotoVisible(true);
		mChatView.setUserMainPhotoCornerRadius(10);
		mChatView.setTitleBarVisible(true);
		mChatView.setHapticFeedbackEnabled(true);
		
		// 添加到当前activity
		setContentView(mChatView);
		
		//添加头像点击事件监听
		mChatView.setOnHeadPhotoClickListener(new IMChatView.OnHeadPhotoClickListener() {
			
			@Override
			public void onClick(View v, String customUserID) {
				Toast.makeText(ChatActivity.this, "您点击了"+customUserID, Toast.LENGTH_SHORT).show();
			}
			
		});
		
		
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		// 为了实现捕获用户选择的图片
		mChatView.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// 为了实现点击返回键隐藏表情栏
		mChatView.onKeyDown(keyCode, event);
		return super.onKeyDown(keyCode, event);
	}

}
