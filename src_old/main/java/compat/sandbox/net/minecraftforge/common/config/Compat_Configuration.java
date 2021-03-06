package compat.sandbox.net.minecraftforge.common.config;

import java.io.File;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraftforge.common.config.Configuration;

public class Compat_Configuration {
	private CompatI_Configuration wrapper;

	// When called from Mod
	public Compat_Configuration(File file) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Configuration.class, this, file));
	}

	// When called from child
	protected Compat_Configuration(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Configuration(Configuration original) {
		this.initialize(Factory.createWrapper(CompatI_Configuration.class, original));
	}

	protected void initialize(CompatI_Configuration wrapper) {
		this.wrapper = wrapper;
	}

	public Configuration getReal() {
		return wrapper.get();
	}

	public void Compat_load() {
		wrapper.loadSuper();
	}

	public void Compat_save() {
		wrapper.saveSuper();
	}

	public int Compat_getInt(String name, String category, int standard, int min, int max, String comment) {
		return wrapper.getIntSuper(name, category, standard, min, max, comment);
	}

	public boolean Compat_getBoolean(String name, String category, boolean standard, String comment) {
		return wrapper.getBooleanSuper(name, category, standard, comment);
	}

	public Compat_Property Compat_get(String category, String key, boolean defaultValue) {
		return new Compat_Property(wrapper.getSuper(category, key, defaultValue));
	}

	public Compat_Property Compat_get(String category, String key, int defaultValue) {
		return new Compat_Property(wrapper.getSuper(category, key, defaultValue));
	}

	public Compat_Property Compat_get(String category, String key, String[] defaultValues) {
		return new Compat_Property(wrapper.getSuper(category, key, defaultValues));
	}

	public Compat_Property Compat_get(String category, String key, double defaultValue) {
		return new Compat_Property(wrapper.getSuper(category, key, defaultValue));
	}

	public boolean Compat_hasChanged() {
		return wrapper.hasChangedSuper();
	}

	public Compat_Property Compat_get(String category, String key, String defaultValue) {
		return new Compat_Property(wrapper.getSuper(category, key, defaultValue));
	}

	public Compat_ConfigCategory Compat_getCategory(String category) {
		return new Compat_ConfigCategory(wrapper.getCategorySuper(category));
	}

	public boolean Compat_hasCategory(String category) {
		return wrapper.hasCategorySuper(category);
	}

	public boolean Compat_hasKey(String category, String key) {
		return wrapper.hasKeySuper(category, key);
	}

}
