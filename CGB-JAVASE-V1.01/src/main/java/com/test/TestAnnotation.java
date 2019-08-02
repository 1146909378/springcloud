package com.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
//表示只能描述属性/方法
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@interface ID{} 

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Singer{
	String value() default "";
}
@Singer("歌手")
class Student{
	@ID private String name = "唐唐";
	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}

}

public class TestAnnotation {
	public static void main(String[] args) throws Exception, SecurityException {
		//获取Singer元素的value()
		Class<Student> s = Student.class;
		Singer an = s.getAnnotation(Singer.class);
		System.out.println(an);
		String va = an.value();
		System.out.println(va);
		//通过反射给私有属性的name赋值
		Field f = s.getDeclaredField("name");
		ID id = f.getAnnotation(ID.class);
		Student su = new Student();
		if (id!=null) {
			f.setAccessible(true);
			f.set(su, "可可");
		}
		System.out.println(su);
	}
}
