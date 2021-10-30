package tjpu.edu.multithreading;

/**
 * Created by Lwq on 2021/7/9 19:10
 */
class Window implements Runnable {
    
    private int ticket = 100;
    Object object = new Object();
    
    
    @Override
    public void run() {
        
            while (ticket > 0) {
                synchronized (object) {
                try { 
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();;
                }
                System.out.println(Thread.currentThread().getName() + "-卖票，票号为：" + ticket);
                --ticket;
            }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        
//        while (true){
//            synchronized(object){
//                if(ticket>0){
//                    System.out.println(Thread.currentThread().getName()+"-卖票，票号为："+ticket);
//                    ticket--;
//                }else{
//                    break;
//                }
//            }
//        }
        
        
        
    }
    
    
}

public class WindowTest {
    public static void main(String[] args) {
        Window window = new Window();
        Thread t1 = new Thread(window);
        t1.setName("窗口1");
        Thread t2 = new Thread(window);
        t2.setName("窗口2");
        Thread t3 = new Thread(window);
        t3.setName("窗口3");
        
        t1.start();
        t2.start();
        t3.start();
        
    }
}
