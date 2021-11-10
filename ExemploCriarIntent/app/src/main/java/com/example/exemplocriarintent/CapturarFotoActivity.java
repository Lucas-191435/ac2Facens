package com.example.exemplocriarintent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class CapturarFotoActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> capturarFotoResultLaucher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent intent = result.getData();
                        Bundle bundle = intent.getExtras();
                        Bitmap imagem = (Bitmap)bundle.get("data");
                        imgVisualizacao.setImageBitmap(imagem);
                    }
                }
            }
    );
    ImageView imgVisualizacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capturar_foto);
        imgVisualizacao = (ImageView)findViewById(R.id.imgVisualizacao);
    }

    public void btnCapturarImagemClick (View view){
        Intent intentCapturarFoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
       // if(intentCapturarFoto.resolveActivity(getPackageManager()) != null){
            capturarFotoResultLaucher.launch(intentCapturarFoto);
        //}
    }

}