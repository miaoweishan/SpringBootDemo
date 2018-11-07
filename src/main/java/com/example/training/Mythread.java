package com.example.training;



/*
 * Runnable和Thread实现多线程的区别
 */
//public class Mythread extends Thread{
//	private int ticket = 5;
//	
//	public void run() {
//		for(int i=0;i<10;i++) {
//			if(ticket>0) {
//				System.out.println("ticket= "+ticket--);
//			}
//		}
//	}
//	
//	public static void main(String[] args) {
//		new Mythread().start();
//		new Mythread().start();
//		new Mythread().start();
//	}
//
//}


public class Mythread implements Runnable {
	private int ticket = 5;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			if(ticket>0) {
				System.out.println("ticket= "+ticket--);
			}
		}
	}
	
	public static void main(String[] args) {
		Mythread my1 = new Mythread();
//		Mythread my2 = new Mythread();
//		Mythread my3 = new Mythread();
		new Thread(my1).start();
		new Thread(my1).start();
		new Thread(my1).start();
	}

} 


