package com.fdmgroup.services;

import org.springframework.stereotype.Service;

import com.fdmgroup.models.Car;
import com.fdmgroup.repositories.CarRepository;

@Service
public class CarServiceImpl implements CarService {
	private CarRepository carRepository;

	public CarServiceImpl(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public Car addCar(Car newCar) {
		return this.carRepository.save(newCar);
	}
	
	public void deleteCar(String model) {
		Car foundCar = this.findCarByModel(model);
		this.carRepository.delete(foundCar);
	}

	public Car findCarByModel(String model) {
		return this.carRepository.findByModel(model);
	}

	public Iterable<Car> getAllCars() {
		return this.carRepository.findAll();
	
	}

	public void deleteCar(Long id) {
		this.carRepository.deleteById(id);		
	}

	public Car findById(Long id) {
		return this.carRepository.findById(id).orElse(null);
	}

	public Iterable<Car> findCarsByModel(String model) {
		return this.carRepository.findAllByModel(model);
	}


}
