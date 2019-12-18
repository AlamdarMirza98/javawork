package com.fdmgroup.repositories;

import org.springframework.data.repository.CrudRepository;
import com.fdmgroup.models.Car;

public interface CarRepository extends CrudRepository<Car, Long>{
	public Car findByModel(String model);
	
	public Iterable <Car> findAllByModel(String model);

}

