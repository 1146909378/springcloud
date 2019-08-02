package com.test;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.junit.Test;

public class TestTomcat {
	//通过如下方法启动Tomcat
	@Test
	public void testTomcat() throws Exception {
		//1.构建tomcat对象
		Tomcat t = new Tomcat();
		//2.构建Connector对象(连接器)
		Connector conn = new Connector("HTTP/1.1");
		conn.setPort(80);
		t.getService().addConnector(conn);
		//3.启动tomcat
		t.start();
		//4.阻塞当前线程
		t.getServer().await();
		
	}

}
