package com.example.baseactivitydemo;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends BaseActivity {
	private Button btnJump;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnJump=(Button) findViewById(R.id.btnJump);
		finishActivity();
		btnJump.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				jumpIntent(MainActivity.this, SecondActivity.class);
			}
		});
	}
}
