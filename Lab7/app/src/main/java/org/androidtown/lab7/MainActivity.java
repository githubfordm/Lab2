package org.androidtown.lab7;

import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.IOException;

import static android.R.attr.tag;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    RelativeLayout audio1;
    RelativeLayout audio2;
    int id_audio1;
    int id_audio2;
    String getTag1;
    String getTag2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audio1 = (RelativeLayout) findViewById(R.id.audio);
        audio2 = (RelativeLayout) findViewById(R.id.audio2);

        getTag1 = (String) audio1.getTag();
        id_audio1 = getResources().getIdentifier(getTag1, "raw", getPackageName());

        getTag2 = (String) audio2.getTag();
        id_audio2 = getResources().getIdentifier(getTag2, "raw", getPackageName());
    }

    public void play1(View v) throws IOException {

        killMediaPlayer();

        mediaPlayer = new MediaPlayer();
        AssetFileDescriptor afd = getResources().openRawResourceFd(id_audio1);
        mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getDeclaredLength());
        mediaPlayer.prepare();
        mediaPlayer.start();

        Toast.makeText(getApplicationContext(), getTag1 + " 재생됨.", Toast.LENGTH_LONG).show();
        audio1.setBackgroundColor(Color.GRAY);
        audio2.setBackgroundColor(Color.WHITE);

    }

    public void play2(View v) throws IOException{

        killMediaPlayer();

        mediaPlayer = new MediaPlayer();
        AssetFileDescriptor afd = getResources().openRawResourceFd(id_audio2);
        mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getDeclaredLength());
        mediaPlayer.prepare();
        mediaPlayer.start();

        Toast.makeText(getApplicationContext(), getTag2 + " 재생됨.", Toast.LENGTH_LONG).show();
        audio2.setBackgroundColor(Color.GRAY);
        audio1.setBackgroundColor(Color.WHITE);

    }

    private void killMediaPlayer() {

        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
