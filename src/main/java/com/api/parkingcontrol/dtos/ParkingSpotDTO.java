package com.api.parkingcontrol.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ParkingSpotDTO {

	@NotBlank
	private String spotId;

	@NotBlank
	private String typeVehicle;

	@NotBlank
	@Size(max = 7)
	private String registrationPlateVehicle;

	@NotBlank
	private String brandVehicle;

	@NotBlank
	private String modelVehicle;

	@NotBlank
	private String colorVehicle;
	
	@NotBlank
	private String responsibleName;


}
