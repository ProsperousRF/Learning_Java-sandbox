/** @author Stanislav Rakitov */
public class Threads1 {
  public static void main(String[] args) {
    System.out.println("Main runs");
    System.out.println("Thread name: " + Thread.currentThread().getName());

    MyRunnable myRunnable = new MyRunnable();
    Thread myRunThread = new Thread(myRunnable, "MyRunnableThread");
    myRunThread.setPriority(Thread.MAX_PRIORITY);
    myRunThread.start();

    // My Thread with name and priority
    MyThread myThread = new MyThread();
    myThread.setName("My Thread");
    myThread.setPriority(Thread.MIN_PRIORITY);
    myThread.start();

    // anonymous threads with normal priority
    new MyThread().start();
    new MyThread().start();
  }

  static void printThreadName() {
    System.out.println("Thread name: " + Thread.currentThread().getName());
  }
}

class MyThread extends Thread {
  @Override
  public void run() {
    System.out.println("MyThread runs");
    for (int i = 0; i < 10; i++) {
      System.out.println("Thread name: " + Thread.currentThread().getName() + ". i " + i);
      try {
        double random = Math.random() * 100;
        Thread.sleep((long) Math.abs(random));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

class MyRunnable implements Runnable {

  @Override
  public void run() {
    System.out.println("MyRunnable runs");
    Threads1.printThreadName();
    for (int i = 0; i <10; i++) {
      try {
        Thread.sleep(10);
        System.out.println("Tik " + i);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
  }
}
