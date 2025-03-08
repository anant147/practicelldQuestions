package com.practice.lld.CarRentalSystem;

public class VehilceInventarySystemFactory {
	
	public static VehilceInventarySystem getVehilceInventarySystem(VehicleType vt) {
		if (VehicleType.BIKE.equals(vt))
			return new BikeInventarySystem();
		else if (VehicleType.CAR.equals(vt))
			return new CarInventarySystem();
		return null;
	}
}
