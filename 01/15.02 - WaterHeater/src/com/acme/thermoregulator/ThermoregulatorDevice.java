package com.acme.thermoregulator;

public interface ThermoregulatorDevice {

	public void enablePower();

	public void disablePower();

	public void setTemperature(Integer t);
}
