package com.fuzw.study.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderP extends ClassLoader {

	public ClassLoaderP() {

	}

	public ClassLoaderP(ClassLoader parent) {
		super(parent);
	}

	/**
	 * 获取.class文件的字节数组
	 * 
	 * @param name
	 * @return
	 */
	private byte[] loaderClassData(String name) {
		InputStream is = null;
		byte[] data = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		name = name.replace(".", "/");
		try {
			is = new FileInputStream(new File("/Users/fuzuwen/" + name + ".class"));
			int c = 0;
			while (-1 != (c = is.read())) {
				baos.write(c);
			}
			data = baos.toByteArray();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data;
	}

	/**
	 * 获取Class对象
	 */
	@Override
	public Class<?> findClass(String name) {
		byte[] data = loaderClassData(name);
		return this.defineClass(name, data, 0, data.length);
	}

}
