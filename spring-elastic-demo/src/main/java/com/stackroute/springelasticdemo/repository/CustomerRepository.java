package com.stackroute.springelasticdemo.repository;

import java.util.List;

import com.stackroute.springelasticdemo.model.Customer;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {
    List<Customer> findByfName(String fName);
}
