package com.example.exemplomultithread;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ExemploAsyncTaskActivity extends AppCompatActivity {
    ProgressDialog progress;
    ImageView img1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo_async_task);
        img1 = (ImageView)findViewById(R.id.img1);
    }

    public void btnDownloadClick(View view) {
        new DownloadImagemAsync().execute("https://facens.br/wp-content/uploads/2021/05/logo-selo.jpg");
    }

    private class DownloadImagemAsync extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress = new ProgressDialog(ExemploAsyncTaskActivity.this);
            progress.setMessage("Buscando Imagem...");
            progress.setCancelable(false);
            progress.show();
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            img1.setImageBitmap(bitmap);
            progress.dismiss();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            progress.setMessage(values[0]);
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap img = null;
            try {
              img = Utils.downloadImagem(strings[0]);
              publishProgress("Imagem lida com sucesso!");
            }
            catch (Exception ex){}
            return img;
        }
    }
}