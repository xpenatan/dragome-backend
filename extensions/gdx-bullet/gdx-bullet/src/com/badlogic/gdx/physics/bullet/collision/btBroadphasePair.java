package com.badlogic.gdx.physics.bullet.collision;

import com.badlogic.gdx.physics.bullet.BulletBase;

/** @author xpenatan */
public class btBroadphasePair extends BulletBase {

	/*JNI
		#include <src/bullet/BulletCollision/BroadphaseCollision/btBroadphaseProxy.h>
	*/
	btCollisionAlgorithm tmp = new btCollisionAlgorithm(0, false);
	
	public btBroadphasePair(long cPtr, boolean cMemoryOwn) {
		resetObj(cPtr, cMemoryOwn);
	}
	
	/*[0;X;F;L]
		protected void cacheObj() {
			addr, this.cPointer #P
			this.jsObj = Bullet.wrapPointer(addr, Bullet.btBroadphasePair); #EVAL
		}
	*/
	
	public btCollisionAlgorithm getAlgorithm() {
		long addr = getAlgorithm(cPointer);
		if(addr == 0) return null;
		tmp.resetObj(addr, false);
		return tmp;
	}
	/*[0;X;L]
		checkPointer();  #J
		jsObj, this.jsObj #P
		long addr = Bullet.getPointer(jsObj.get_m_algorithm()); #EVALLONG
		if(addr == 0) return null; #J
		tmp.resetObj(addr, false); #J
		return tmp; #J
	*/
	
	private static native long getAlgorithm(long addr); /*
		btBroadphasePair * pair = (btBroadphasePair *)addr;
		return (jlong)pair->m_algorithm;
	*/
	/*[0;X;D]*/
}
