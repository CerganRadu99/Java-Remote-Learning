package com.iquestgroup.remotelearning.week10.w10p1;

import java.util.Queue;

public class Consumer implements Runnable {

  private final Queue<Integer> queue;

  public Consumer(Queue<Integer> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    while (true) {
      try {
        consume();
      } catch (InterruptedException exception) {
        exception.printStackTrace();
        Thread.currentThread().interrupt();
      }
    }
  }

  private void consume() throws InterruptedException {
    synchronized (queue) {
      while (queue.isEmpty()) {
        System.out.println("Queue is empty...waiting for producer to produce...");
        queue.wait();
      }
      System.out.println("Consumer consumed product : " + queue.poll());
      Thread.sleep(1000);
      queue.notifyAll();
    }
  }
}
