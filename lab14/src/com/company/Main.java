package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        IBlockingQueue<Integer> blockingQueue = new BlockingQueue<>();
        Thread[] threads = new Thread[3];

        for (int i = 0; i < 3; i++) {
            threads[i] = new Thread(new WorkWithQueue(blockingQueue));
            blockingQueue.add(i);
        }

        for (int i = 0; i < 3; i++) {
            threads[i].start();
        }

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            blockingQueue.add(scanner.nextInt());
        }
    }
}