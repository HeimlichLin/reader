package com.reader.common.object;

import java.io.File;

public class FileLoader {
	/**
	 * 
	 * @param pClass
	 *            使用元件之物件
	 * @param file
	 * @return
	 */
	public static File getResourcesFile(Class<?> pClass, final String file) {
		final ClassLoader classLoader = pClass.getClassLoader();
		return new File(classLoader.getResource(file).getFile());
	}

}
