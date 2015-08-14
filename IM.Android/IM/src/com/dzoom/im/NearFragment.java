package com.dzoom.im;

import imsdk.data.IMSDK.OnDataChangedListener;
import imsdk.data.around.IMMyselfAround;
import imsdk.data.around.IMMyselfAround.OnAroundActionListener;
import imsdk.data.recentcontacts.IMMyselfRecentContacts;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class NearFragment extends Fragment {
	
	ListView mListView;
	
	ArrayList mCustomUserIDsList;
	
	ArrayAdapter<String> adapter;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_address, container, false);
        mListView=(ListView)v.findViewById(R.id.nearUserList);
        
        Init();
        return v;
    }
	
	@SuppressWarnings("unchecked")
	public void Init(){
		mCustomUserIDsList=new ArrayList<String>();
        final Context context = this.getActivity();
		

		mCustomUserIDsList.addAll(IMMyselfAround.getAllUsers()) ;
		// 刷新ListView
		
		adapter = new ArrayAdapter<String>(
        	context,
            android.R.layout.simple_list_item_1, mCustomUserIDsList);
        mListView.setAdapter(adapter);
        
		
        IMMyselfAround.update(new OnAroundActionListener() {

			@Override
			public void onFailure(String arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess( ArrayList arg0) {
				// TODO Auto-generated method stub
				mCustomUserIDsList.clear() ;
				mCustomUserIDsList.addAll(arg0);
				adapter.notifyDataSetChanged();
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
				
			}
		});
	}
}
