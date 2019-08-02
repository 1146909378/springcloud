package com.java.oop;
import java.util.HashMap;
import java.util.Map;
class ClassE{
	//查资料的一种方式:目的仿写:WebappClassLoder
	//static Map<String,Object> pool=new HashMap<>();
	//第一:调换顺序         第二:去掉Map前的static,打印加上instance
	static ClassE instance=new ClassE();//这里构造了类的实例,接着会加载构造方法
	Map<String,Object> pool=new HashMap<>();//实例初始化先于"构造方法加载"
	public ClassE() {
		pool.put("A", "100");//放到Map中:实质是放的一个地址
		pool.put("B", "200");
	}
}
//在main方法中区访问了ClassE的属性
public class TestClassObject05 {
    public static void main(String[] args) {
    	System.out.println(ClassE.instance.pool);
	}
}
