import java.util.concurrent.Semaphore;

public class SemaphoreClass extends Thread{
    private Semaphore semaphore;
    private String threadDirection;

    public SemaphoreClass(Semaphore semaphore, String threadDirection) {
        super(threadDirection);
        this.semaphore = semaphore;
        this.threadDirection = threadDirection;
    }


    @Override
    public void run() {
        if(this.getName().equals("Nord-South")){
            try {
                semaphore.acquire();
                System.out.println(threadDirection + " semaphore is green");
                System.out.println("One more car crosses the intersection");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadDirection + " semaphore is red");
            semaphore.release();

        }else if(this.getName().equals("West-East")){
            try {
                semaphore.acquire();
                System.out.println(threadDirection + " semaphore is green");
                System.out.println("One more car crosses the intersection");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadDirection + " semaphore is red");
            semaphore.release();

        }else {
            try {
                throw new Exception("Direction is not correct");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
