package com.baidu.map;

import com.baidu.mapapi.BMapManager;

import android.app.Application;
import android.content.Context;


/*
 * 	在AndroidManifest.xml文件中必须添加android:name="com.baidu.map.BaiduApplication",添加位置如下：
 *     <application     android:name="com.baidu.map.BaiduApplication" ..... 
 * */
public class BaiduApplication extends Application {
	public final static String  key= "A3430665290BDD60286867CAD5093C28CA7496B4";
	BMapManager manager;
	@Override
	public void onCreate() {
		
		super.onCreate();
		initBMapManager(this);
	}
	public void initBMapManager(Context context) {
		if (manager == null) {
			manager = new BMapManager(context);
		}
		manager.init(key, null);
	}
	
}
