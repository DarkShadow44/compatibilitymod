package compat.sandbox.net.minecraftforge.fluids;

import net.minecraftforge.fluids.FluidRegistry;

public class Compat_FluidRegistry {
	public static boolean Compat_registerFluid(Compat_Fluid fluid) {
		return FluidRegistry.registerFluid(fluid.getReal());
	}
}
