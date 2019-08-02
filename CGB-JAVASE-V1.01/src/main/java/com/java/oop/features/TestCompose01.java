package com.java.oop.features;
/*
 * 演示组合特效应用
 */
interface MailService{
	void sendMail(String msg);
}
final class DefaultMailService implements MailService{//发送mail
	public void sendMail(String msg) {
		System.out.println("send "+msg);
	}
}
//扩展对象业务对象
class LogDefaultMailService {
	//has a :MailService 有一个类型的属性出现在这个类里面 (藕合)
	private MailService mailService;//=new DefaultMailService();(赋值)
	//通过构造方法为属性初始化,赋值
	public LogDefaultMailService(MailService mailService) {
	   this.mailService=mailService;
	}
	public void sendMail(String msg) {
		System.out.println(System.nanoTime());
		mailService.sendMail(msg);
		System.out.println(System.nanoTime());
	}
}
/**演示组合特性应用*/
public class TestCompose01 {
    public static void main(String[] args) {
    	DefaultMailService defaultMailService = new DefaultMailService();
    	LogDefaultMailService mailService = new LogDefaultMailService(defaultMailService);
    	mailService.sendMail("祝贺CGB1903班高薪就业");
	}
}




