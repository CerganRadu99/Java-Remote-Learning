package com.iquestgroup.remotelearning.week14.w14p3;

import com.iquestgroup.remotelearning.week14.w14p3.generator.ScoreGenerator;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class FootballPlayer implements Runnable {

  private static final int NUMBER_OF_SHOTS = 100;
  private static final ScoreGenerator SCORE_GENERATOR = new ScoreGenerator();
  private final int playerNumber;
  private final ReentrantLock reentrantLock;

  public FootballPlayer(ReentrantLock reentrantLock, int playerNumber) {
    this.reentrantLock = reentrantLock;
    this.playerNumber = playerNumber;
  }

  @Override
  public void run() {
    withLock(reentrantLock,
        shotNumber -> System.out.println("Player no. " + playerNumber + " got " + SCORE_GENERATOR.getScore() + " on round no. " + shotNumber));
    try {
      Thread.sleep(100);
    } catch (InterruptedException exception) {
      Thread.currentThread().interrupt();
    }
  }

  private void withLock(ReentrantLock reentrantLock, IntConsumer action) {
    reentrantLock.lock();
    try {
      for (int shotNumber = 1; shotNumber <= NUMBER_OF_SHOTS; shotNumber++) {
        action.accept(shotNumber);
      }
    } finally {
      reentrantLock.unlock();
    }
  }
}
