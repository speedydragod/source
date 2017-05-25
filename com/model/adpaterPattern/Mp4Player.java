package com.model.adpaterPattern;

/**
 * Created by Administrator on 2017/5/25.
 */
public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        //do nothing
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing Mp4 file. Name: "+ fileName);
    }
}
