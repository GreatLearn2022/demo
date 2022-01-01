package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	@ResponseBody
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/hello/path1/{name}")
	@ResponseBody
	public String helloPathVariable(@PathVariable String name) {
//		return String.format("Hello %s!", name);
		return "name: " + name;
	}

	@GetMapping("/hello/req")
	@ResponseBody
	public String helloRequestVariable(@RequestParam String name) {
		return "name: " + name;
	}

	@GetMapping({"/hello/path", "/hello/path/{name}"})
	@ResponseBody
	public String helloPathVariableOptional(@PathVariable String name) {
		return "name: " + name;
	}

	@GetMapping("/hello1")
	ResponseEntity<String> hello1() {
		return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}


}
