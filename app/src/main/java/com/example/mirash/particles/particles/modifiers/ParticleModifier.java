package com.example.mirash.particles.particles.modifiers;

import com.example.mirash.particles.particles.Particle;

public interface ParticleModifier {

	/**
	 * modifies the specific value of a particle given the current miliseconds
	 * @param particle
	 * @param miliseconds
	 */
	void apply(Particle particle, long miliseconds);

}
