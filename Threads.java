package oop;

/**
 *
 * @author Md Golam Kibria
 */
public class Threads {
    public static void main(String[] args) throws Exception{
        
        MyThread thread = new MyThread();
        thread.start();  // Start the thread, which calls the run() method
        thread.join();   // 
        System.out.println("------------");
        
        Thread thread2 = new Thread(new MyRunnable());
        thread2.start(); // Start the thread, which calls the run() method of MyRunnable
        thread2.join();
        System.out.println("------------");
        
        Thread t1 = new Thread(new MultiThreadExample("Thread 1"));
        Thread t2 = new Thread(new MultiThreadExample("Thread 2"));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("------------");
        
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread t3 = new Thread(task);
        Thread t4 = new Thread(task);

        t3.start();
        t4.start();

        t3.join();
        t4.join();

        System.out.println("Final Count: " + counter.getCount()); // Output should be 2000 if synchronized correctly
        System.out.println("------------");
        
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        daemonThread.setDaemon(true); // Set as daemon thread
        daemonThread.start();

        System.out.println("Main thread ending."); // After this line, JVM exits, and daemon thread terminates
    }
}

/*
To create a thread by extending the Thread class, define a subclass that overrides the run() method. This method contains the code that will be executed by the thread when it is started.
*/
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("MyThread: " + i);
            try {
                Thread.sleep(500); // Pause for 500ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("MyRunnable: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MultiThreadExample implements Runnable {
    private String name;

    public MultiThreadExample(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + ": " + i);
            try {
                Thread.sleep(400);  // Each thread sleeps for 400ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Counter {
    private int count = 0;

    // Synchronized method to ensure thread-safe increment
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}





/*
In Java, a thread is the smallest unit of execution within a process. 
A process can have multiple threads running concurrently, allowing tasks to be performed in parallel. 
Java provides built-in support for multithreading, enabling developers to write programs that can perform multiple tasks at the same time.

Basics of Threads in Java
A Java thread is an instance of the Thread class or an implementation of the Runnable interface. 
Each thread has its own stack, local variables, and program counter, but it shares the heap memory with other threads in the same process. 
This enables threads to communicate and share data easily, but it also requires careful management to avoid issues like data inconsistency.

Why Use Threads?
Concurrency: Threads enable multiple tasks to run concurrently within a single program.
Improved Performance: Multithreading can improve program responsiveness and performance, especially on multicore processors.
Background Tasks: Threads are useful for running background tasks, such as file I/O, network operations, and scheduled tasks, without blocking the main thread.

Creating Threads in Java
Java provides two primary ways to create a thread:
    -Extending the Thread Class
    -Implementing the Runnable Interface


Key Methods in the Thread Class
start(): Begins the execution of the thread by calling the run() method.
run(): The entry point for the thread’s execution. Override this method to define the task the thread should perform.
sleep(long milliseconds): Puts the thread to sleep for a specified time.
join(): Causes the current thread to wait until the specified thread completes.
interrupt(): Interrupts a sleeping or waiting thread, causing it to stop its current operation.


Thread Lifecycle
Java threads have a lifecycle, represented by the following states:

New: The thread is created but not started.
Runnable: The thread is ready to run and waiting for CPU time.
Blocked: The thread is waiting for a monitor lock (for example, during synchronized block access).
Waiting: The thread is waiting indefinitely for another thread to perform a particular action.
Timed Waiting: The thread is waiting for a specific period (e.g., using sleep() or join() with a timeout).
Terminated: The thread has completed its execution.

Synchronization
Since threads share the same memory space, they may need synchronized access to shared resources to avoid data inconsistency. 
The synchronized keyword is used to lock an object, ensuring that only one thread can access it at a time.

Daemon Threads
A daemon thread is a background thread that runs in the background to support other threads or services, like the Java garbage collector. It automatically terminates when all non-daemon threads finish execution. To set a thread as daemon, call setDaemon(true) before starting it.


Common Multithreading Pitfalls
Data Inconsistency: Shared data among threads needs to be synchronized properly to avoid race conditions.
Deadlock: When two or more threads are blocked forever, each waiting for a resource held by the other.
Thread Interference: When multiple threads attempt to modify shared resources at the same time without proper synchronization.
*/