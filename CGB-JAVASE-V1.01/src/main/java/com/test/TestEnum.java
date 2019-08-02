package com.test;


enum Color{
	RED("红"),YELLOW("黄"),BLUE("蓝"),
	WHITE("白"),GREEN("绿"),BLACK("黑");
	private String name;
	private Color(String name) {
		this.name = name;
	}
	public String getName(){
		return name;
	}
}
class Costume{
	 Color shirt = Color.WHITE;
	 Color jacket = Color.BLACK;
}

public class TestEnum {
	public static void main(String[] args) {
		//获取Color类的元素
		Color[] values = Color.values();
		for (Color color : values) {
			System.out.println(color);
		}
		//获取元素后的参数
		Class<Color> cl = Color.class;
		Costume ct = new Costume();
		System.out.println(ct.shirt.getName());
		//得到Color对象
		Class<? extends Color> class1 = ct.jacket.getClass();
		System.out.println(class1.getName());
		
	}
}
