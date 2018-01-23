package ThreadDemo;


public class test2 implements Runnable {
	private String name;
	Thread thread;
	public test2(String name) {
	this.name = name;
	thread = new Thread(this);
	}
	public void run() {for (int i = 0; i < 100; i++) {
		synchronized (this) {
			System.out.println(name+":"+(int)(Math.random()*100));
			thread.yield();
		}
	}
		
	}
	public static void main(String[] args) {
		test2 t1 = new test2("T1");
		test2 t2 = new test2("T2");
		new Thread(t1).start();
		new Thread(t1).start();
	}

}
