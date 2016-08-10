package com.example.mirash.particles.particles.modifiers;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

import com.example.mirash.particles.particles.Particle;

public class ScaleModifier implements ParticleModifier {

	private float mInitialValue;
	private float mFinalValue;
	private long mEndTime;
	private long mStartTime;
	private long mDuration;
	private float mValueIncrement;
	private Interpolator mInterpolator;

	public ScaleModifier (float initialValue, float finalValue, long startMilis, long endMilis, Interpolator interpolator) {
		mInitialValue = initialValue;
		mFinalValue = finalValue;
		mStartTime = startMilis;
		mEndTime = endMilis;
		mDuration = mEndTime - mStartTime;
		mValueIncrement = mFinalValue-mInitialValue;
		mInterpolator = interpolator;
	}
	
	public ScaleModifier (float initialValue, float finalValue, long startMilis, long endMilis) {
		this (initialValue, finalValue, startMilis, endMilis, new LinearInterpolator());
	}
	
	@Override
	public void apply(Particle particle, long miliseconds) {
		if (miliseconds < mStartTime) {
			particle.scale = mInitialValue;
		}
		else if (miliseconds > mEndTime) {
			particle.scale = mFinalValue;
		}
		else {
			float interpolaterdValue = mInterpolator.getInterpolation((miliseconds- mStartTime)*1f/mDuration);
			float newScale = mInitialValue + mValueIncrement*interpolaterdValue;
			particle.scale = newScale;
		}
	}

}
