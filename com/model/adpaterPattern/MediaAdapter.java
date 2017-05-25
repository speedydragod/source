package com.model.adpaterPattern;

/**
 * Created by Administrator on 2017/5/25.
 */
public class MediaAdapter implements  MediaPlayer {

    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String mediaType) {
        if(mediaType.equalsIgnoreCase("vlc")){

           advancedMediaPlayer=new VlcPlayer();
        }else if(mediaType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer=new Mp4Player();
        }

    }

    @Override
    public void play(String mediaType, String fileName) {

            if(mediaType.equalsIgnoreCase("vlc")){
                advancedMediaPlayer.playVlc(fileName);
            }else if(mediaType.equalsIgnoreCase("mp4")){
                advancedMediaPlayer.playMp4(fileName);
            }

    }

}
