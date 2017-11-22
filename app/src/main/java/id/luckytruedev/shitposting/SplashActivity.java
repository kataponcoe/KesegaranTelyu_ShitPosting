package id.luckytruedev.shitposting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.gms.ads.AdListener;

/**
 * Created by Kucing Item Putih on 18/09/17.
 */

public class SplashActivity extends Activity {

    //Set waktu lama splashscreen
    private static int splashInterval = 4000;
    private ShitMutipleTag admobApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splash_main);

        admobApp = (ShitMutipleTag) getApplication();
        admobApp.createWallAd();
        admobApp.requestNewInterstitial();

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {

                if(admobApp.isAdLoaded()){
                    admobApp.displayLoadedAd();
                    admobApp.mInterstitialAd.setAdListener(new AdListener() {
                        @Override
                        public void onAdClosed() {
                            Intent i = new Intent(SplashActivity.this, MainActivity.class);
                            startActivity(i);
                        }
                    });


                } else {
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                }


                //selesai Splashscreen
                this.finish();
            }

            private void finish() {
                // TODO Auto-generated method stub

            }
        }, splashInterval);

    };

}