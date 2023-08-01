package com.Controller;

import com.Dao.DaoJukeBox;
import com.Model.AudioPlayerMethods;
import com.Model.PlayListMethods;
import com.Model.Songs;
import com.View.Display;

import java.io.BufferedReader;
import java.io.InputStreamReader;


import java.util.*;


public class JukeBoxImpl {


    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        Songs songs = new Songs();
        DaoJukeBox daoJukeBox = new DaoJukeBox();
        PlayListMethods playListMethods = new PlayListMethods();
        Display display = new Display();
        AudioPlayerMethods audio = null;
        ArrayList<Songs> list = daoJukeBox.viewSongs();
        //Iterator<Songs> iterator= list.iterator();
        ArrayList<Songs> list1;
        display.displayMenu();
        int loop = 0;

                    do {
                            try {
                            int ch = 0;
                                System.out.println("ENTER YOUR CHOICE");
                                 ch = scanner.nextInt();


                    switch (ch) {

                        case 1:
                            display.displayAllSongs(list);
                            break;

                        case 2:
                            display.displayAllSongs(list);
                            try {
                                System.out.println("ENTER THE SONG NAME TO PLAY: ");
                                InputStreamReader in = new InputStreamReader(System.in);
                                BufferedReader br = new BufferedReader(in);
                                String songName4 = br.readLine().toUpperCase();
                                for (Songs songs1 : list) {
                                    if (songName4.equals(songs1.getSongName()))
                                        audio = new AudioPlayerMethods(songs1.getUrl());
                                }

                                int loop1 = 0;
                                do {
                                    System.out.println("ENTER YOUR CHOICE: ");
                                    String choice1 = scanner.next().toUpperCase();
                                    switch (choice1) {
                                        case ("P"):
                                            if (audio != null) {
                                                audio.playMusic();
                                                audio.displayTime();
                                            }
                                            break;

                                        case ("S"):
                                            if (audio != null)
                                                audio.stopMusic();
                                            break;

                                        case ("PAU"):
                                            if (audio != null)
                                                audio.pauseMusic();
                                            break;

                                        case ("RES"):
                                            if (audio != null)
                                                audio.resumeMusic();
                                            break;

                                        case ("SE"):
                                            if (audio != null) {
                                                System.out.println("ENTER TIME IN SECONDS FORMAT");
                                                long seek = scanner.nextLong();
                                                audio.seekMusic(seek);
                                            }
                                            break;

                                        case ("L"):
                                            if (audio != null)
                                                audio.loopMusic();
                                            break;

                                        case ("REST"):
                                            if (audio != null)
                                                audio.restartMusic();
                                            break;


                                        default:
                                            System.out.println("PLEASE ENTER RIGHT CHOICE: ");
                                            display.displayHelp();
                                    }
                                    System.out.println("ENTER 1 TO CONTINUE-PLAY SONGS / ENTER 0 TO EXIT");
                                    loop1 = scanner.nextInt();
                                    if (loop1 == 1)
                                        display.displayHelp();
                                } while (loop1 != 0);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case 3:
                            System.out.println("ENTER PLAYLIST NAME TO CREATE PLAYLIST: ");
                            String listName1 = scanner.next();
                            playListMethods.createPlayList(listName1);
                            break;

                        case 4:
                            System.out.println("ENTER PLAYLIST NAME: ");
                            String listName2 = scanner.next();
                            list1 = playListMethods.viewSongsInList(listName2);
                            display.displayPlayList(list1);
                            break;

                        case 5:
                            System.out.println("ENTER PLAYLIST NAME: ");
                            String listName5 = scanner.next();
                            list1 = playListMethods.viewSongsInList(listName5);
                            display.displayPlayList(list1);
                            try {
                                System.out.println("ENTER THE SONG NAME TO PLAY: ");
                                InputStreamReader input = new InputStreamReader(System.in);
                                BufferedReader buffer = new BufferedReader(input);
                                String songName3 = buffer.readLine().toUpperCase();
                                for (Songs songs1 : list1) {
                                    if (songName3.equals(songs1.getSongName()))
                                        audio = new AudioPlayerMethods(songs1.getUrl());
                                }
                                int ss = 0;
                                do {
                                    System.out.println("ENTER YOUR CHOICE: ");
                                    String choice = scanner.next().toUpperCase();
                                    switch (choice) {
                                        case ("P"):
                                            if (audio != null) {
                                                audio.playMusic();
                                                audio.displayTime();
                                            }
                                            break;

                                        case ("S"):
                                            if (audio != null)
                                                audio.stopMusic();
                                            break;

                                        case ("PAU"):
                                            if (audio != null)
                                                audio.pauseMusic();
                                            break;

                                        case ("RES"):
                                            if (audio != null)
                                                audio.resumeMusic();
                                            break;

                                        case ("SE"):
                                            if (audio != null) {
                                                System.out.println("ENTER TIME IN SECONDS FORMAT");
                                                long seek = scanner.nextLong();
                                                audio.seekMusic(seek);
                                            }
                                            break;

                                        case ("L"):
                                            if (audio != null)
                                                audio.loopMusic();
                                            break;

                                        case ("REST"):
                                            if (audio != null)
                                                audio.restartMusic();
                                            break;

                                        case ("SH"):
                                            if (audio != null) {
                                                System.out.println("ENTER THE NAME OF PLAYLIST TO SHUFFLE");
                                                String listName7 = scanner.next();
                                                HashSet<Songs> hashSet = playListMethods.shuffle(listName7);
                                                display.displayShuffle(hashSet);
                                            }

                                        default:
                                            System.out.println("PLEASE ENTER RIGHT CHOICE: ");
                                            display.displayHelp();
                                    }
                                    System.out.println("ENTER 1 TO CONTINUE-PLAY SONGS / ENTER 0 TO EXIT");
                                    ss = scanner.nextInt();
                                    if (ss == 1)
                                        display.displayHelp();
                                } while (ss != 0);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;


                        case 6:
                            System.out.println("ENTER THE PLAYLIST NAME : TO ADD SONGS");
                            String listName3 = scanner.next();
                            try {
                                System.out.println("ENTER THE NAME OF THE SONG: ");
                                InputStreamReader in = new InputStreamReader(System.in);
                                BufferedReader br = new BufferedReader(in);
                                String songName1 = br.readLine().toUpperCase();
                                playListMethods.addSongToList(list, songName1, listName3);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;


                        case 7:
                            System.out.println("ENTER THE PLAYLIST NAME : TO DELETE SONG");
                            String listName4 = scanner.next();
                            try {
                                System.out.println("ENTER THE NAME OF THE SONG : ");
                                InputStreamReader in = new InputStreamReader(System.in);
                                BufferedReader br = new BufferedReader(in);
                                String songName2 = br.readLine().toUpperCase();
                                playListMethods.deleteSongFromList(listName4, songName2);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;


                        case 8:
                            System.out.println("ENTER PLAYLIST NAME TO DELETE PLAYLIST: ");
                            String listName = scanner.next();
                            playListMethods.deletePlayList(listName);
                            break;

                        case 9:
                            display.displayHelp();
                            break;

                        case 10:
                            display.search();
                            int loop2 = 0;
                            do {
                                System.out.println("ENTER THE CHOICE : ");
                                int choice2 = scanner.nextInt();
                                switch (choice2) {

                                    case 1:
                                        try {
                                            System.out.println("ENTER THE SONG NAME : ");
                                            InputStreamReader in = new InputStreamReader(System.in);
                                            BufferedReader br = new BufferedReader(in);
                                            String songName6 = br.readLine().toUpperCase();
                                            list1 = daoJukeBox.searchSong(songName6);
                                            display.displaySearch(list1);
                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;

                                    case 2:
                                        try {
                                            System.out.println("ENTER THE ARTIST NAME : ");
                                            InputStreamReader in = new InputStreamReader(System.in);
                                            BufferedReader br = new BufferedReader(in);
                                            String songName7 = br.readLine();
                                            list1 = daoJukeBox.searchArtist(songName7);
                                            display.displaySearch(list1);
                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;

                                    case 3:
                                        try {
                                            System.out.println("ENTER THE ALBUM NAME : ");
                                            InputStreamReader in = new InputStreamReader(System.in);
                                            BufferedReader br = new BufferedReader(in);
                                            String songName8 = br.readLine();
                                            list1 = daoJukeBox.searchAlbum(songName8);
                                            display.displaySearch(list1);
                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;

                                    case 4:
                                        try {
                                            System.out.println("ENTER THE GENRE : ");
                                            InputStreamReader in = new InputStreamReader(System.in);
                                            BufferedReader br = new BufferedReader(in);
                                            String songName9 = br.readLine();
                                            list1 = daoJukeBox.searchGenre(songName9);
                                            display.displaySearch(list1);
                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;

                                    default:
                                        System.out.println("PLEASE ENTER RIGHT CHOICE");
                                }
                                System.out.println("ENTER 1 TO CONTINUE-SEARCH / ENTER 0 TO EXIT");
                                loop2 = scanner.nextInt();
                                if (loop2 == 1)
                                    display.search();
                            } while (loop2 != 0);
                            break;

                        default:
                            System.out.println("PLEASE ENTER CORRECT CHOICE");
                    }
                    //---------------END OF MAIN-SWITCH---------------------
                    System.out.println("ENTER 1 TO CONTINUE-JUKEBOX / ENTER 0 TO EXIT");
                    loop = scanner.nextInt();

                    if (loop == 1) {
                        display.displayMenu();
                    }

                }catch (Exception e){
                            System.out.println(e);
                        }

            } while (loop != 0);


            //-----------------End of MAIN do-while loop----------------
    }
}
