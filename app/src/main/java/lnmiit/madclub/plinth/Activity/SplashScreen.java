package lnmiit.madclub.plinth.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import lnmiit.madclub.plinth.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread logoTimer = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    Log.d("Exception", "Exception" + e);
                } finally {
                        startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    overridePendingTransition(R.anim.main_activity_launch,
                            R.anim.fade_in);
                }
                finish();
            }
        };
        logoTimer.start();
    }
}
