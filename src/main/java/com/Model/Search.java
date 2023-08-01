package com.Model;


import java.util.ArrayList;

public interface Search {

    public  ArrayList searchSong(String songName);
    public  ArrayList searchArtist(String artistName);
    public  ArrayList searchGenre(String genre);

    public ArrayList searchAlbum(String albumName);

}
