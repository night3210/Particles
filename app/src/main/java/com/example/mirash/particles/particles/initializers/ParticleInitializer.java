package com.example.mirash.particles.particles.initializers;

import com.example.mirash.particles.particles.Particle;

import java.util.Random;


public interface ParticleInitializer {

	void initParticle(Particle p, Random r);

}
