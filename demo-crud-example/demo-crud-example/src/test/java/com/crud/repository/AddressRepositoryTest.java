package com.crud.repository;

import com.crud.entity.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AddressRepositoryTest {
    @Autowired
    AddressRepository addressRepository;

    @Test
    public void findByStateTest(){
        List<Address> addresses = addressRepository.findByStateContaining("Maharashtra");
        System.out.println(addresses);
    }

}