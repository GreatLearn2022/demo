package com.example.demo;

import com.example.demo.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    //using get method and hello-world URI
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
//method- which returns "Hello World"
    public User helloWorldBean() {
        return new User("Hello World");//constructor of HelloWorldBean
    }

    //passing a path variable
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public User helloWorldPathVariable(@PathVariable String name) {
        return new User(String.format("Hello World, %s", name)); //%s replace the name
    }
}
