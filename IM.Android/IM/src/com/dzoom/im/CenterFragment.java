package com.dzoom.im;



import java.util.List;

import com.dzoom.im.bean.User;
import com.squareup.picasso.Picasso;

import cn.bmob.im.BmobUserManager;
import cn.bmob.im.bean.BmobChatUser;
import cn.bmob.v3.listener.FindListener;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CenterFragment extends Fragment {

	ImageView img_user;
	TextView text_username;
	TextView text_account;
	BmobUserManager userManager;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_center, container, false);
        
        text_username = (TextView)v.findViewById(R.id.text_username);
        text_account = (TextView)v.findViewById(R.id.text_account);
        img_user = (ImageView)v.findViewById(R.id.img_user);
       
        Init();
        return v;
    }
	
	public void Init(){
		
		final Context context =this.getActivity();
		userManager =BmobUserManager.getInstance(this.getActivity()); 
		BmobChatUser user = userManager.getCurrentUser();
	   
		text_username.setText(user.getUsername());
		text_account.setText(user.getEmail());
		Picasso.with(context).load(user.getAvatar()).placeholder(R.drawable.default_avatar).resize(100, 100).into(img_user);
		
	}

}
