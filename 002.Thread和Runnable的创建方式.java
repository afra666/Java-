//1.Thread
public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("This is from MyThread......");
    }

    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        myThread.start();
    }
}

//2.Runnable
public class MyRun implements Runnable{
    @Override
    public void run() {
        System.out.println("this is from Runnable.....");
    }

    public static void main(String[] args) {
        Thread myRun=new Thread(new MyRun());
        myRun.start();
    }
}
