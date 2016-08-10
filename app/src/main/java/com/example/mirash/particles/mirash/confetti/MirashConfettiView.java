package com.example.mirash.particles.mirash.confetti;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import com.example.mirash.particles.R;
import com.example.mirash.particles.particles.ParticleSystem;
import com.example.mirash.particles.particles.modifiers.ConfettiSpeedModifierY;

/**
 * @author Mirash
 */
public class MirashConfettiView extends FrameLayout {

    private ParticleSystem ps;

    public MirashConfettiView(Context context) {
        this(context, null);
    }

    public MirashConfettiView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MirashConfettiView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                long dura = 5000l;
                int count = 10;
                ps = new ParticleSystem((Activity) getContext(), count,
                        new int[]{
                                R.drawable.ic_launcher,
                                R.drawable.confeti2,
                                R.drawable.star,
                                R.drawable.star_white,
                                R.drawable.star_pink
                        }, dura, android.R.id.content);
                ps.setScaleRange(0.3f, 1.3f);
                ps.setSpeedModuleAndAngleRange(0.1f, 0.7f, -45, -135);
                ps.setRotationSpeedZ(760, 3000);
//                ps.setRotationSpeedRange(-15, 15);
//                ps.setFadeOut(dura);
                ps.addModifier(new ConfettiSpeedModifierY(0.001f, 1));
                ps.oneShot((int) event.getX(), (int) event.getY(), count, null);

                break;
/*            case MotionEvent.ACTION_MOVE:
                ps.updateEmitPoint((int) event.getX(), (int) event.getY());
                break;
            case MotionEvent.ACTION_UP:
                ps.stopEmitting();
                break;*/
        }
        return true;
    }
}
