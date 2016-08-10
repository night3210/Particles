package com.example.mirash.particles.particles.modifiers;

import com.example.mirash.particles.particles.Particle;

public class ConfettiSpeedModifierY implements ParticleModifier {

    private float acceleration;
    private float maxSpeed;

    public ConfettiSpeedModifierY(float accelerationY, float maxSpeedY) {
        acceleration = accelerationY;
        maxSpeed = maxSpeedY;
    }

    @Override
    public void apply(Particle particle, long miliseconds) {
        if (maxSpeed > particle.getSpeedY()) {
            particle.setSpeedY(particle.getSpeedY0() + acceleration * miliseconds);
        }
    }

}
