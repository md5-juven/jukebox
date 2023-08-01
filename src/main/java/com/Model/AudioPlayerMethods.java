package com.Model;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.io.File;
import java.util.HashSet;


public class AudioPlayerMethods extends AudioPlayer {

    AudioInputStream audioInputStream;

    Clip clip;
    String fileName;
    File file;
    Long currentFrame;
    String status;


    public AudioPlayerMethods(){}

    public AudioPlayerMethods(String fileName) {
        this.fileName=fileName;
        try {
            file=new File(fileName);
            audioInputStream = AudioSystem.getAudioInputStream(file);
            clip=AudioSystem.getClip();
            clip.open(audioInputStream);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void playMusic() {
        try {
            clip.start();
            status="play";
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void nextSong(){
        try{
            clip.close();
            restartMusic();
            this.playMusic();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void stopMusic() {
        try{
            currentFrame=0L;
            clip.stop();
            clip.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void resumeMusic() {
        if(status.equals("play")){
            System.out.println("Audio already playing");
            return;
        }
        try {
            clip.close();
            resetAudioStream();
            clip.setMicrosecondPosition(currentFrame);
            this.playMusic();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void restartMusic() {
        try{
            clip.stop();
            clip.close();
            resetAudioStream();
            clip.setMicrosecondPosition(0);
            this.playMusic();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void loopMusic() {
        try{
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void pauseMusic() {
        if(status.equals("paused")){
            System.out.println("Audio already paused");
            return ;
        }
        try{
            this.currentFrame= this.clip.getMicrosecondPosition();
            clip.stop();
            status="paused";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void seekMusic(long c) {
        try {
            if (c > 0 && c < clip.getMicrosecondLength()) {
                clip.stop();
                clip.close();
                resetAudioStream();
                currentFrame = c;
                c = c * 1000000;
                clip.setMicrosecondPosition(c);
                this.playMusic();
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void displayTime() {
        try{
            clip.close();
            resetAudioStream();
            this.playMusic();
            AudioFormat format = audioInputStream.getFormat();
            long frames = audioInputStream.getFrameLength();
            double durationInSeconds = (frames+0.0) / format.getFrameRate();
            double minutes=durationInSeconds/60;
            System.out.println("Time Remaining(MM:SS) = "+minutes);
       }
        catch (Exception e){
            System.out.println(e);
        }
    }


    public void resetAudioStream()
    {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(
                    new File(fileName).getAbsoluteFile());
            clip.open(audioInputStream);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
