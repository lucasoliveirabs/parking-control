package com.api.parkingcontrol.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parkingcontrol.dtos.ParkingSpotDTO;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.services.ParkingSpotService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/parking-spot")
public class ParkingSpotController {

	private static final String PARKING_SPOT_NOT_FOUND_MESSAGE = "Parking Spot not found.";

	@Autowired
	ParkingSpotService parkingSpotService;

	@PostMapping
	public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDTO pParkingSpotDTO) {
		if (parkingSpotService.existsByRegistrationPlateVehicle(pParkingSpotDTO.getRegistrationPlateVehicle())) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Conflict: Registration Vehicle Plate is already in use.");
		}

		if (parkingSpotService.existsBySpotId(pParkingSpotDTO.getSpotId())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot is already in use.");
		}

		var parkingSpotModel = new ParkingSpotModel();
		BeanUtils.copyProperties(pParkingSpotDTO, parkingSpotModel);
		parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
	}

	@GetMapping
	public ResponseEntity<List<ParkingSpotModel>> getAllParkingSpots() {
		return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getSingleParkingSpot(@PathVariable(value = "id") UUID id) {
		Optional<ParkingSpotModel> optionalParkingSpotModel = parkingSpotService.findById(id);
		if (optionalParkingSpotModel.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(optionalParkingSpotModel.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ParkingSpotController.PARKING_SPOT_NOT_FOUND_MESSAGE);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteParkingSpot(@PathVariable(value = "id") UUID id) {
		Optional<ParkingSpotModel> optionalParkingSpotModel = parkingSpotService.findById(id);
		if (optionalParkingSpotModel.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(ParkingSpotController.PARKING_SPOT_NOT_FOUND_MESSAGE);
		}
		parkingSpotService.delete(optionalParkingSpotModel.get());
		return ResponseEntity.status(HttpStatus.OK).body("Parking Spot successfully deleted.");
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "id") UUID id,
			@RequestBody @Valid ParkingSpotDTO parkingSpotDTO) {
		Optional<ParkingSpotModel> optionalParkingSpotModel = parkingSpotService.findById(id);
		if (optionalParkingSpotModel.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(ParkingSpotController.PARKING_SPOT_NOT_FOUND_MESSAGE);
		}	
		
		var parkingSpotModel = new ParkingSpotModel();
		BeanUtils.copyProperties(parkingSpotDTO, parkingSpotModel);
		parkingSpotModel.setId(id);
		parkingSpotModel.setRegistrationDate(optionalParkingSpotModel.get().getRegistrationDate());
		
		return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModel));
	}
}