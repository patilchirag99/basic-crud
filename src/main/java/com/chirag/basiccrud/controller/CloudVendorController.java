package com.chirag.basiccrud.controller;

import com.chirag.basiccrud.model.CloudVendor;
import com.chirag.basiccrud.service.CloudVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

    @Autowired
    CloudVendorService cloudVendorService;

    @GetMapping("/home")
    public String home(){
        return "Home";
    }

    @GetMapping("/user/{vendorId}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
        return cloudVendorService.getCloudVendor(vendorId);
    }

    @PostMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        return cloudVendorService.createCloudVendor(cloudVendor);
    }

    @PutMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        return cloudVendorService.updateCloudVendor(cloudVendor);
    }
    @DeleteMapping("/admin/{vendorId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        return cloudVendorService.deleteCloudVendor(vendorId);
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<CloudVendor> getAllCloudVendors(){
        return cloudVendorService.getAllCloudVendors();
    }

}
