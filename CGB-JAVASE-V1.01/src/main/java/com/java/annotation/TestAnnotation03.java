package com.java.annotation;

import java.io.File;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.URL;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface ComponentScan{
	String value();
}
@ComponentScan("com.java.annotation")
class AppConfig{}
public class TestAnnotation03 {
	public static void main(String[] args) {
		//1.获取字节码对象
		Class<?> cls = AppConfig.class;
		//2.获取ComponentScan注解对象
		ComponentScan cs 
		= cls.getAnnotation(ComponentScan.class);
		//3.获取ComponentScan注解value属性的值
		String pkg = cs.value();
		//4.获取指定包中所有类
		//4.1将包结果转换为路径(相对路径)
		String pkgPath = pkg.replace(".", "/");
		//4.2获取相对路径对应的绝对路径
		URL url 
		= ClassLoader.getSystemResource(pkgPath);
		String classFilePath = url.getPath();
		//4.3获取绝对路径中的文件,并输出其名字
		File file = new File(classFilePath);
		File[] classes = file.listFiles();
		for (File fc : classes) {
			System.out.println(fc.getName());
		}
			
		}
}
