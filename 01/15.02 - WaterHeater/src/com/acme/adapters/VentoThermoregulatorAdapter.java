package com.acme.adapters;

import com.acme.thermoregulator.ThermoregulatorDevice;
import com.ventoelectrics.waterheater.VentoThermoregulator;

public class VentoThermoregulatorAdapter implements VentoThermoregulator {

	private ThermoregulatorDevice thermoregulator;

	public VentoThermoregulatorAdapter(ThermoregulatorDevice t) {
		this.thermoregulator = t;
	}

	@Override
	public void enablePower() {
		thermoregulator.enablePower();
	}

	@Override
	public void disablePower() {
		thermoregulator.disablePower();
	}

	@Override
	public void setTemperature(Integer temperature) {
		thermoregulator.setTemperature(temperature);
	}

}
