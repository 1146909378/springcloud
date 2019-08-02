package com.java.generic;
//定义一个任务接口
interface Task<Param,Result>{//Map<K,V> /这里定义一个泛型接口
	//Result 决定返回值类型
	//Param 决定参数类型
	Result execute(Param param);
}
//定义接口实现类(将字符串转换为整数)		//把实参传给接口的形参 
class ConvertTask implements Task<String,Integer>{
	@Override
	public Integer execute(String param) {
		//拆箱 
		return Integer.parseInt(param);
	}
}
//扩展点(将字符串转换为指定类型)						
					//这样写只是限定了String,而Result可以传值,现在不确定,等待传值
class TypeConvertTask<Result> implements Task<String,Result>{
	@Override
	public  Result execute(String param) {
		//可以借助反射技术对参数类型进行转换
		return null;
	}
}
public class TestGeneric03 {
    public static void main(String[] args) {
    	ConvertTask ct=new ConvertTask();
    	Integer result=ct.execute("100");
	    System.out.println(result);
    }
}




