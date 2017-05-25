package com.model.adpaterPattern;

/**
 * Created by Administrator on 2017/5/25.
 */
public class AudioPlayer implements MediaPlayer {

    MediaAdapter MediaAdapter;


    @Override
    public void play(String mediaType, String fileName) {

        if(mediaType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file. Name: "+ fileName);
        }else if(mediaType.equalsIgnoreCase("vlc")){
            MediaAdapter=new MediaAdapter(mediaType);
            MediaAdapter.play(mediaType, fileName);
        }else if (mediaType.equalsIgnoreCase("mp4")) {
            MediaAdapter = new MediaAdapter(mediaType);
            MediaAdapter.play(mediaType, fileName);
        } else {
            System.out.println("invalid media. " + mediaType + " format not supported");
        }

    }
}
