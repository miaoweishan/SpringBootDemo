package com.example.training;
/*
 * 线程池s
 */
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExe {
	class Task implements Runnable{
		private String name;
		
		public Task(String name) {
			this.name = name;
		}
		
		public void run() {
			System.out.println("the "+ name + " task");
			
			try {
				//模拟线程需要执行的时间 
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void execute() {
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 6, 3, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(10),new ThreadPoolExecutor.DiscardPolicy());
		
		for(int i=0;i<20;i++) {
			Task task = new Task(""+i);
			threadPool.execute(task);
		}
	}
	
	public static void main(String[] args) {
		ThreadPoolExe t = new ThreadPoolExe();
		t.execute();
	}

}
