package compat.sandbox.net.minecraftforge.common.config;

import net.minecraftforge.common.config.Property;

public class Compat_Property {
	private final Property original;

	public Compat_Property(Property original) {
		this.original = original;
	}

	public boolean Compat_getBoolean(boolean _default) {
		return original.getBoolean(_default);
	}

	public int Compat_getInt() {
		return original.getInt();
	}

	public String[] Compat_getStringList() {
		return original.getStringList();
	}

	public double Compat_getDouble(double _default) {
		return original.getDouble(_default);
	}

	public boolean Compat_getBoolean() {
		return original.getBoolean();
	}

	public double Compat_getDouble() {
		return original.getDouble();
	}

	public String Compat_getString() {
		return original.getString();
	}

	public Compat_Property Compat_setRequiresMcRestart(boolean value) {
		original.setRequiresMcRestart(value);
		return this;
	}

	public void Compat_set_comment(String str) {
		original.setComment(str);
	}
}
