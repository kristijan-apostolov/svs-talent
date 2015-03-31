package com.acme.adapters;

import com.acme.thermometer.ThermometerDevice;
import com.ventoelectrics.waterheater.VentoThermometer;

public class VentoThermometerAdapter implements ThermometerDevice {

	private VentoThermometer thermometer;

	public VentoThermometerAdapter(VentoThermometer thermometer) {
		this.thermometer = thermometer;
	}

	public Integer getTemperature() {
		return thermometer.getTemperature();
	}

}
