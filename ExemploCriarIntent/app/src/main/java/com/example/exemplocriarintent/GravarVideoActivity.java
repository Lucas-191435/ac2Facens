package com.example.exemplocriarintent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class GravarVideoActivity extends AppCompatActivity {
    VideoView videoView;
    ActivityResultLauncher<Intent> gravarVideoResultLaucher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent intent = result.getData();
                        Uri videoUri = intent.getData();
                        MediaController media = new MediaController(GravarVideoActivity.this);
                        videoView.setMediaController(media);
                        videoView.setVideoURI(videoUri);
                        videoView.start();
                    }
                }
            }
    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravar_video);
        videoView = (VideoView)findViewById(R.id.videoView);
    }

    public void btnGravarVideoClick (View view){
        Intent intentGravarVideo = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        // if(intentCapturarFoto.resolveActivity(getPackageManager()) != null){
        gravarVideoResultLaucher.launch(intentGravarVideo);
        //}
    }
}