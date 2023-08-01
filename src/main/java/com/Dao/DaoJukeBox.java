package com.Dao;

import com.Model.Search;
import com.Model.Songs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoJukeBox implements Search {

    Songs songs;

    public static Connection getConnection(){
        Connection connection=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            System.out.println("Connected to Database");
        }
        catch (Exception e)
        {
            System.out.println("Error While Connecting to database Check: "+e);
        }
        return connection;
    }

    public ArrayList<Songs> viewSongs(){
        ArrayList<Songs> list=new ArrayList<>();
        try {
            Connection connection = getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from songs;");
            while(resultSet.next()){
                songs=new Songs(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getFloat(6),resultSet.getString(7));
                list.add(songs);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return  list;
    }


    @Override
    public ArrayList<Songs> searchSong(String songName) {
        ArrayList<Songs> list= new ArrayList<>();
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from songs where song_name like '"+songName+"%' ;");
            while(resultSet.next()){
                songs=new Songs(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getFloat(6));
                list.add(songs);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public ArrayList<Songs> searchArtist(String artistName) {
        ArrayList<Songs> list= new ArrayList<>();
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from songs where artist_name like '"+artistName+"%' ;");
            while(resultSet.next()){
                songs=new Songs(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getFloat(6));
                list.add(songs);
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public ArrayList<Songs> searchGenre(String genre) {
        ArrayList<Songs> list= new ArrayList<>();
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from songs where genre like '"+genre+"%' ;");
            while(resultSet.next()){
                songs=new Songs(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getFloat(6));
                list.add(songs);
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public ArrayList<Songs> searchAlbum(String albumName) {
        ArrayList<Songs> list= new ArrayList<>();
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from songs where album_name like '"+albumName+"%' ;");
            while(resultSet.next()){
                songs=new Songs(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getFloat(6));
                list.add(songs);
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }
}
