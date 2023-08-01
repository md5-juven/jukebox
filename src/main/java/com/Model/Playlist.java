package com.Model;

import java.util.ArrayList;

import static com.Dao.DaoJukeBox.getConnection;

public abstract class Playlist extends Songs {
    String playListName;

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }
    public Playlist(){}

    public Playlist(int songId,String songName, String artistName, String genre, String albumName, float duration, String url) {
        super(songId, songName, artistName, genre, albumName, duration, url);
    }


    public abstract void  createPlayList(String listName);

    public abstract ArrayList<Songs> viewSongsInList(String listName);

   public abstract void addSongToList(ArrayList<Songs> list, String songName, String listName);


   public abstract void deleteSongFromList(String listName, String songName);

   public abstract String deletePlayList(String listName);
}
