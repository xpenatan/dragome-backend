package com.badlogic.gdx.backends.dragome.js.webgl;

import org.w3c.dom.webgl.WebGLContextAttributes;

import com.dragome.commons.javascript.ScriptHelper;
import com.dragome.web.enhancers.jsdelegate.JsCast;

public class WebGLFactory
{
	public static WebGLContextAttributes create()
	{
		WebGLContextAttributes attr= null;
		Object instance= ScriptHelper.eval("{premultipliedAlpha:false}", null);
		attr= JsCast.castTo(instance, WebGLContextAttributes.class);
		return attr;
	}
}