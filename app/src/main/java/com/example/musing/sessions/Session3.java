package com.example.musing.sessions;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.musing.R;

import java.util.concurrent.TimeUnit;

public class Session3 extends AppCompatActivity {
    TextView playerPosition, playerDuration;
    SeekBar seekbar;
    ImageView btRew, btPlay, btPause, btFf;
    MediaPlayer mediaPlayer;
    Handler handler = new Handler();
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session3);
        seekbar = findViewById(R.id.seekbar);
        btRew = findViewById(R.id.bt_rew);
        btPlay = findViewById(R.id.bt_play);
        btPause = findViewById(R.id.bt_pause);
        btFf = findViewById(R.id.bt_ff);
        playerPosition = findViewById(R.id.player_position);
        playerDuration = findViewById(R.id.player_duration);
        //Indiatialise media player
        mediaPlayer = MediaPlayer.create(this, R.raw.session3);
        //initialize runnable
        runnable = new Runnable() {
            @Override
            public void run() {
//set progress on seek bar
                seekbar.setProgress(mediaPlayer.getCurrentPosition());
                handler.postDelayed(this, 500);
            }
        };
//get duration of mediaplayer
        int duration = mediaPlayer.getDuration();
        //convert milliseconds to minute and second
        String sDuration = convertFormat(duration);
        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hide play button
                btPlay.setVisibility(View.GONE);
                //show pause button
                btPause.setVisibility(View.VISIBLE);
                //start media player
                mediaPlayer.start();
                //set max seekbar
                seekbar.setMax(mediaPlayer.getDuration());
                //start handler
                handler.postDelayed(runnable, 0);

            }
        });

        btPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hide button pause
                btPause.setVisibility(View.GONE);
                //show play button
                btPlay.setVisibility(View.VISIBLE);
                mediaPlayer.pause();
                //stop handler
                handler.removeCallbacks(runnable);

            }
        });

        btFf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get current postion of Media player
                int currentpostion = mediaPlayer.getCurrentPosition();
                //get duration of media player
                int duration = mediaPlayer.getDuration();
                //check condition
                if (mediaPlayer.isPlaying() && duration != currentpostion) {
//when media is playing duration is not equal to current position
                    currentpostion = currentpostion + 5000;
                    playerPosition.setText(convertFormat(currentpostion));
                    mediaPlayer.seekTo(currentpostion);
                }


            }
        });

        btRew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get current postion
                int currentPostion = mediaPlayer.getCurrentPosition();
                if (mediaPlayer.isPlaying() && currentPostion > 5000) {
                    currentPostion = currentPostion - 5000;
                    playerPosition.setText(convertFormat(currentPostion));
                    mediaPlayer.seekTo(currentPostion);
                }


            }
        });

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
                //setting current postion on textview
                playerPosition.setText(convertFormat(mediaPlayer.getCurrentPosition()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                btPause.setVisibility(View.GONE);
                btPlay.setVisibility(View.VISIBLE);
                mediaPlayer.seekTo(0);

            }
        });
    }

    @SuppressLint("DefaultLocale")
    private String convertFormat(int duration) {

        return String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(duration),
                TimeUnit.MILLISECONDS.toSeconds(duration),
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
    }
}