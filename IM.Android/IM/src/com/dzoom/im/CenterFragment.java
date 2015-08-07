package com.dzoom.im;

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
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_center, container, false);
        
        text_username = (TextView)v.findViewById(R.id.text_username);
        
        return v;
    }

}
