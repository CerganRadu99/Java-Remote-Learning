package com.iquestgroup.remotelearning.week4.w4p2.models;

import java.util.List;

public class Playlist implements Music {

  private final List<Song> songs;
  private boolean isStopped;

  public Playlist(List<Song> songs) {
    this.songs = songs;
    isStopped = true;
  }

  public boolean isStopped() {
    return isStopped;
  }

  @Override
  public void play() {
    isStopped = false;
    System.out.println("Playlist starts and has " + songs.size() + " songs!");
    for (Song currentSong : songs) {
      currentSong.play();
      currentSong.stop();
    }
  }

  @Override
  public void stop() {
    isStopped = true;
    for (Song currentSong : songs) {
      if (!currentSong.isStopped()) {
        currentSong.stop();
      }
    }
    System.out.println("Playlist has stopped!");
  }
}
