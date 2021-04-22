package com.iquestgroup.remotelearning.week10.w10p1.models;

import java.util.Queue;

public class Server implements Runnable {

  private static final int TIME_TO_SLEEP = 1000;
  private final Queue<Integer> messageQueue;

  public Server(Queue<Integer> messageQueue) {
    this.messageQueue = messageQueue;
  }

  @Override
  public void run() {
    while (true) {
      try {
        removeMessageFromQueue();
      } catch (InterruptedException exception) {
        exception.printStackTrace();
        Thread.currentThread().interrupt();
      }
    }
  }

  private void removeMessageFromQueue() throws InterruptedException {
    synchronized (messageQueue) {
      while (messageQueue.isEmpty()) {
        System.out.println("Message queue is empty...waiting for client to add...");
        messageQueue.wait();
      }
      System.out.println("Server removed from queue message : " + messageQueue.poll());
      Thread.sleep(TIME_TO_SLEEP);
      messageQueue.notifyAll();
    }
  }
}
