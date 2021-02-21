package com.abnuj.targetiascoachinggovermentjobpreperationapp.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.abnuj.targetiascoachinggovermentjobpreperationapp.R;
import com.abnuj.targetiascoachinggovermentjobpreperationapp.databinding.ActivityMainBinding;
import com.abnuj.targetiascoachinggovermentjobpreperationapp.databinding.SplashLayoutBinding;

import static java.lang.Thread.sleep;

public class SplashScreen extends AppCompatActivity {
    SplashLayoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SplashLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        enableFullScreenMode();
        setAnimationonui();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    sleep(3500);

                }catch (Exception exception)
                {
                    exception.printStackTrace();
                }
                finally {

                    startActivity(new Intent(SplashScreen.this,LoginActivity.class));
                    finish();
                }
            }
        });

        thread.start();

    }

    private void setAnimationonui() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.custom_animatin);
        animation.setDuration(2500);
        binding.constraintLayout.setAlpha(0);
        binding.constraintLayout.animate().alpha(1).setDuration(2000);
        binding.splashTitle.startAnimation(animation);
        binding.splashDesc.startAnimation(animation);
    }

    private void enableFullScreenMode() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            final WindowInsetsController controller = getWindow().getInsetsController();
            if (controller != null)
                controller.hide(WindowInsets.Type.statusBars());
        } else {
            //noinspection deprecation
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_IMMERSIVE
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        }
    }

}