package com.chirag.basiccrud.service.impl;

import com.chirag.basiccrud.exception.CloudVendorNotFoundException;
import com.chirag.basiccrud.exception.VendorNotFoundException;
import com.chirag.basiccrud.model.CloudVendor;
import com.chirag.basiccrud.repository.CloudVendorRepository;
import com.chirag.basiccrud.service.CloudVendorService;
import io.micrometer.observation.annotation.Observed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    @Autowired
    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    @Observed(name = "create.vendors")
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        if(cloudVendorRepository.findById(cloudVendor.getVendorId()).isEmpty())
            throw new CloudVendorNotFoundException("Requested cloud vendor does not exist");
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String vendorId) {
        if(cloudVendorRepository.findById(vendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested cloud vendor does not exist");
        cloudVendorRepository.deleteById(vendorId);
        return "Success";
    }

    @Observed(name = "get.vendor")
    @Override
    public CloudVendor getCloudVendor(String vendorId){
        if(cloudVendorRepository.findById(vendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested cloud vendor does not exist");
        return cloudVendorRepository.findById(vendorId).get();
    }

    @Observed(name = "get.vendors")
    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }
}
