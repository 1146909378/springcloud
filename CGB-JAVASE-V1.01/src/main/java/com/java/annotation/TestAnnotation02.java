package com.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//1.定义Component注解
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@interface Component{} 
//2.定义service注解并使用Component注解修饰
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@Component
@interface Service{}
//说明:spring中的所有@Service,@Conponent等
//都是一个@Component
public class TestAnnotation02 {
	public static void main(String[] args) {
		//1.获取service注解
		Class<?> cls = Service.class;
		//2.判断Service注解上是否有Component修饰
		boolean flag 
		= cls.isAnnotationPresent(Component.class);
		System.out.println(flag);
	}
}
