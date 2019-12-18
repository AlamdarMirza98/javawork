package com.fdmgroup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.models.Car;
import com.fdmgroup.services.CarService;

@Controller
public class CarController {
	private CarService carService;

	public CarController(CarService carService) {
		this.carService = carService;
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	

@GetMapping("/register")
public String register() {
	return "register";
	}

	@PostMapping("/register")
	public String register(@RequestParam String brand, @RequestParam String model, @RequestParam String color,
			@RequestParam double price, ModelMap map) {
		Car newCar = new Car(brand, model, color, price);
		this.carService.addCar(newCar);
		Iterable<Car> result = this.carService.getAllCars();
		map.addAttribute("cars", result);
		return "all-cars";
	}

	@GetMapping("/all-cars")
	public String getAllCars(ModelMap map) {
		Iterable<Car> result = this.carService.getAllCars();
		map.addAttribute("cars", result);
		return "all-cars";
	}
	
	@GetMapping("/delete")
	public String deleteCar(@RequestParam Long id, ModelMap map) {
		this.carService.deleteCar(id);
		Iterable<Car> result = this.carService.getAllCars();
		map.addAttribute("cars", result);
		return "all-cars";
	}
	
	@GetMapping("/edit")
	public String updateCar(@RequestParam Long id, ModelMap map) {
		Car car = this.carService.findById(id);
		map.addAttribute("car", car);
		return "edit-car";
	}
	
	@PostMapping("/edit")
	public String updateCar(@RequestParam Long id, 
			@RequestParam String brand,
			@RequestParam String model, 
			@RequestParam String color, 
			@RequestParam double price, ModelMap map) {
		Car car = new Car(brand, model, color, price);
		car.setId(id);
		this.carService.addCar(car);
		Iterable<Car> cars =this.carService.getAllCars();
		map.addAttribute("cars", cars);
		return "all-cars";
	}
	
	@GetMapping("/search")
	public String searchCar(@RequestParam String model, ModelMap map) {
		Iterable<Car> cars = this.carService.findCarsByModel(model);
		map.addAttribute("cars", cars);
		return "search";
	}

}