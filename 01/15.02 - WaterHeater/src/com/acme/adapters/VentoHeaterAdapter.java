package com.acme.adapters;

import com.acme.heater.HeaterDevice;
import com.ventoelectrics.waterheater.VentoHeater;

public class VentoHeaterAdapter implements HeaterDevice {

	private VentoHeater heater;

	public VentoHeaterAdapter(VentoHeater heater) {
		this.heater = heater;
	}

	public void enable() {
		heater.enable();
	}

	public void disable() {
		heater.disable();
	}

}
