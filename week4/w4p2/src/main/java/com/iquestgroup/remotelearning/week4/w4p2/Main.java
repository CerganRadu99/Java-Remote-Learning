package com.iquestgroup.remotelearning.week4.w4p2;

import com.iquestgroup.remotelearning.week4.w4p2.models.Playlist;
import com.iquestgroup.remotelearning.week4.w4p2.models.Band;
import com.iquestgroup.remotelearning.week4.w4p2.models.BassGuitarist;
import com.iquestgroup.remotelearning.week4.w4p2.models.Drummer;
import com.iquestgroup.remotelearning.week4.w4p2.models.Drumset;
import com.iquestgroup.remotelearning.week4.w4p2.models.Guitar;
import com.iquestgroup.remotelearning.week4.w4p2.models.IPod;
import com.iquestgroup.remotelearning.week4.w4p2.models.LeadGuitarist;
import com.iquestgroup.remotelearning.week4.w4p2.models.MusicPlayer;
import com.iquestgroup.remotelearning.week4.w4p2.models.RhythmGuitarist;
import com.iquestgroup.remotelearning.week4.w4p2.models.Singer;
import com.iquestgroup.remotelearning.week4.w4p2.models.Song;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    //---CREATE 3 DIFFERENT SONGS FOR PLAYLIST 1
    Song song1 = new Song("When I rule the world", 3.13);
    Song song2 = new Song("End of time", 4.01);
    Song song3 = new Song("So will I", 2.87);

    //---CREATE LIST OF SONGS FOR PLAYLIST 1
    List<Song> songs1 = new ArrayList<>();
    songs1.add(song1);
    songs1.add(song2);
    songs1.add(song3);

    //---CREATE PLAYLIST 1
    Playlist playlist1 = new Playlist(songs1);

    //---CREATE 3 DIFFERENT SONGS FOR PLAYLIST 2
    Song song4 = new Song("High Hopes", 4.25);
    Song song5 = new Song("Pressure", 2.32);
    Song song6 = new Song("Heal Me", 3.19);

    //---CREATE LIST OF SONGS FOR PLAYLIST 2
    List<Song> songs2 = new ArrayList<>();
    songs2.add(song4);
    songs2.add(song5);
    songs2.add(song6);

    //---CREATE PLAYLIST 2
    Playlist playlist2 = new Playlist(songs2);

    //---CREATE LIST OF PLAYLISTS FOR MUSIC PLAYER
    List<Playlist> playlists = new ArrayList<>();
    playlists.add(playlist1);
    playlists.add(playlist2);

    //---CREATE MUSIC PLAYER
    MusicPlayer iPod = new IPod(playlists);

    //---CREATE DRUMMER WITH 3 DRUMSETS---
    List<Drumset> drumsets = new ArrayList<>();
    drumsets.add(new Drumset());
    drumsets.add(new Drumset());
    drumsets.add(new Drumset());
    Singer drummer = new Drummer(drumsets);

    //---CREATE BASS GUITARIST WITH 3 GUITARS
    List<Guitar> guitars1 = new ArrayList<>();
    guitars1.add(new Guitar());
    guitars1.add(new Guitar());
    guitars1.add(new Guitar());
    Singer bassGuitarist = new BassGuitarist(guitars1);

    //---CREATE RHYTHM GUITARIST WITH 3 GUITARS
    List<Guitar> guitars2 = new ArrayList<>();
    guitars2.add(new Guitar());
    guitars2.add(new Guitar());
    guitars2.add(new Guitar());
    Singer rhythmGuitarist = new RhythmGuitarist(guitars2);

    //---CREATE LEAD GUITARIST WITH 3 GUITARS
    List<Guitar> guitars3 = new ArrayList<>();
    guitars3.add(new Guitar());
    guitars3.add(new Guitar());
    guitars3.add(new Guitar());
    Singer leadGuitarist = new LeadGuitarist(guitars3);

    List<Singer> singers = new ArrayList<>();
    singers.add(drummer);
    singers.add(bassGuitarist);
    singers.add(rhythmGuitarist);
    singers.add(leadGuitarist);

    Band band = new Band(singers, iPod);
    band.startMusicPlayer();
    band.makeShow();
  }
}
