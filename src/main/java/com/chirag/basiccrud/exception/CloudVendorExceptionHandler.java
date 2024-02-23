package com.chirag.basiccrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CloudVendorExceptionHandler{

    @ExceptionHandler(value = {CloudVendorNotFoundException.class})
    public ResponseEntity<Object> handleCloudVendorNotFoundException(CloudVendorNotFoundException cloudVendorNotFoundException){
        CloudVendorException cloudVendorException = new CloudVendorException(
                cloudVendorNotFoundException.getMessage(),
                cloudVendorNotFoundException.getCause(),
                HttpStatus.NOT_FOUND);
        return  new ResponseEntity<>(cloudVendorException, HttpStatus.NOT_FOUND);
    }


//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(value = {VendorNotFoundException.class})
//    public ResponseEntity<Object> vendorNotFound(VendorNotFoundException vendorNotFoundException){
//        Map<String,String> map = new HashMap<>();
//        map.put("Message", vendorNotFoundException.getMessage());
//        return  new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
//    }
}
