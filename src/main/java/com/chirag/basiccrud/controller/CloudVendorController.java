package com.chirag.basiccrud.controller;

import com.chirag.basiccrud.exception.VendorNotFoundException;
import com.chirag.basiccrud.model.CloudVendor;
import com.chirag.basiccrud.service.CloudVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

    @Autowired
    CloudVendorService cloudVendorService;
    @GetMapping("/{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
        return cloudVendorService.getCloudVendor(vendorId);
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        return cloudVendorService.createCloudVendor(cloudVendor);
    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        return cloudVendorService.updateCloudVendor(cloudVendor);
    }
    @DeleteMapping("/{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        return cloudVendorService.deleteCloudVendor(vendorId);
    }

    @GetMapping
    public List<CloudVendor> getAllCloudVendors(){
        return cloudVendorService.getAllCloudVendors();
    }
}
