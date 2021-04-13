package com.iquestgroup.remotelearning.week10.w10p1;

import java.util.Queue;

public class Producer implements Runnable {

  private static final int MAX_NO_OF_MESSAGES = 10;
  private final Queue<Integer> queue;
  private int itemToProduce = 0;

  public Producer(Queue<Integer> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    while (true) {
      try {
        produce(itemToProduce++);
      } catch (InterruptedException exception) {
        exception.printStackTrace();
        Thread.currentThread().interrupt();
      }
    }
  }

  private void produce(int itemToProduce) throws InterruptedException {
    synchronized (queue) {
      while (queue.size() == MAX_NO_OF_MESSAGES) {
        System.out.println("Queue is full, waiting for consumer to consume...");
        queue.wait();
      }
      queue.add(itemToProduce);
      System.out.println("Producer produced product " + itemToProduce);
      Thread.sleep(1000);
      queue.notifyAll();
    }
  }
}
