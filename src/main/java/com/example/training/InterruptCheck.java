package com.example.training;
/*
 * 待决中断
 */
//public class PendingInterrupt extends Object{
//	public static void main(String[] args) {
//		//如果输入了参数，则在mian线程中中断当前线程（亦即main线程
//		if(args.length==0) {
//			System.out.println("+++++++++1++++++++++");
//			Thread.currentThread().interrupt();		
//		}
//		//获取当前时间
//		long startTime = System.currentTimeMillis();
//		System.out.println("++++++++++"+startTime+"++++++++++");
//		try {
//			Thread.sleep(2000);
//			System.out.println("was NOT interrupted");
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			System.out.println("was interrupted");
//		}
//		//计算中间代码执行的时间
//		System.out.println("elapsedTime=" + ( System.currentTimeMillis() - startTime));
//	}
//
//}


//使用isInterrupted（）方法判断中断状态
//public class InterruptCheck extends Object {
//	public static void main(String[] args) {
//		Thread t = Thread.currentThread();
//		System.out.println("Point A: t.isInterrupted()=" + t.isInterrupted());
//		//待决中断，中断自身
//		t.interrupt();
//		System.out.println("Point B: t.isInterrupted()=" + t.isInterrupted());		
//		System.out.println("Point C: t.isInterrupted()=" + t.isInterrupted());
//		try {
//			Thread.sleep(2000);
//			System.out.println("was NOT interrupted");
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			System.out.println("was interrupted");
//		}
//		//抛出异常后，会清除中断标志，这里会返回false
//		System.out.println("Point D: t.isInterrupted()=" + t.isInterrupted());
//		
//	}
//}

	//使用Thread.interrupted（）方法判断中断状态
	public class InterruptCheck extends Object {
		public static void main(String[] args) {
			System.out.println("Point X: Thread.interrupted()=" + Thread.interrupted());
			Thread.currentThread().interrupt();
			System.out.println("Point Y: Thread.interrupted()=" + Thread.interrupted());		
			System.out.println("Point Z: Thread.interrupted()=" + Thread.interrupted());

		}
	}





