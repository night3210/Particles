package com.example.mirash.particles.particles.modifiers;

import com.example.mirash.particles.particles.Particle;

public class AccelerationModifier implements com.example.mirash.particles.particles.modifiers.ParticleModifier {

	private float mVelocityX;
	private float mVelocityY;

	public AccelerationModifier(float velocity, float angle) {
		float velocityAngleInRads = (float) (angle*Math.PI/180f);
		mVelocityX = (float) (velocity * Math.cos(velocityAngleInRads));
		mVelocityY = (float) (velocity * Math.sin(velocityAngleInRads));
	}

	@Override
	public void apply(Particle particle, long miliseconds) {
		particle.x += mVelocityX*miliseconds*miliseconds;
		particle.y += mVelocityY*miliseconds*miliseconds;
	}

}
