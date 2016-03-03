package com.badlogic.gdx.tests.dragome;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.dragome.DragomeApplication;
import com.badlogic.gdx.backends.dragome.DragomeApplicationConfiguration;
import com.badlogic.gdx.tests.dragome.examples.AnimationTest;
import com.dragome.web.annotations.PageAlias;

@PageAlias(alias= "index")
public class AppStarter extends DragomeApplication
{

	@Override
	public ApplicationListener createApplicationListener() 
	{
//		return new MyApp();
//		return new GearsDemo();
		return new AnimationTest();
	}

	@Override
	public DragomeApplicationConfiguration getConfig() {
		return null;
	}

	
	@Override
	protected void onResize() {
		
		int clientWidth = getWindow().getClientWidth();
		int clientHeight = getWindow().getClientHeight();
		getCanvas().setWidth(clientWidth);
		getCanvas().setHeight(clientHeight);
		getCanvas().setCoordinateSpaceWidth(clientWidth);
		getCanvas().setCoordinateSpaceHeight(clientHeight);
		
		super.onResize();
	}
}
