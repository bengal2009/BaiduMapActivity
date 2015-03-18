package com.baidu.map;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.map.MapController;
import com.baidu.mapapi.map.MapView;
import com.baidu.platform.comapi.basestruct.GeoPoint;

import android.os.Bundle;
import android.app.Activity;

public class MyBaiduMapActivity extends Activity {
	BaiduApplication app;
	BMapManager manager;
	MapView mapView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		app = (BaiduApplication) getApplication();
		manager = new BMapManager(this);
//		manager = app.manager;
		manager.init("A3430665290BDD60286867CAD5093C28CA7496B4", null);
		mapView = (MapView) findViewById(R.id.bmapsView);
		mapView.setBuiltInZoomControls(true);
		
		MapController mapController = mapView.getController();
		GeoPoint point = new GeoPoint((int)(39.915*1E6), (int)(116.404*1E6));
		mapController.setCenter(point);
		mapController.setZoom(12);
	}
	
	@Override
	protected void onDestroy() {
		mapView.destroy();
		if (manager != null) {
			manager.destroy();
			manager = null;
		}
		super.onDestroy();
	}

	@Override
	protected void onResume() {
		mapView.onResume();
		if (manager != null) {
			manager.start();
		}
		super.onResume();
	}

	@Override
	protected void onPause() {
		mapView.onPause();
		if (manager != null) {
			manager.stop();
		}
		super.onPause();
		
	}
	
	
}
