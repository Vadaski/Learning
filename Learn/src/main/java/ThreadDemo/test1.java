package ThreadDemo;

public class test1 implements Runnable {
	
	private String name;
	public test1(String name) {
		this.name = name;
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("第"+i+"次输出："+name);	
			try {
				
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().isAlive());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().isAlive());
		
	}

}
