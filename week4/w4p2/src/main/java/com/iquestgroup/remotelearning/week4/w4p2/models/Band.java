package com.iquestgroup.remotelearning.week4.w4p2.models;

import java.util.List;

public class Band {

  private final List<Singer> singers;
  private final MusicPlayer musicPlayer;

  public Band(List<Singer> singers, MusicPlayer musicPlayer) {
    this.singers = singers;
    this.musicPlayer = musicPlayer;
  }

  public void startMusicPlayer() {
    for (Playlist currentPlaylist : musicPlayer.getPlaylists()) {
      currentPlaylist.play();
    }
  }

  public void makeShow() {
    for (Singer singer : singers) {
      singer.sing();
    }
  }
}
