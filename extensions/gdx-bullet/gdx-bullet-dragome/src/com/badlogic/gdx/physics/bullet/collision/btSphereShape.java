/*-------------------------------------------------------
 * This file was automatically generated by XpeCodeGen
 *
 * Dont make changes to this file
 *-------------------------------------------------------*/
package com.badlogic.gdx.physics.bullet.collision;

/** @author xpenatan */
public class btSphereShape extends btConvexInternalShape {

    public btSphereShape(float radius) {
        resetObj(createNative(radius), true);
    }

    public static long createNative(float radius) {
		return com.dragome.commons.javascript.ScriptHelper.evalLong("Bullet.getPointer(new Bullet.btSphereShape(radius));",null);
    }

	protected void cacheObj() {
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("this.$$$jsObj=Bullet.wrapPointer(this.$$$cPointer,Bullet.btSphereShape);",this);
	}

    @Override
    protected void delete() {
		long addr = cPointer;
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("var vec=Bullet.wrapPointer(addr,Bullet.btSphereShape);Bullet.destroy(vec);",this);
    }

    public float getRadius() {
		checkPointer();
		return com.dragome.commons.javascript.ScriptHelper.evalFloat("this.$$$jsObj.getRadius();",this);
    }

    public void setUnscaledRadius(float radius) {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("this.$$$jsObj.setUnscaledRadius(radius);",this);
    }

    public void setMargin(float margin) {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("this.$$$jsObj.setMargin(margin);",this);
    }

    public float getMargin() {
		checkPointer();
		return com.dragome.commons.javascript.ScriptHelper.evalFloat("this.$$$jsObj.getMargin();",this);
    }
}
