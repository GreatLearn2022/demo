package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.domain.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public List<User> retriveAllUsers()
    {
        return service.findAll();
    }
    //retrieves a specific user detail
    @GetMapping("/users/{id}")
    public User retriveUser(@PathVariable int id)
    {
        return service.findOne(id);
    }

    @GetMapping("/age")
    ResponseEntity<String> age(
            @RequestParam("yearOfBirth") int yearOfBirth) {

        if (yearOfBirth>LocalDate.now().getYear()) {
            return new ResponseEntity<>(
                    "Year of birth cannot be in the future",
                    HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(
                "Your age is " + (LocalDate.now().getYear() - yearOfBirth),
                HttpStatus.OK);
    }

}
