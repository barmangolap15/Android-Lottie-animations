package com.codewithgolap.lottieanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    boolean isCheckDone = false;
    boolean isSwitchOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // for CheckDone Lottie Animation
        final LottieAnimationView lottieCheckDone = findViewById(R.id.checkDone);
        lottieCheckDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isCheckDone){

                    //since lottie animation checked_done.json has only one animation for checked,
                    // so for unchecking animation, we will play reverse animation

                    lottieCheckDone.setSpeed(-1); // this will play reverse animation with normal speed
                    lottieCheckDone.playAnimation();
                    isCheckDone = false;
                }else {
                    lottieCheckDone.setSpeed(1); // this will play regular animation with normal speed
                    lottieCheckDone.playAnimation();
                    isCheckDone = true;
                }
            }
        });

        // for Switch Button
        final LottieAnimationView lottieSwitchButton = findViewById(R.id.switchButton);
        lottieSwitchButton.setSpeed(3f); //tis will play the animation 3 times faster
        lottieSwitchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSwitchOn){

                    //lottie animation button_switch.json has both animations for On and OFF,
                    // but it will play continuously (one after another), so we need to do is,
                    // for ON animation we will play half animation and for OFF animation,
                    // we will play the remaining hafl animation

                    lottieSwitchButton.setMinAndMaxProgress(0.5f, 1.0f); // this will play the Switch OFF animation
                    lottieSwitchButton.playAnimation();
                    isSwitchOn = false;
                }else {
                    lottieSwitchButton.setMinAndMaxProgress(0.0f, 0.5f); // this will play the Switch ON animation
                    lottieSwitchButton.playAnimation();
                    isSwitchOn = true;
                }
            }
        });
    }
}