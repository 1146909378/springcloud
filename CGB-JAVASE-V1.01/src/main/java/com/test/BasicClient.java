package com.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

class BasicImpl implements Serializable{
	private Integer id;
	private String name;

    @Override
	public String toString() {
		return "BasicImpl [id=" + id + ", name=" + name + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String sayHello(String name) {
        return "This is Hello words from HESSIAN Server. " + name;
    }
    
    
}

public class BasicClient {
    public static void main(String[] args) throws Exception {
    	BasicImpl bs = new BasicImpl();
    	bs.setId(100);
    	bs.setName("唐三");
    	//序列化
    	OutputStream os = new FileOutputStream("test.xml");
    	Hessian2Output out = new Hessian2Output(os);
    	out.writeObject(bs);
    	System.out.println("序列化ok");
    	out.flush();
    	os.close();
    	//反序列化
    	FileInputStream is = new FileInputStream("test.xml");
    	Hessian2Input in = new Hessian2Input(is);
    	BasicImpl obj = (BasicImpl) in.readObject();
    	is.close();
    	System.out.println(obj);
    }
}