package com.baseactivity.common;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

public class MyActivityManager {
	private static MyActivityManager sInstance=new MyActivityManager();
	private WeakReference<Activity>sCurrentActiWeakReference;
	private List<Activity>activityList=new ArrayList<Activity>();
	private MyActivityManager(){
		
	}
	public static MyActivityManager getInstance(){
		return sInstance;
	}
	public Activity getCurrentActivity(){
		Activity currentActivity=null;
		if (sCurrentActiWeakReference!=null) {
			currentActivity=sCurrentActiWeakReference.get();
		}
		return currentActivity;
	}
	public void setCurrentActivity(Activity activity){
		sCurrentActiWeakReference=new WeakReference<Activity>(activity);
		if (!activityList.contains(activity)) {
			activityList.add(activity);
		}
	}
	public void exitActivity(){
		for (int i = 0; i < activityList.size(); i++) {
			activityList.get(i).finish();
		}
		android.os.Process.killProcess(android.os.Process.myPid());
	}
}
