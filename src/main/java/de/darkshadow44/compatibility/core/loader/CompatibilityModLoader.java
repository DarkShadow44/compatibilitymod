package de.darkshadow44.compatibility.core.loader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.lang3.ArrayUtils;

import de.darkshadow44.compatibility.core.CompatibilityMod;
import de.darkshadow44.compatibility.core.layer.CompatibilityLayer;

public class CompatibilityModLoader {

	private final CompatibilityLayer layer;

	public CompatibilityModLoader(CompatibilityLayer layer) {
		this.layer = layer;
	}

	public String[] getModFiles(File path) {
		List<String> files = new ArrayList<String>();

		for (File file : path.listFiles()) {
			if (file.isFile()) {
				String fileName = file.getPath().toLowerCase();
				if (fileName.endsWith(".zip") || fileName.endsWith(".jar"))
					files.add(file.getPath());
			}
		}
		return files.toArray(new String[0]);
	}

	byte[] readFileInZip(InputStream stream, ZipEntry entry) throws IOException {
		int length = (int) entry.getSize();

		byte[] data = new byte[length];
		int read = 0;
		while (read < length) {
			read += stream.read(data, read, length - read);
		}
		return data;
	}

	public byte[][] readZip(String path) {
		List<byte[]> classes = new ArrayList<byte[]>();

		ZipFile zipFile;
		try {
			zipFile = new ZipFile(path);

			Enumeration<? extends ZipEntry> entries = zipFile.entries();

			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();

				if (!entry.isDirectory()) {
					String nameLower = entry.getName().toLowerCase();
					InputStream stream = zipFile.getInputStream(entry);
					byte[] data = readFileInZip(stream, entry);
					stream.close();

					if (nameLower.endsWith(".class"))
						classes.add(data);

					layer.handleResource(nameLower, data);
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return classes.toArray(new byte[0][]);
	}

	public List<Class<?>> loadAllMods(File path) {
		String[] pathMods = getModFiles(path);

		// TODO Sort mods. HACK!
		ArrayUtils.reverse(pathMods);

		CompatibilityClassLoader loader = new CompatibilityClassLoader(layer, CompatibilityMod.classLoader);

		List<Class<?>> classesLoaded = new ArrayList<>();

		for (String pathMod : pathMods) {
			byte[][] classesBytes = readZip(pathMod);
			List<Class<?>> classes = loader.loadClasses(classesBytes);
			classesLoaded.addAll(classes);
		}

		return classesLoaded;
	}
}
