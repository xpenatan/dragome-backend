/*-------------------------------------------------------
 * This file was automatically generated by XpeCodeGen
 *
 * Dont make changes to this file
 *-------------------------------------------------------*/
package com.badlogic.gdx.physics.bullet.collision;

import java.util.Iterator;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.BulletBase;
import com.badlogic.gdx.physics.bullet.linearmath.btIDebugDraw;
import com.badlogic.gdx.physics.bullet.linearmath.btVector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.LongMap;

/** @author xpenatan */
public class btCollisionWorld extends BulletBase {

    /** Use only for iterating. Don't use it for adding or removing bodies. */
    public final LongMap<btCollisionObject> bodies = new LongMap<btCollisionObject>(100);

    protected btBroadphaseInterface broadphasePairCache;

    protected btDispatcher dispatcher;

    private btIDebugDraw debugDrawer;

    private btDispatcherInfo dispInfo = new btDispatcherInfo(0, false);

    public btCollisionWorld() {
    }

    public btCollisionWorld(btDispatcher dispatcher, btBroadphaseInterface broadphasePairCache, btCollisionConfiguration collisionConfiguration) {
        this.broadphasePairCache = broadphasePairCache;
        this.dispatcher = dispatcher;
        resetObj(createNative(dispatcher.cPointer, broadphasePairCache.cPointer, collisionConfiguration.cPointer), true);
    }

    private static long createNative(long dispatcherAddr, long broadphaseAddr, long collConfAddr) {
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("var dispatch=Bullet.wrapPointer(dispatcherAddr,Bullet.btDispatcher);var cache=Bullet.wrapPointer(broadphaseAddr,Bullet.broadphasePairCache);var colConfig=Bullet.wrapPointer(collConfAddr,Bullet.btCollisionConfiguration);var cobj=new Bullet.btCollisionWorld(dispatch,cache,colConfig);",null);
		return com.dragome.commons.javascript.ScriptHelper.evalLong("Bullet.getPointer(cobj);",null);
    }

	protected void cacheObj() {
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("this.$$$jsObj=Bullet.wrapPointer(this.$$$cPointer,Bullet.btCollisionWorld);",this);
	}

    @Override
    protected void delete() {
		bodies.clear();
		long addr = cPointer;
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("var cobj=Bullet.wrapPointer(addr,Bullet.btCollisionWorld);Bullet.destroy(cobj);",this);
    }

    protected final void addBody(btCollisionObject body) {
        bodies.put(body.cPointer, body);
        body.world = this;
    }

    protected final void removeBody(btCollisionObject body) {
        body.world = null;
        bodies.remove(body.cPointer);
    }

    /** Copy collision objects to array*/
    public void getBodies(Array<btCollisionObject> bodies) {
        checkPointer();
        bodies.clear();
        bodies.ensureCapacity(this.bodies.size);
        for (Iterator<btCollisionObject> iter = this.bodies.values(); iter.hasNext(); ) {
            bodies.add(iter.next());
        }
    }

    public void setBroadphase(btBroadphaseInterface pairCache) {
		checkPointer();
		broadphasePairCache = pairCache;
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("this.$$$jsObj.setBroadphase(pairCache.$$$jsObj);",this);
    }

    public btBroadphaseInterface getBroadphase() {
        checkPointer();
        return broadphasePairCache;
    }

    public btOverlappingPairCache getPairCache() {
        checkPointer();
        return broadphasePairCache.getOverlappingPairCache();
    }

    public btDispatcher getDispatcher() {
        checkPointer();
        return dispatcher;
    }

    public void updateSingleAabb(btCollisionObject obj) {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("this.$$$jsObj.updateSingleAabb(obj.$$$jsObj);",this);
    }

    public void updateAabbs() {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("this.$$$jsObj.updateAabbs();",this);
    }

    public void computeOverlappingPairs() {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("this.$$$jsObj.computeOverlappingPairs();",this);
    }

    public void setDebugDrawer(btIDebugDraw debugDrawer) {
		checkPointer();
		this.debugDrawer = debugDrawer;
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("this.$$$jsObj.setDebugDrawer(debugDrawer.$$$jsObj);",this);
    }

    public btIDebugDraw getDebugDrawer() {
        checkPointer();
        return this.debugDrawer;
    }

    public void debugDrawWorld() {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("this.$$$jsObj.debugDrawWorld();",this);
    }

    public void debugDrawObject(Matrix4 worldTransform, btCollisionShape shape, Vector3 color) {
        checkPointer();
    //TODO need impl
    }

    public int getNumCollisionObjects() {
        return bodies.size;
    }

    public void rayTest(Vector3 rayFromWorld, Vector3 rayToWorld, RayResultCallback resultCallback) {
		checkPointer();
		Object vec1 = com.badlogic.gdx.physics.bullet.linearmath.btVector3.btVector3_1.jsObj;
		Object vec2 = com.badlogic.gdx.physics.bullet.linearmath.btVector3.btVector3_2.jsObj;
		float x1 = rayFromWorld.x;
		float y1 = rayFromWorld.y;
		float z1 = rayFromWorld.z;
		float x2 = rayToWorld.x;
		float y2 = rayToWorld.y;
		float z2 = rayToWorld.z;
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("vec1.setValue(x1,y1,z1);vec2.setValue(x2,y2,z2);this.$$$jsObj.rayTest(vec1,vec2,resultCallback.$$$jsObj);",this);
    }

    public void addCollisionObject(btCollisionObject collisionObject) {
		checkPointer();
		addBody(collisionObject);
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("this.$$$jsObj.addCollisionObject(collisionObject.$$$jsObj);",this);
    }

    public void addCollisionObject(btCollisionObject collisionObject, short collisionFilterGroup) {
		checkPointer();
		addBody(collisionObject);
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("this.$$$jsObj.addCollisionObject(collisionObject.$$$jsObj,collisionFilterGroup);",this);
    }

    public void addCollisionObject(btCollisionObject collisionObject, short collisionFilterGroup, short collisionFilterMask) {
		checkPointer();
		addBody(collisionObject);
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("this.$$$jsObj.addCollisionObject(collisionObject.$$$jsObj,collisionFilterGroup,collisionFilterMask);",this);
    }

    public void removeCollisionObject(btCollisionObject collisionObject) {
		checkPointer();
		removeBody(collisionObject);
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("this.$$$jsObj.removeCollisionObject(collisionObject.$$$jsObj);",this);
    }

    public void performDiscreteCollisionDetection() {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("this.$$$jsObj.performDiscreteCollisionDetection();",this);
    }

    public btDispatcherInfo getDispatchInfo() {
        checkPointer();
        if (dispInfo.cPointer == 0) {
            dispInfo.resetObj(getDispatchInfo(cPointer), false);
        }
        return dispInfo;
    }

    private long getDispatchInfo(long addr) {
		return com.dragome.commons.javascript.ScriptHelper.evalLong("Bullet.getPointer(this.$$$jsObj.getDispatchInfo());",this);
    }

    public boolean getForceUpdateAllAabbs() {
		checkPointer();
		return com.dragome.commons.javascript.ScriptHelper.evalBoolean("this.$$$jsObj.getForceUpdateAllAabbs();",this);
    }

    public void setForceUpdateAllAabbs(boolean value) {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("this.$$$jsObj.setForceUpdateAllAabbs(value);",this);
    }
}
