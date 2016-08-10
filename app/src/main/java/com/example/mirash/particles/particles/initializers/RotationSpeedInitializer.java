package com.example.mirash.particles.particles.initializers;

import com.example.mirash.particles.particles.Particle;

import java.util.Random;

public class RotationSpeedInitializer implements com.example.mirash.particles.particles.initializers.ParticleInitializer {

	private float mMinRotationSpeed;
	private float mMaxRotationSpeed;

	public RotationSpeedInitializer(float minRotationSpeed,	float maxRotationSpeed) {
		mMinRotationSpeed = minRotationSpeed;
		mMaxRotationSpeed = maxRotationSpeed;
	}

	@Override
	public void initParticle(Particle p, Random r) {
		float rotationSpeed = r.nextFloat()*(mMaxRotationSpeed-mMinRotationSpeed) + mMinRotationSpeed;
		p.rotationSpeed = rotationSpeed;
	}

}
