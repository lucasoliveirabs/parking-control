package com.api.parkingcontrol.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;

@Service
public class ParkingSpotService {
	
	@Autowired
	ParkingSpotRepository parkingSpotRepository;

	@Transactional
	public ParkingSpotModel save(ParkingSpotModel pParkingSpotModel) {
		return parkingSpotRepository.save(pParkingSpotModel);
	}

	public boolean existsByRegistrationPlateVehicle(String pRegistrationPlateVehicle) {
		return parkingSpotRepository.existsByRegistrationPlateVehicle(pRegistrationPlateVehicle);
	}

	public boolean existsBySpotId(String pSpotId) {
		return parkingSpotRepository.existsBySpotId(pSpotId);
	}

	public List<ParkingSpotModel> findAll() {
		return parkingSpotRepository.findAll();
	}

	public Optional<ParkingSpotModel> findById(UUID pId) {
		return parkingSpotRepository.findById(pId);
	}

	@Transactional
	public void delete(ParkingSpotModel parkingSpotModel) {
		parkingSpotRepository.delete(parkingSpotModel);
	}
}
