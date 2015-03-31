package com.acme.thermoregulator;

import com.acme.heater.HeaterDevice;
import com.acme.thermometer.ThermometerDevice;

public class AcmeEfficientThermoregulator extends AcmeStandardThermoregulator {

	public AcmeEfficientThermoregulator(HeaterDevice h, ThermometerDevice t) {
		super(h, t);
		sec = 1;
	}
}
