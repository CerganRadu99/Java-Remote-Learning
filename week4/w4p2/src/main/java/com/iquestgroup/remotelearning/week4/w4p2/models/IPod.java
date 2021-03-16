package com.iquestgroup.remotelearning.week4.w4p2.models;

import java.util.List;

public class IPod extends MusicPlayer {

  public IPod(List<Playlist> playlists) {
    super(playlists);
  }

  @Override
  public void play() {
    System.out.println("IPod starts and has " + getPlaylists().size() + " playlists!");
    for (Playlist currentPlaylist : getPlaylists()) {
      currentPlaylist.play();
      currentPlaylist.stop();
    }
  }

  @Override
  public void stop() {
    for (Playlist currentPlaylist : getPlaylists()) {
      if (!currentPlaylist.isStopped()) {
        currentPlaylist.stop();
      }
    }
    System.out.println("IPod has stopped!");
  }
}
