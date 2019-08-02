package com.java.oop.features;
import java.util.LinkedHashMap;
//构建基于LRU算法的缓存对象(简易)
//目的:缓存满了要淘汰长时间不访问的对象
class LruCache<K,V> extends LinkedHashMap<K,V>{//和put()相关 
	  LinkedHashMap<K,V> removeElements 
	  = new LinkedHashMap<K, V>();
	  private int maxCap;//记录最大容量
	  protected int c;
	  public int a;
	  int b;
	  //调用父类的构造方法
	  public LruCache(int cap) {
		  	 				//限制其扩容
		super((int)Math.ceil(cap/0.75f)+1,0.75f,true);//调用父类有参构造
	    this.maxCap=cap;
	  }
	  //当我们执行put方法时,每次都会调用此方法
	  //方法返回值为true时表示满了,此时可以移除数据
	  @Override
	  protected boolean removeEldestEntry(
		java.util.Map.Entry<K, V> eldest) { 
		boolean flag= size()>maxCap;//超出则移除 
		if(flag) {
			removeElements.put(eldest.getKey(), eldest.getValue());
		}
		return flag;
	  }
}
public class TestExtends02 {
   public static void main(String[] args) {
	   //泛型的另一种写法
	  LruCache<String,Object> cache = new LruCache<>(3);
      cache.put("A", 100);//当我们执行put方法时,每次都会调用此方法
      cache.put("B", 200);
      cache.put("C", 300);
      cache.put("D", 400);
      cache.put("E", 500);
      System.out.println("缓存的元素:"+cache);
      System.out.println("移除的元素:"+cache.removeElements);
   } 
   public String cry() {return null;}
   
}
