import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

/***
 * 主线程----守护线程
 */
class DaemonThread implements Runnable{
    @Override
    public void run() {
        System.out.println("进入守护线程"+Thread.currentThread().getName());
        try {
            writeToFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("已退出守护线程"+Thread.currentThread().getName());
    }

    private void writeToFile() throws Exception{
        File filename=new File("d:"+File.separator+"daemon.txt");
        OutputStream os=new FileOutputStream(filename,true);
        int cnt=0;
        while (cnt<999){
//            写入的字符串是“word”加上一个数字
            os.write(("\r\nword"+cnt).getBytes());
            System.out.println("守护线程"+Thread.currentThread().getName()+"向文件中写入了word"+(cnt++));
            Thread.sleep(1000);
        }
    }
}
public class App {
    public static void main(String[] args) {
        System.out.println("程序进入主线程"+Thread.currentThread().getName());
        //创建线程
        DaemonThread daemonThread=new DaemonThread();
        Thread th=new Thread(daemonThread);
//        设置为守护线程
        th.setDaemon(true);
        th.start();

        //阻塞
        Scanner sc=new Scanner(System.in);
        sc.next();


        System.out.println("已退出主线程"+Thread.currentThread().getName());
    }
}
