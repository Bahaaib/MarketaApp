package com.example.bahaa.marketa;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class SplashScreen extends AppCompatActivity {

    ProgressBar progressBar;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        StartSplashAnimations();  // Start Activity animation as described below
        new ProgressBarTask().execute();  //Execute the Progress Bar progression & App lifetime delay


    }

    private void StartSplashAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        RelativeLayout splashLayout = (RelativeLayout) findViewById(R.id.splash_layout);
        splashLayout.clearAnimation();
        splashLayout.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView appLogo = (ImageView) findViewById(R.id.app_logo);
        appLogo.clearAnimation();
        appLogo.startAnimation(anim);

    }

    class ProgressBarTask extends AsyncTask<Void, Integer, String> {
        @Override
        protected String doInBackground(Void... params) {
            for (; count <= 100; count++) {
                try {
                    Thread.sleep(100);   //Freeze UI Thread for 100 millisecond at each loop
                    publishProgress(count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Task Completed.";
        }

        @Override
        protected void onPostExecute(String result) {

            // Move to MainActivity once Progress Bar completed
            Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(mainIntent);
            finish();

        }
        @Override
        protected void onProgressUpdate(Integer... values) {

            progressBar.setProgress(values[0]); //Feed the Progress Bar with time
        }
    }


}

