package de.darkshadow44.compatibility.sandbox.v1_10_2.java.lang.reflect;

import java.lang.reflect.Field;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.client.model.pipeline.Compat_UnpackedBakedQuad;

public class Compat_Field {

	private final Field original;

	public Compat_Field(Field original) {
		this.original = original;
	}

	public void Compat_setAccessible(boolean accessible) {
		original.setAccessible(true);
	}

	public Object Compat_get(Object owner) throws Exception {
		if (owner instanceof Compat_UnpackedBakedQuad) {
			owner = ((Compat_UnpackedBakedQuad) owner).getReal();
		}
		return original.get(owner);
	}
}
