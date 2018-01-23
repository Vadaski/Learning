package LearningTest.Learn;

import ThreadDemo.test1;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        test1 t1 = new test1("wang");
        test1 t2 = new test1("li");
        new Thread(t1).start();
        new Thread(t2).start();
    }
}
