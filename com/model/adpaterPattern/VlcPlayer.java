package com.model.adpaterPattern;

/**
 * Created by Administrator on 2017/5/25.
 */
public class VlcPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
    //no thing doing
    }
}
