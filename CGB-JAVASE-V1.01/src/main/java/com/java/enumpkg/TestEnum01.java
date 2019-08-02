package com.java.enumpkg;
enum Gender{//性別 public static final默认修饰词__+变量
			//编译完成会生成Gender.class文件
	//定义三个枚举实例
	MALE,FEMALE,NONE;
	private Gender() {
		System.out.println("Gender()");
	}
	
}
class Product{
	//性别要求
	Gender gender = Gender.NONE;
	public void setGender(Gender gender) {
		this.gender =gender;
	}
}
public class TestEnum01 {
	public static void main(String[] args) {
		//1.获取枚举类中的所有实例
		Gender[] genders = Gender.values();
		for (Gender d : genders) {
			System.out.println(d);
		}
		//2.为Product对象的gender属性赋值
		String genderStr= "MALE";
		Product pro = new Product();
		//将字符串转化为枚举类型的对象
		pro.gender = Gender.valueOf(genderStr);
		System.out.println(pro.gender);
	}
}
