package com.iquestgroup.remotelearning.week10.w10p1.models;

import java.util.Queue;

public class Client implements Runnable {

  private static final int MAX_NO_OF_MESSAGES = 10;
  private static final int TIME_TO_SLEEP = 1000;
  private final Queue<Integer> messageQueue;
  private int messageToAdd = 0;

  public Client(Queue<Integer> messageQueue) {
    this.messageQueue = messageQueue;
  }

  @Override
  public void run() {
    while (true) {
      try {
        addMessageToQueue(messageToAdd++);
      } catch (InterruptedException exception) {
        exception.printStackTrace();
        Thread.currentThread().interrupt();
      }
    }
  }

  private void addMessageToQueue(int messageToAdd) throws InterruptedException {
    synchronized (messageQueue) {
      while (messageQueue.size() == MAX_NO_OF_MESSAGES) {
        System.out.println("Message queue is full, waiting for server to remove...");
        messageQueue.wait();
      }
      messageQueue.add(messageToAdd);
      System.out.println("Client added to queue message " + messageToAdd);
      Thread.sleep(TIME_TO_SLEEP);
      messageQueue.notifyAll();
    }
  }
}
