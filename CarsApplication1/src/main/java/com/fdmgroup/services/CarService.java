package com.fdmgroup.services;

import com.fdmgroup.models.Car;

public interface CarService {
	public Car addCar(Car newCar);

	public void deleteCar(Long id);

	public Car findCarByModel(String model);

	public Iterable<Car> getAllCars();
	
	public Car findById(Long id);
	
	public Iterable<Car> findCarsByModel(String model);

}