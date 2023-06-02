package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ItemAlreadyExistsException;
import com.example.demo.model.Device;
import com.example.demo.service.DeviceService;


@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService service;

    @GetMapping("")
    public ResponseEntity<List<Device>> getAllDevices() {
        List<Device> devices = service.getAllDevices();
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    @GetMapping("/type")
    public ResponseEntity<List<Device>> getAllDevicesByType(@RequestParam String name) {
        List<Device> devices = service.getAllDevicesByType(name);
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) throws NotFoundException {
        Device device = service.getDeviceById(id);
        return new ResponseEntity<>(device, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Device> saveNewDevice(@RequestBody Device received) throws ItemAlreadyExistsException { 
        Device created = service.save(received);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable Long id, @RequestBody Device received) throws NotFoundException, ItemAlreadyExistsException {
        Device device = service.update(id, received);
        return new ResponseEntity<>(device, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDevice(@PathVariable Long id) throws NotFoundException {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
    }  
}
