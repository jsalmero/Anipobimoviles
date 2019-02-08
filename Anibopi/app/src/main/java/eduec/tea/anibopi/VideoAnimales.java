package eduec.tea.anibopi;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoAnimales extends AppCompatActivity {

    private VideoView videoView;
    // private ImageView repetir;
    private int position = 0;
    public Intent intent;
    private MediaController mediaController;
    private Image buttonPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_animales);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        videoView = (VideoView) findViewById(R.id.videoAnimales);
        // repetir = (ImageView) findViewById(R.id.btnrepetir);

        //  repetir.setVisibility(View.INVISIBLE);

        // Set the media controller buttons
        if (mediaController == null) {
            mediaController = new MediaController(VideoAnimales.this);

            // Set the videoView that acts as the anchor for the MediaController.
            mediaController.setAnchorView(videoView);
            // Set MediaController for VideoView
            videoView.setMediaController(mediaController)

            ;/*
            repetir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    videoView.resume();
                }
            });*/


        }




        try {
            // ID of video file.
            int id = this.getRawResIdByName("animalesvideo");
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + id));

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        videoView.requestFocus();


        // When the video file ready for playback.
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            public void onPrepared(MediaPlayer mediaPlayer) {


                videoView.seekTo(position);
                if (position == 0) {
                    videoView.start();

                }

                // When video Screen change size.
                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

                        // Re-Set the videoView that acts as the anchor for the MediaController
                        mediaController.setAnchorView(videoView);
                    }
                });
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                // repetir.setVisibility(View.VISIBLE);
                try{
                    intent=new Intent(getApplicationContext(),ActividadAnimales.class);
                    startActivity(intent);
                }finally {
                    finish();
                }

            }
        });


    }

    void kill_activity(){finish();}

    public int getRawResIdByName(String resName) {
        String pkgName = this.getPackageName();
        // Return 0 if not found.
        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        Log.i("AndroidVideoView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }
}
