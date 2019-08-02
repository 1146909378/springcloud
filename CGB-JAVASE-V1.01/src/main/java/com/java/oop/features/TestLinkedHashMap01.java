package com.java.oop.features;
import java.util.LinkedHashMap;
/**
 * LinkedHashMap 是一个特殊的HashMap,只是
 * 在hashmap的基础之上添加了一个链表
 * 1)记录元素添加顺序(默认)
 * 2)记录元素的访问顺序
 */
public class TestLinkedHashMap01 {
	public static void main(String[] args) {
		LinkedHashMap<String,Object> map=
	    //new LinkedHashMap<String, Object>();
		new LinkedHashMap<String, Object>(3,0.75f,true);
		map.put("A", 100);
		map.put("D", 200);
		map.put("C", 300);
		map.put("B", 400);
		map.get("D");
		map.get("A");//最新新访问的
		//{C=300, B=400, D=200, A=100}//越靠近左边数据越旧
		System.out.println(map);
	}
}




