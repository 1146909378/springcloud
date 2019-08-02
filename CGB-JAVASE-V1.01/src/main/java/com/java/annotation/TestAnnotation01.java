package com.java.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
//@Target指定注解可描述的对象类型
//@Retention指定注解何时有效
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)//表示只能描述类
@interface Entity{//编译:生成Entity.class
	//定义value属性
	String value() default "";
}
//表示只能描述属性/方法
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@interface ID{

} 
//应用注解(使用注解描述类及成员)
@Entity("msg")//value="msg"
class Message{
	@ID private Integer id;
	@Override
	public String toString() {
		return "Message [id=" + id + "]";
	}
}

public class TestAnnotation01 {
	public static void main(String[] args) 
			throws Exception, SecurityException {
		//1.通过反射获取Message对象上Entity注解
		Class<Message> cls = Message.class;
		Entity entity = cls.getAnnotation(Entity.class);
		//2.通过反射获取Entity注解中value属性的值
		String value = entity.value();
		System.out.println(value);
		//3.获取Message中的id属性
		Field f = cls.getDeclaredField("id");
		ID id = f.getAnnotation(ID.class);
		//4.为message对象实例的id属性赋值
		Message msg = new Message();
		if (id!=null) {
			//设置属性可访问(因为属性私有)
			f.setAccessible(true);
			//为msg对象的f属性赋值
			f.set(msg, 100);
		}
		System.out.println(msg);
	}
}
