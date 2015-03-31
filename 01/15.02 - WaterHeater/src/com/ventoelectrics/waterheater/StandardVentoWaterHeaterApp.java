package com.ventoelectrics.waterheater;

import com.acme.adapters.VentoHeaterAdapter;
import com.acme.adapters.VentoThermometerAdapter;
import com.acme.adapters.VentoThermoregulatorAdapter;
import com.acme.thermoregulator.AcmeStandardThermoregulator;

public class StandardVentoWaterHeaterApp {

	public static void main(String[] args) throws Exception {

		final VentoThermometer ventoThermometer = new VentoThermometer();
		final VentoHeater ventoHeater = new VentoHeater();
		final VentoPowerSwitch ventoPowerSwitch = new VentoPowerSwitch();

		// ACME standard thermoregulator instance.
		final VentoThermoregulator ventoThermoregulator = new VentoThermoregulatorAdapter(
				new AcmeStandardThermoregulator(new VentoHeaterAdapter(
						ventoHeater), new VentoThermometerAdapter(
						ventoThermometer)));

		ventoPowerSwitch.controlPowerFor(ventoThermoregulator);
		ventoPowerSwitch.controlPowerFor(ventoHeater);
		ventoPowerSwitch.controlPowerFor(ventoThermometer);

		VentoWaterHeaterApp.run(ventoThermoregulator, ventoPowerSwitch);
	}
}
