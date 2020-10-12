package text;

import java.util.*;

public class TextThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        new Thread(new T1()).start();
        new T2().start();
        System.out.println(Thread.currentThread().getName());
        new Thread(()->{

        });
    }
}
class T1  implements Runnable{
    @Override
    public void run() {

        try {
            Thread.sleep(1000);
            System.out.println("---T1 Runnable---");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
   synchronized public void sale(){ }
}
class T2 extends Thread{
    @Override
    public void run() {
        Set set=new HashSet();
        set.add("22");
        set.add("22");
        set.add("122");
        set.add(true);
        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("set"+set.size());
        super.run();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---T2 Thread---");
    }
}
