package com.iquestgroup.remotelearning.week4.w4p2.models;

import java.util.List;

public abstract class MusicPlayer implements Music {

  private List<Playlist> playlists;

  protected MusicPlayer(List<Playlist> playlists) {
    this.playlists = playlists;
  }

  public List<Playlist> getPlaylists() {
    return playlists;
  }
}
