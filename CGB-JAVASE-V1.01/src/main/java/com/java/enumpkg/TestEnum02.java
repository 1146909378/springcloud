package com.java.enumpkg;
enum Sex{//Sex.class
	MALE("男"),FEMALE("女");//有参构造时要加("男")/("女")
	private String name;
	private Sex(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
}
class Member{
	Sex sex = Sex.MALE;
	Sex sex1 = Sex.FEMALE;
}

public class TestEnum02 {
	public static void main(String[] args) {
		Member m = new Member();
		String name = m.sex.getName();
		System.out.println(name);
		//将字符串转换为指定的枚举类型对象
//		m.sex1 = Enum.valueOf(Sex.class,"MALE");
		m.sex = Enum.valueOf(Sex.class,"FEMALE");
		System.out.println(m.sex.getName());
	}
}
