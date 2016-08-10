package com.example.mirash.particles;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mirash.particles.example.AnimatedParticlesExampleActivity;
import com.example.mirash.particles.example.ConfettiExampleActivity;
import com.example.mirash.particles.example.DustExampleActivity;
import com.example.mirash.particles.example.EmiterBackgroundSimpleExampleActivity;
import com.example.mirash.particles.example.EmiterIntermediateExampleActivity;
import com.example.mirash.particles.example.EmiterSimpleExampleActivity;
import com.example.mirash.particles.example.EmiterTimeLimitedExampleActivity;
import com.example.mirash.particles.example.EmiterWithGravityExampleActivity;
import com.example.mirash.particles.example.FireworksExampleActivity;
import com.example.mirash.particles.example.FollowCursorExampleActivity;
import com.example.mirash.particles.example.OneShotAdvancedExampleActivity;
import com.example.mirash.particles.example.OneShotSimpleExampleActivity;
import com.example.mirash.particles.example.StarsExampleActivity;
import com.example.mirash.particles.mirash.confetti.AmirashActivity;

public class ExampleListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String sampleList[] = new String[]{
                "One Shot Simple"
                , "One Shot Advanced"
                , "Emiter Simple"
                , "Emiting on background [NEW]"
                , "Emiter Intermediate"
                , "Emiter Time Limited"
                , "Emit with Gravity [NEW]"
                , "Follow touch [NEW]"
                , "Animated particles"
                , "Fireworks"
                , "Confetti [Rabbit and Eggs]"
                , "Dust [Rabbit and Eggs]"
                , "Stars [Rabbit and Eggs]"
                , "Mirash touch"
//                , "Mirash SnowFall"
        };
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sampleList));
        startDefault();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch (position) {
            case 0:
                startActivity(new Intent(this, OneShotSimpleExampleActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, OneShotAdvancedExampleActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, EmiterSimpleExampleActivity.class));
                break;
            case 3:
                startActivity(new Intent(this, EmiterBackgroundSimpleExampleActivity.class));
                break;
            case 4:
                startActivity(new Intent(this, EmiterIntermediateExampleActivity.class));
                break;
            case 5:
                startActivity(new Intent(this, EmiterTimeLimitedExampleActivity.class));
                break;
            case 6:
                startActivity(new Intent(this, EmiterWithGravityExampleActivity.class));
                break;
            case 7:
                startActivity(new Intent(this, FollowCursorExampleActivity.class));
                break;
            case 8:
                startActivity(new Intent(this, AnimatedParticlesExampleActivity.class));
                break;
            case 9:
                startActivity(new Intent(this, FireworksExampleActivity.class));
                break;
            case 10:
                startActivity(new Intent(this, ConfettiExampleActivity.class));
                break;
            case 11:
                startActivity(new Intent(this, DustExampleActivity.class));
                break;
            case 12:
                startActivity(new Intent(this, StarsExampleActivity.class));
                break;
            case 13:
                startActivity(new Intent(this, AmirashActivity.class));
                break;
            case 14:
                break;
        }
    }

    private void startDefault() {
        startActivity(new Intent(this, AmirashActivity.class));
    }

}
