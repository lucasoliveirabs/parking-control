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

	public String getSpotId() {
		return spotId;
	}

	public void setSpotId(String spotId) {
		this.spotId = spotId;
	}

	public String getTypeVehicle() {
		return typeVehicle;
	}

	public void setTypeVehicle(String typeVehicle) {
		this.typeVehicle = typeVehicle;
	}

	public String getRegistrationPlateVehicle() {
		return registrationPlateVehicle;
	}

	public void setRegistrationPlateVehicle(String registrationPlateVehicle) {
		this.registrationPlateVehicle = registrationPlateVehicle;
	}

	public String getBrandVehicle() {
		return brandVehicle;
	}

	public void setBrandVehicle(String brandVehicle) {
		this.brandVehicle = brandVehicle;
	}

	public String getModelVehicle() {
		return modelVehicle;
	}

	public void setModelVehicle(String modelVehicle) {
		this.modelVehicle = modelVehicle;
	}

	public String getColorVehicle() {
		return colorVehicle;
	}

	public void setColorVehicle(String colorVehicle) {
		this.colorVehicle = colorVehicle;
	}

	public String getResponsibleName() {
		return responsibleName;
	}

	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}
}
	