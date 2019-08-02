package com.java.jvm;
import java.util.ArrayList;
import java.util.List;
/**JVM内存大小配置:
 * 最大堆内存:-Xmx5m
 * 最小堆内存:-Xms5m
 */
//java.lang.OutOfMemoryError: Java heap space
public class TestMemory01 {
	   public static void main(String[] args) {
			List<byte[]> list=new ArrayList<>();
			for(int i=0;i<10;i++) {
			 list.add(new byte[1024*1024]);
			}
	   }
}
