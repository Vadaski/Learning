package ThreadDemo;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class test3 implements Runnable{
	int start;
	int end;
	private String url;
	private static ArrayList<Xclient> list = new ArrayList<Xclient>();
	public test3(int start,int end) {
		this.start = start;
		this.end = end;
		url = "http://xclient.info/s";
	}
	public void run() {
			for(int i =start;i<=end;i++) {
				try {
					getPage(i);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
	
	static synchronized void Add(Element element) throws InterruptedException {
		list.add(new Xclient(element.attr("title")));
		Thread.sleep(5);
	}
	
	public void getPage(int PageNumber) throws Exception {
		String url = this.url+"/"+PageNumber+"/";
		System.out.println("正在解析..."+url);
		Document document = Jsoup.connect(url).get();
		Elements elements = document.select(".post_list");
		for (Element element : elements) {
				//System.out.println(element);
				Elements elements2 = element.getElementsByTag("a");
				for (Element element2 : elements2) {
	//				System.out.println(element2.attr("title"));
	//				list.add(new Xclient(element2.attr("title")));
					Add(element2);
				}
		}
	}
	public static void main(String[] args) {
		try {
			Thread t1 = new Thread(new test3(1, 10));
			Thread t2 = new Thread(new test3(11, 20));
			Thread t3 = new Thread(new test3(21, 30));
			Thread t4 = new Thread(new test3(31, 41));	
			t1.start();
			t2.start();
			t3.start();
			t4.start();
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			for (Xclient xclient : list) {
				System.out.println(xclient.getName());
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
}

class Xclient{
	String name;
	public Xclient(String name) {
	this.name = name;
	}
	public String getName() {
		return name;
	}
}