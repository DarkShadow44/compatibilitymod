package compat.sandbox.net.minecraft.util;

import net.minecraft.util.EnumFacing.Axis;

public enum Compat_EnumFacing_Axis {

	X(Axis.X),
	Y(Axis.Y),
	Z(Axis.Z);

	private Axis original;

	private Compat_EnumFacing_Axis(Axis original) {
		this.original = original;
	}

	public Axis getReal() {
		return original;
	}

	public static Compat_EnumFacing_Axis Compat_get_X() {
		return X;
	}

	public static Compat_EnumFacing_Axis Compat_get_Y() {
		return Y;
	}

	public static Compat_EnumFacing_Axis Compat_get_Z() {
		return Z;
	}

	static Compat_EnumFacing_Axis getFake(Axis real) {
		switch (real) {
		case X:
			return X;
		case Y:
			return Y;
		case Z:
			return Z;
		default:
			throw new RuntimeException();
		}
	}

	public int Compat_ordinal() {
		return original.ordinal();
	}
}
