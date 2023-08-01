package com.Model;

import java.util.HashSet;

public abstract class AudioPlayer {

    public abstract void playMusic();

    public abstract void stopMusic();

    public abstract void resumeMusic();

    public abstract void restartMusic();

    public abstract void loopMusic();

    public abstract void pauseMusic();

    public abstract void seekMusic(long c);

    public abstract void displayTime();



}
