package com.chirag.basiccrud.repository;

import com.chirag.basiccrud.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {
}
