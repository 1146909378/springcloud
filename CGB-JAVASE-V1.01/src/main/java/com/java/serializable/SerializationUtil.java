package com.java.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

public class SerializationUtil {
	//序列化
	public static <T extends Serializable>void 
	    doSerialization(T obj,String file) 
	    throws FileNotFoundException, IOException {
		OutputStream os = new FileOutputStream(file);
		Hessian2Output out = new Hessian2Output(os);
		out.writeObject(obj);
		out.flush();
		os.close();
	}	
	//反序列化
	@SuppressWarnings("unchecked")
	public static <T>T doDeserialization(String file)
		throws FileNotFoundException, IOException {
		//上面<T>T表示:<类型>返回值
		InputStream is = new FileInputStream(file);
		Hessian2Input in = new Hessian2Input(is);
		T t =(T)in.readObject();
		is.close();
		return t;
	}
}



