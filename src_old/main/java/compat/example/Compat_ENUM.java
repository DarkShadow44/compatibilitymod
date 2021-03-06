package compat.example;

public enum Compat_ENUM {

	VALUE(ENUM.VALUE);

	private ENUM original;

	private Compat_ENUM(ENUM original) {
		this.original = original;
	}

	public ENUM getReal() {
		return original;
	}

	public static Compat_ENUM getFake(ENUM real) {
		switch (real) {
		case VALUE:
			return VALUE;
		default:
			throw new RuntimeException("Unhandled " + real.name());
		}
	}

	public static Compat_ENUM Compat_get_VALUE() {
		return VALUE;
	}
}
