package com.View;


import com.Model.Songs;

import java.util.ArrayList;
import java.util.HashSet;

public class Display {

    public void displayMenu(){

        System.out.println("\t \t  +-----------------------------------------+ ");
        System.out.println("\t \t  | >>>>>>>>  WELCOME TO JUKE BOX  <<<<<<<< | ");
        System.out.println("\t \t  +-----------------------------------------+ ");
            System.out.println("\t \t  | 1. VIEW ALL SONGS \t \t\t\t\t\t|\n\t \t  | 2. PLAY ALL SONGS \t \t\t\t\t\t|\n\t \t  | 3. CREATE PLAYLIST \t \t\t\t\t\t|\n\t \t  | 4. VIEW SONGS IN PLAYLISTS \t \t\t\t|\n\t \t  | 5. PLAY SONGS IN PLAYLIST \t \t\t\t|\n\t \t  | 6. ADD SONGS TO PLAYLIST \t \t\t\t|\n\t \t  | 7. DELETE SONG FROM PLAYLIST \t \t\t|\n\t \t  | 8. DELETE PLAYLIST \t \t\t\t\t\t|\n\t \t  | 9. COMMANDS \t \t\t\t\t\t\t|\n\t \t  | 10. SEARCH \t \t\t\t\t\t\t\t|");
        System.out.println("\t \t  +-----------------------------------------+ ");
    }

    public void displayHelp(){
        System.out.println("\t \t  +---------------------------------+ ");
        System.out.println("\t \t  | >>>>>>     COMMANDS     <<<<<<  | ");
        System.out.println("\t \t  +---------------------------------+ ");
        System.out.println("\t \t  | P = \tPLAY MUSIC\t\t\t\t|\n\t \t  | S = \tSTOP MUSIC\t\t\t\t|\n\t \t  | PAU = \tPAUSE MUSIC\t\t\t\t|\n\t \t  | RES = \tRESUME MUSIC\t\t\t|\n\t \t  | SE = \tSEEK MUSIC\t\t\t\t|\n\t \t  | L = \tLOOP MUSIC\t\t\t\t|\n\t \t  | REST = \tRESTART MUSIC\t\t\t|");
        System.out.println("\t \t  +---------------------------------+ ");
    }

    public void search(){
        System.out.println("\t \t  +---------------------------------+ ");
        System.out.println("\t \t  | >>>>>>      SEARCH      <<<<<<  | ");
        System.out.println("\t \t  +---------------------------------+ ");
        System.out.println("\t \t  | 1 : SEARCH BY SONG NAME\t\t\t|\n\t \t  | 2 : SEARCH BY ARTIST NAME\t\t|\n\t \t  | 3 : SEARCH BY ALBUM NAME\t\t|\n\t \t  | 4 : SEARCH BY GENRE\t\t\t\t|");
        System.out.println("\t \t  +---------------------------------+ ");

    }


     public void displayAllSongs(ArrayList<Songs> list){
         System.out.println("+------------------------------------------------------------------------------------------------------+");
         System.out.format("%1s %7s %1s \t %-15s %1s \t %-15s %4s %-15s %1s %-15s %1s %8s %1s\n",'|',"Song-ID",'|',"Song-Name",'|',"ARTIST",'|',"ALBUM",'|',"Genre",'|',"Duration",'|');
         System.out.println("+------------------------------------------------------------------------------------------------------+");

         for(Songs songs:list){
            // System.out.println("+-------------------------------------------------------------------------+");
             System.out.format("%1s %7s %1s %-20s %1s %-20s %1s %-15s %1s %-15s %1s %8s %1s\n",'|',songs.getSongId(),'|',songs.getSongName(),'|',songs.getArtistName(),'|',songs.getAlbumName(),'|',songs.getGenre(),'|',songs.getDuration(),'|');
         }
         System.out.println("+------------------------------------------------------------------------------------------------------+");
     }

     public void displayPlayList(ArrayList<Songs> list){
         System.out.println("+------------------------------------------------------------------------------------------------------+");
         System.out.format("%1s %7s %1s \t %-15s %1s \t %-15s %4s %-15s %1s %-15s %1s %8s %1s\n",'|',"Song-ID",'|',"Song-Name",'|',"ARTIST",'|',"ALBUM",'|',"Genre",'|',"Duration",'|');
         System.out.println("+------------------------------------------------------------------------------------------------------+");

         for(Songs songs:list){
             // System.out.println("+-------------------------------------------------------------------------+");
             System.out.format("%1s %7s %1s %-20s %1s %-20s %1s %-15s %1s %-15s %1s %8s %1s\n",'|',songs.getSongId(),'|',songs.getSongName(),'|',songs.getArtistName(),'|',songs.getAlbumName(),'|',songs.getGenre(),'|',songs.getDuration(),'|');
         }
         System.out.println("+------------------------------------------------------------------------------------------------------+");
     }


    public void displayShuffle(HashSet<Songs> hashSet){
        System.out.println("+------------------------------------------------------------------------------------------------------+");
        System.out.format("%1s %7s %1s \t %-15s %1s \t %-15s %4s %-15s %1s %-15s %1s %8s %1s\n",'|',"Song-ID",'|',"Song-Name",'|',"ARTIST",'|',"ALBUM",'|',"Genre",'|',"Duration",'|');
        System.out.println("+------------------------------------------------------------------------------------------------------+");

        for(Songs songs:hashSet){
            // System.out.println("+-------------------------------------------------------------------------+");
            System.out.format("%1s %7s %1s %-20s %1s %-20s %1s %-15s %1s %-15s %1s %8s %1s\n",'|',songs.getSongId(),'|',songs.getSongName(),'|',songs.getArtistName(),'|',songs.getAlbumName(),'|',songs.getGenre(),'|',songs.getDuration(),'|');
        }
        System.out.println("+------------------------------------------------------------------------------------------------------+");
    }
     public void displaySearch(ArrayList<Songs> list){
         System.out.println("+------------------------------------------------------------------------------------------------------+");
         System.out.format("%1s %7s %1s \t %-15s %1s \t %-15s %4s %-15s %1s %-15s %1s %8s %1s\n",'|',"Song-ID",'|',"Song-Name",'|',"ARTIST",'|',"ALBUM",'|',"Genre",'|',"Duration",'|');
         System.out.println("+------------------------------------------------------------------------------------------------------+");

         for(Songs songs:list){
             // System.out.println("+-------------------------------------------------------------------------+");
             System.out.format("%1s %7s %1s %-20s %1s %-20s %1s %-15s %1s %-15s %1s %8s %1s\n",'|',songs.getSongId(),'|',songs.getSongName(),'|',songs.getArtistName(),'|',songs.getAlbumName(),'|',songs.getGenre(),'|',songs.getDuration(),'|');
         }
         System.out.println("+------------------------------------------------------------------------------------------------------+");
     }

}
