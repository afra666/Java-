class MyRunnable implements Runnable{
    int remainTickets=5;
    @Override
    public void run() {//3.运行状态
        while (remainTickets>0){
            remainTickets--;
            System.out.println(Thread.currentThread().getName()+"卖了一张票，剩余票数："+remainTickets);
        }
    }//4.终止状态
//    如果有sleep，将进入阻塞状态，让出线程
}

public class App{
    public static void main(String[] args) {
        MyRunnable mr=new MyRunnable();
        Thread mr1=new Thread(mr);//1.创建线程
        Thread mr2=new Thread(mr);
        Thread mr3=new Thread(mr);
        mr1.start();//2.就绪
        mr2.start();
        mr3.start();
    }
}

/*
Thread-0卖出一张票，剩余票数：4
Thread-1卖出一张票，剩余票数：3
Thread-2卖出一张票，剩余票数：2
Thread-1卖出一张票，剩余票数：0
Thread-0卖出一张票，剩余票数：1
* 
* */
