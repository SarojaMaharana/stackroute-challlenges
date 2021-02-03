package com.stackroute.springelasticdemo.controller;

import com.stackroute.springelasticdemo.model.Customer;
import com.stackroute.springelasticdemo.repository.CustomerRepository;

import com.stackroute.springelasticdemo.service.QueryDSLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    QueryDSLService queryDSLService;

    @PostMapping("/saveCustomer")
    public ResponseEntity<?> saveCustomer(@RequestBody List<Customer> customer) {
        return new ResponseEntity<>(customerRepository.saveAll(customer), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/firstname/{fName}")
    public ResponseEntity<?> findByFirstName(@PathVariable String fName) {
        return new ResponseEntity<>(customerRepository.findByfName(fName), HttpStatus.OK);
    }

    @GetMapping("/searchmulti/{fName}/{age}")
    public ResponseEntity<?> searchByMultiFeild(@PathVariable("fName") String fName, @PathVariable("age") int age) {
        return new ResponseEntity<>(queryDSLService.searchMultiField(fName, age), HttpStatus.OK);
    }
}
