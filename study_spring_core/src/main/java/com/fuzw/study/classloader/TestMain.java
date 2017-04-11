package com.fuzw.study.classloader;

public class TestMain {

	public static void main(String[] args) {
		
		try {
			
			
//			byte a = 2;
//			byte b = 1;
//			byte c = a + b;
//			
//			char d = 12;
//			char e = 1;
//			char f = d + e;
//			
//			short s1 = 1;
//			short s2 = 2;
//			short s3 = s1 + s2;
			
			int i = 0, j = 0;
			int c = 1==2 ? i++ : j++;
			
			
			ClassLoader p1 = new ClassLoaderP();
			
			ClassLoader p2 = new ClassLoaderP();
			
			ClassLoader s = new ClassLoaderS(p1);
						
//			Class ca2 = p1.loadClass("com.fuzw.study.classloader.ClassA");
//			
//			Class ca3 = s.loadClass("com.fuzw.study.classloader.ClassA");
//			
//			Class ca4 = p2.loadClass("com.fuzw.study.classloader.ClassA");
//			
//			Field f = ca2.getDeclaredField("A");
//			
//			System.out.println(f.get(null));
//			
//			Class ca = ClassAA.class;
//			
//			System.out.println(ca3 == ca2);
//			
//			System.out.println(ca4 == ca2);
			
			Class sc = p1.loadClass("com.fuzw.study.classloader.Say");
			
			ISay sobj = (ISay) sc.newInstance();
			
			System.out.println(ISay.class.getClassLoader());
			
			System.out.println(sc.getClass().getClassLoader());
			
			System.out.println(sobj.getClass().getClassLoader());
			
			System.out.println(sobj.say());

			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
