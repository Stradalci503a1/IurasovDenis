package com.company;

public class BlockingQueue<T> implements IBlockingQueue<T> {

    private Container top;

    public BlockingQueue() {
        top = null;
    }

    @Override
    public synchronized void add(T value) {

        if (null == value) {
            throw new NullPointerException("Can't add null element to queue.");
        }
        top = new Container(value, top);
        notify();
    }

    @Override
    public synchronized T take() {

        while (null == top) {
            try {
                wait();
            } catch (InterruptedException exception) {
            }
        }
        T element = top.element;
        top = top.next;
        return element;
    }

    private class Container {

        T element;
        Container next;

        public Container(T value, Container next) {
            element = value;
            this.next = next;
        }
    }
}
