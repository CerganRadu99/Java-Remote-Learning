package com.iquestgroup.remotelearning.week10.w10p1;

import com.iquestgroup.remotelearning.week10.w10p1.models.Consumer;
import com.iquestgroup.remotelearning.week10.w10p1.models.Producer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();
    Thread thread1 = new Thread(new Producer(queue));
    Thread thread2 = new Thread(new Consumer(queue));
    thread1.start();
    thread2.start();
  }
}
