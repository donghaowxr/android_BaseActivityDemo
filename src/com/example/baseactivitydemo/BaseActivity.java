package com.example.baseactivitydemo;

import com.baseactivity.common.MyActivityManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BaseActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		MyActivityManager.getInstance().setCurrentActivity(this);
	}
	
	public void jumpIntent(Context context,Class<?>toClass){
		Intent intent=new Intent(context, toClass);
		startActivity(intent);
	}
	
	public void finishActivity(){
		Button btnReturn=(Button)findViewById(R.id.btnReturn);
		btnReturn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
	
	public void exit(){
		MyActivityManager.getInstance().exitActivity();
	}
}
