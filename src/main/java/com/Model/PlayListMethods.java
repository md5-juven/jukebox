package com.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

import static com.Dao.DaoJukeBox.getConnection;

public class PlayListMethods extends Playlist {
    Songs songs;

    @Override
    public void createPlayList(String listName) {
        boolean create=false;
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            create=statement.execute("create table "+listName+"(song_id int primary key, foreign key(song_id) references songs(song_id), song_name varchar(50) references songs(song_name) ,artist_name varchar(50) references songs(artist_name), genre varchar(50) references songs(genre), album_name varchar(50) references songs(album_name) ,duration float references songs(duration), url varchar(225) references songs(url));");
            System.out.println("PlayList Created: "+!create);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public  ArrayList<Songs> viewSongsInList(String listName){
        ArrayList<Songs> list=new ArrayList<>();
        try{
            Connection connection=getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from "+listName+";");
            while (resultSet.next()){
                songs=new Songs(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getFloat(6),resultSet.getString(7));
                list.add(songs);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void addSongToList(ArrayList<Songs> list, String songName, String listName){
        //String albumName="";
        try{
            Connection connection=getConnection();
            Statement statement=connection.createStatement();
            for(Songs songs1:list){
                if(songName.equals(songs1.getSongName())) {
                    statement.executeUpdate("insert into "+listName+" values("+songs1.getSongId()+", '"+songs1.getSongName() +"', '"+songs1.getArtistName()+"', '"+songs1.getGenre()+"', '"+songs1.getAlbumName()+"', "+ songs1.getDuration() +", '"+ songs1.getUrl()+"');");
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteSongFromList(String listName, String songName){
        try{
            Connection connection=getConnection();
            Statement statement=connection.createStatement();
            int delete=statement.executeUpdate("delete from "+listName+" where song_name= '"+songName+"' ;");
            if(delete==1)
                System.out.println(songName+" - Deleted From Playlist");
            else
                System.out.println(songName+" - Not found in Playlist");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String deletePlayList(String listName){
        boolean flag;
        try{
            Connection connection=getConnection();
            Statement statement=connection.createStatement();
            flag=statement.execute("drop table "+listName+";");
            System.out.println("Playlist Deleted: "+!flag);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listName;
    }

    /*public LinkedList<Songs> songsQueue(String listName, String songName){
        LinkedList<Songs> list=new LinkedList<>();
        try{
            Connection connection=getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from "+listName+"");

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        for (Songs songs1:list){
            System.out.println(songs1);
        }
        return list;
    }*/

    public HashSet<Songs> shuffle(String listName) {
        HashSet<Songs> hashSet=new HashSet<>();
        try{
            Connection connection=getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from "+listName+";");
            while(resultSet.next()){
                songs=new Songs(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getFloat(6),resultSet.getString(7));
                hashSet.add(songs);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        for (Songs songs1:hashSet){
            System.out.println(songs1);
        }
        return hashSet;
    }

}

