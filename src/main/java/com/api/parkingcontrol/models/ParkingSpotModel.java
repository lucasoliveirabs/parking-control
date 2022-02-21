package com.api.parkingcontrol.models;

import java.io.Serializable;
import java.util.UUID;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PARKING_SPOT")
public class ParkingSpotModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(nullable = false, unique = true, length = 10)
	private String spotId;

	@Column(nullable = false, length = 70)
	private String typeVehicle;

	@Column(nullable = false, unique = true, length = 7)
	private String registrationPlateVehicle;

	@Column(nullable = false, length = 70)
	private String brandVehicle;

	@Column(nullable = false, length = 70)
	private String modelVehicle;

	@Column(nullable = false, length = 70)
	private String colorVehicle;

	@Column(nullable = false)
	private LocalDateTime registrationDate;

	@Column(nullable = false, length = 130)
	private String responsibleName;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

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

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getResponsibleName() {
		return responsibleName;
	}

	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}