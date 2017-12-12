package com.company;

public class WorkWithQueue implements Runnable {

    private static int count = 0;
    private final IBlockingQueue blockingQueue;
    private final int number = ++count;

    public WorkWithQueue(IBlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println(blockingQueue.take() + " taken in thread №" + number);
        System.out.println(blockingQueue.take() + " taken in thread №" + number);
    }
}
