package com.dzoom.im;

import java.util.ArrayList;

import imsdk.data.IMSDK.OnDataChangedListener;
import imsdk.data.recentcontacts.IMMyselfRecentContacts;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class ConversationFragment extends Fragment  {
	ListView mListView;
	
	ArrayList mCustomUserIDsList;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_conversation, container, false);
        mListView=(ListView)v.findViewById(R.id.mSessionList);
        
        Init();
        return v;
    }
	
	@SuppressWarnings("unchecked")
	public void Init(){
			
		final Context context = this.getActivity();
		

		mCustomUserIDsList = IMMyselfRecentContacts.getUsersList();      
		// 刷新ListView
        mListView.setAdapter(new ArrayAdapter<String>(
        	context,
            android.R.layout.simple_list_item_1, mCustomUserIDsList));
        
		
		IMMyselfRecentContacts.setOnDataChangedListener(new OnDataChangedListener() {
		    @SuppressWarnings("unchecked")
			@Override
		    public void onDataChanged() {
		        // 重新获取最近联系人列表
				mCustomUserIDsList = IMMyselfRecentContacts.getUsersList();      
				// 刷新ListView
		        mListView.setAdapter(new ArrayAdapter<String>(
		        	context,
		            android.R.layout.simple_list_item_1, mCustomUserIDsList));
		        }
		    });
			
		
		final Activity activity = this.getActivity();
		mListView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				String UserID = (String) mCustomUserIDsList.get(arg2);
				Intent  intent =new Intent(activity,ChatActivity.class);
				intent.putExtra("ChatUserID", UserID);
				
				activity.startActivity(intent);
				
			}});
	}

}
