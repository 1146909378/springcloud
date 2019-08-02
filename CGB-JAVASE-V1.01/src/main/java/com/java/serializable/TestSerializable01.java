package com.java.serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;
import java.util.Date;
/**
 * Serializable 接口只是一个标识性作用
 */
class SysLog implements Serializable{
	private static final long serialVersionUID = 2336511653242155338L;
	private Integer id;
	private String username;
	private Date createdTime;
	
	/**序列化时可以在writeObject方法中进行加密
	 * 当我们在外界调用ObjectOutputStream时的
	 *writeObject方法时,此方法会自动调用*/
	private void writeObject(ObjectOutputStream out)throws IOException {
		//1.获取加密对象Encoder
		Base64.Encoder encoder=Base64.getEncoder();
		//2.对内容进行加密(encode方法负责加密)
		byte[] array=
		encoder.encode(username.getBytes());
		username=new String(array);
		//3.对对象内容进行序列化
		out.defaultWriteObject();
	}
	//反序列化时自动执行此方法
	private void readObject(ObjectInputStream in)
			throws IOException, ClassNotFoundException{
		//1.执行默认反序列化
		in.defaultReadObject();
		//2.获取解密对象
		Base64.Decoder decoder=
		Base64.getDecoder();
		//3.执行解密操作
		byte[] array=decoder.decode(username);
		username=new String(array);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "SysLog [id=" + id + ", username=" + username + "]";
	}
	
}
public class TestSerializable01 {
   public static void main(String[] args)throws Exception {
	   //1.构建日志对象
	   SysLog log=new SysLog();
	   log.setId(100);
	   log.setUsername("admin");
	   //2.将对象序列化到文件
       ObjectOutputStream out= 
       new ObjectOutputStream( new
       FileOutputStream("f1.dat")); out.writeObject(log); out.close();
       System.out.println("序列化ok");
   //3.将对象从文件反序列化.
	   ObjectInputStream in=
       new ObjectInputStream(
       new FileInputStream("f1.dat"));
	   SysLog log2=(SysLog)in.readObject();
	   System.out.println(log2);
	   in.close();
   }
}











