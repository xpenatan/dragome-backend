/*******************************************************************************
 * Copyright 2016 Natan Guilherme.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.badlogic.gdx.backends.dragome.js.typedarrays;

import com.dragome.commons.javascript.ScriptHelper;
import com.dragome.web.enhancers.jsdelegate.JsDelegateFactory;

/** @author xpenatan */
public interface Uint8Array extends ArrayBufferView {

	final int BYTES_PER_ELEMENT = 1;

	public static Uint8Array create (ArrayBuffer buffer) {
		ScriptHelper.put("buffer", buffer, null);
		Object instance = ScriptHelper.eval("new Uint8Array(buffer.node);", null);
		Uint8Array node = JsDelegateFactory.createFrom(instance, Uint8Array.class);
		return node;
	}

	public static Uint8Array create (ArrayBuffer buffer, int byteOffset) {
		ScriptHelper.put("buffer", buffer, null);
		ScriptHelper.put("byteOffset", byteOffset, null);
		Object instance = ScriptHelper.eval("new Uint8Array(buffer.node, byteOffset);", null);
		Uint8Array node = JsDelegateFactory.createFrom(instance, Uint8Array.class);
		return node;
	};

	public static Uint8Array create (ArrayBuffer buffer, int byteOffset, int length) {
		ScriptHelper.put("buffer", buffer, null);
		ScriptHelper.put("byteOffset", byteOffset, null);
		ScriptHelper.put("length", length, null);
		Object instance = ScriptHelper.eval("new Uint8Array(buffer.node, byteOffset, length);", null);
		Uint8Array node = JsDelegateFactory.createFrom(instance, Uint8Array.class);
		return node;
	};

	public static Uint8Array create (int length) {
		ScriptHelper.put("length", length, null);
		Object instance = ScriptHelper.eval("new Uint8Array(length);", null);
		Uint8Array node = JsDelegateFactory.createFrom(instance, Uint8Array.class);
		return node;
	};

	int getLength ();

	short get (int index);

	void set (int index, int value); // Dont work

	void set (Uint8Array array, int offset);

	void set (int[] array, int offset);

	void set (short[] array, int offset);

	Uint8Array subarray (int begin);

	Uint8Array subarray (int begin, int end);
}
