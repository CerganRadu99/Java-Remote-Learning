package com.iquestgroup.remotelearning.week10.w10p1;

import com.iquestgroup.remotelearning.week10.w10p1.models.Server;
import com.iquestgroup.remotelearning.week10.w10p1.models.Client;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  public static void main(String[] args) {
    Queue<Integer> messageQueue = new LinkedList<>();
    Thread firstClient = new Thread(new Client(messageQueue));
    Thread secondClient = new Thread(new Client(messageQueue));
    Thread thirdClient = new Thread(new Client(messageQueue));
    Thread server = new Thread(new Server(messageQueue));

    firstClient.start();
    secondClient.start();
    thirdClient.start();
    server.start();
  }
}
