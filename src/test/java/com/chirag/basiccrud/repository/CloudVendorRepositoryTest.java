package com.chirag.basiccrud.repository;

import com.chirag.basiccrud.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//Lets springboot app know to use in mem database for activities
@DataJpaTest
public class CloudVendorRepositoryTest {

//given-when-then
    @Autowired
    private CloudVendorRepository cloudVendorRepository;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        cloudVendor = new CloudVendor("1","Google","USA","37267836");
        cloudVendorRepository.save(cloudVendor);
    }
    @AfterEach
    void tearDown() {
        cloudVendor=null;
        cloudVendorRepository.deleteAll();
    }
    // Success scenario
    @Test
    void testFindByVendorName_Found(){
       List<CloudVendor> list = cloudVendorRepository.findByVendorName("Google");
       assertThat(list.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
       assertThat(list.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
       assertThat(list.get(0).getPhoneNumber()).isEqualTo(cloudVendor.getPhoneNumber());
    }

    //Failure scenario
    @Test
    void testFindByVendorName_NotFound(){
        List<CloudVendor> list = cloudVendorRepository.findByVendorName("Amazon");
        assertThat(list.isEmpty()).isTrue();
    }
}
