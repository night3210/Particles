package com.example.mirash.particles.mirash.confetti;

import android.app.Activity;
import android.os.Bundle;

import com.example.mirash.particles.R;

/**
 * @author Mirash
 */
public class AmirashActivity extends Activity {
    private MirashConfettiView mirashView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mirash_activity);
        mirashView = (MirashConfettiView) findViewById(R.id.mirash_view);
    }
}
