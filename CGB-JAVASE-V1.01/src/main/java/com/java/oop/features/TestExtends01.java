package com.java.oop.features;
//定义一个搜索业务对象
class DefaultSearchService{
	public Object search(String key) {
		//System.out.println(System.nanoTime());
		System.out.println("search ..");
		String result="search result by "+key;
		//System.out.println(System.nanoTime());
		return result;
	}
}
//搜索业务扩展(基于OCP原则):日志业务对象
class LogDefaultSearchService extends DefaultSearchService{
	@Override
	public Object search(String key) {
		System.out.println(System.nanoTime());
		Object result=super.search(key);
		System.out.println(System.nanoTime());
		return result;
	}
}
//新需求:如何在不修改DefaultSearchService类
//的情况下,实现对search方法的日志记录.
public class TestExtends01 {
   public static void main(String[] args) {
	   DefaultSearchService ds=
	   //new DefaultSearchService();
	   new LogDefaultSearchService();
	   ds.search("cgb1903");
   }
}




