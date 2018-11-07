package com.example.training;

import java.util.Timer;
import java.util.TimerTask;

class MyTask extends TimerTask{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("您该起床了!!!!");
	}

}

public class TimerDemo {
	public static void main(String[] args) {
		//创建定时器对象
		Timer t = new Timer();
		//在3秒后执行MyTask类中的run方法
		t.schedule(new MyTask(), 3000);
	}
}
