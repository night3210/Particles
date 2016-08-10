package com.example.mirash.particles.particles.initializers;

import com.example.mirash.particles.particles.Particle;

import java.util.Random;

public class RotationZInitiazer implements ParticleInitializer {

    private float min;
    private float max;

    public RotationZInitiazer(float min, float max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public void initParticle(Particle p, Random r) {
        p.setRotationAngleZ(r.nextFloat() * (max - min) + min);
    }

}
