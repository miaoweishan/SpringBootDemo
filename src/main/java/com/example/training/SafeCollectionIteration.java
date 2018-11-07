package com.example.training;
/*
 * 安全遍历的方法
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SafeCollectionIteration extends Object{
	public static void main(String[] args) {
		//为了安全起见，仅使用同步列表的一个引用，这样可以确保控制了所有访问  
		//集合必须同步化，这里是一个List
		List wordList = Collections.synchronizedList(new ArrayList<>());
		
		//wordList中的add方法是同步方法，会获取wordList实例的对象锁
		wordList.add("Iterators");
		wordList.add("require");
		wordList.add("special");
		wordList.add("handling");
		
		synchronized (wordList) {
			Iterator iter = wordList.iterator();
			
			while(iter.hasNext()) {
				String s = (String) iter.next();
				System.out.println("found string: " + s + ", length=" + s.length());
			}
		}
	}

}
