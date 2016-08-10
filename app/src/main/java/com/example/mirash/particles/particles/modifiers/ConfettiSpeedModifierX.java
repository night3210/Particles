package com.example.mirash.particles.particles.modifiers;

import com.example.mirash.particles.particles.Particle;

public class ConfettiSpeedModifierX implements ParticleModifier {

    private float acceleration;
    private float maxSpeed;

    public ConfettiSpeedModifierX(float accelerationY, float maxSpeedY) {
        acceleration = accelerationY;
        maxSpeed = maxSpeedY;
    }

    @Override
    public void apply(Particle particle, long miliseconds) {
/*        if (maxSpeed > particle.speedY) {
            particle.speedY += acceleration * miliseconds * miliseconds;
        }*/
    }

}
