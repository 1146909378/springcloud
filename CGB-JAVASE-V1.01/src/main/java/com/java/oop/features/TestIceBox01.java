package com.java.oop.features;
//思考一个实现一个业务功能
/**大象*/
class Elephant{
	private String name;
	private Integer weight;
	public Elephant(String name,Integer weight) {
	   this.name=name;
	   this.weight=weight;
	}
	public void say() {
		System.out.println("====say====");
	}
}
/**冰箱*/
class Fridge{
	private String code;
	private String brand;
	private Object object;
	public void open() {
	}
	public void put(Object object) {
		this.object=object;
	}
	public void close() {
	}
}
public class TestIceBox01 {
    public static void main(String[] args) {
		//1.构建大象对象
    	Elephant e1=new Elephant("太极",100);
    	//2.构建冰箱对象
    	Fridge f1=new Fridge();
    	//3.将大象放冰箱
    	f1.open();
    	f1.put(e1);
    	f1.close();
	}
}












