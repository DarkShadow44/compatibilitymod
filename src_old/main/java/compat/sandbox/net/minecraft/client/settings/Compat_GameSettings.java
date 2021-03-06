package compat.sandbox.net.minecraft.client.settings;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;

public class Compat_GameSettings {
	private final GameSettings original;

	public Compat_GameSettings(GameSettings original) {
		this.original = original;
	}

	public Compat_KeyBinding Compat_get_field_74314_A() {
		return new Compat_KeyBinding(original.keyBindJump);
	}

	public Compat_KeyBinding[] Compat_get_field_151456_ac() {
		List<Compat_KeyBinding> keyBindings = new ArrayList<>();

		for (KeyBinding key : original.keyBindsHotbar) {
			keyBindings.add(new Compat_KeyBinding(key));
		}
		return keyBindings.toArray(new Compat_KeyBinding[0]);
	}

	public Compat_KeyBinding Compat_get_field_74312_F() {
		return new Compat_KeyBinding(original.keyBindAttack);
	}

	public Compat_KeyBinding Compat_get_field_74313_G() {
		return new Compat_KeyBinding(original.keyBindUseItem);
	}

	public boolean Compat_get_field_74330_P() {
		return original.showDebugInfo;
	}

	public float Compat_get_field_74341_c() {
		return original.mouseSensitivity;
	}

	public void Compat_set_field_74341_c(float value) {
		original.mouseSensitivity = value;
	}

	public int Compat_get_field_74362_aa() {
		return original.particleSetting;
	}
}
