package com.example.mirash.particles.particles;

import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.Log;

import com.example.mirash.particles.particles.modifiers.ParticleModifier;

import java.util.List;

public class Particle {

    public float x;
    public float y;
    public float scale = 1f;
    public int alpha = 255;
    public float rotation0;
    public float rotationSpeed;

    protected float x0;
    protected float y0;
    public float speedX0;
    public float speedY0;
    public float speedX;
    protected float speedY;
    public float accelerationX;
    public float accelerationY;

    protected Bitmap image;
    protected Matrix matrix;
    protected Paint paint;

    protected float rotation;
    protected float rotationZ;
    protected float rotationAngleZ;

    protected long lifeTime;

    protected long startMilliseconds;

    protected int halfWidth;
    protected int halfHeight;

    protected List<ParticleModifier> modifiers;


    protected Particle() {
        matrix = new Matrix();
        paint = new Paint();
    }

    public Particle(Bitmap bitmap) {
        this();
        image = bitmap;
    }

    public void init() {
        scale = 1;
        alpha = 255;

        speedX = 0;
        accelerationX = 0;

//        accelerationY = 0.0001f;
//        speedY = -0.25f;
    }

    public void configure(long timeToLive, float emiterX, float emiterY) {
        halfWidth = image.getWidth() / 2;
        halfHeight = image.getHeight() / 2;

        x0 = emiterX - halfWidth;
        y0 = emiterY - halfHeight;
        x = x0;
        y = y0;

        lifeTime = timeToLive;
    }

    public boolean update(long miliseconds) {
        long realMilliseconds = miliseconds - startMilliseconds;
        if (realMilliseconds > lifeTime) {
            return false;
        }
        Log.d("LOL", "update:" + y0 + ", " + speedY + ", " + accelerationY);
        x = x0 + speedX * realMilliseconds + accelerationX * realMilliseconds * realMilliseconds;
        y = y0 + speedY * realMilliseconds;
        rotation = rotation0 + rotationSpeed * realMilliseconds / 1000;

        float interpolatedTime = realMilliseconds / (float) lifeTime;
        rotationZ = rotationAngleZ * interpolatedTime;
        for (int i = 0; i < modifiers.size(); i++) {
            modifiers.get(i).apply(this, realMilliseconds);
        }
        return true;
    }

    public void setRotationAngleZ(float angle) {
        rotationAngleZ = angle;
    }

    public void draw(Canvas c) {
        matrix.reset();
        if (rotationAngleZ != 0) {
            rotate3d();
        }
        paint.setAlpha(alpha);
        matrix.postTranslate(x, y);
        matrix.postRotate(rotation, halfWidth, halfHeight);
        matrix.postScale(scale, scale, halfWidth, halfHeight);
        c.drawBitmap(image, matrix, paint);
    }

    private void rotate3d() {
        Camera camera = new Camera();
        camera.save();
        camera.rotateX(rotationZ);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-halfWidth, -halfHeight);
        matrix.postTranslate(halfWidth, halfHeight);
    }

    public Particle activate(long startingMilisecond, List<ParticleModifier> modifiers) {
        startMilliseconds = startingMilisecond;
        // We do store a reference to the list, there is no need to copy, since the modifiers do not carte about states
        this.modifiers = modifiers;
        return this;
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public int getHalfHeight() {
        return halfHeight;
    }

    public int getHalfWidth() {
        return halfWidth;
    }

    public void setSpeedY0(float speedY0) {
        this.speedY0 = speedY0;
        setSpeedY(speedY0);
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public float getSpeedX0() {
        return speedX0;
    }

    public float getSpeedY0() {
        return speedY0;
    }

    public float getSpeedX() {
        return speedX;
    }

    public float getSpeedY() {
        return speedY;
    }
}
