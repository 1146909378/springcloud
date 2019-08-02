package com.java.serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class TestSerializable02 {
   public static void main(String[] args)throws Exception {
	   //1.构建日志对象
	   Message msg=new Message();
	   msg.setId(100);
	   msg.setTitle("cgb");
	   msg.setContent("cgb1903");
	   msg.setCreatedTime("2019-05-28");
	   //2.将对象序列化到文件
       ObjectOutputStream out= 
       new ObjectOutputStream( new
       FileOutputStream("f2.dat"));
       out.writeObject(msg);
       out.close();
       System.out.println("序列化ok");
   //3.将对象从文件反序列化.
	   ObjectInputStream in=new ObjectInputStream(
       new FileInputStream("f2.dat"));
	   Object msg2=in.readObject();
	   System.out.println(msg2);
	   in.close();
   }
}











