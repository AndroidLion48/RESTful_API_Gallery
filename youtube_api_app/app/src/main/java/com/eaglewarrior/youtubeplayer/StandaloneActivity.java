package com.eaglewarrior.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Clarence E Moore on 2023-01-04.
 * <p>
 * Description:
 */

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);


        Button btnPlayVideo = (Button) findViewById(R.id.btnPlaySingle);
        Button btnPlayList = (Button) findViewById(R.id.btnStandalone);

        btnPlayList.setOnClickListener(this);
        btnPlayVideo.setOnClickListener(this);

        //        View.OnClickListener ourListener = new View.OnClickListener() {
        //            public void onClick(View view) {
        //
        //            }
        //        };
        //
        //        btnPlayVideo.setOnClickListener(ourListener);
        //        btnPlayList.setOnClickListener(ourListener);
    }

    @Override
    public void onClick(View view) {

        Intent intent = null;

        switch (view.getId()) {
            case R.id.btnPlaySingle:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_VIDEO_ID);
                break;

            case R.id.btnStandalone:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_PLAYLIST);
            default:
        }

        if(intent != null) {
            startActivity(intent);
        }
    }
}
