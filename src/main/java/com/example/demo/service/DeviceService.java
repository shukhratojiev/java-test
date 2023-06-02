package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ItemAlreadyExistsException;
import com.example.demo.model.Device;
import com.example.demo.repo.DeviceRepository;


@Service
public class DeviceService {

    @Autowired
    private DeviceRepository repo;

    public List<Device> getAllDevices() {
        return repo.findAll();
    }

    public List<Device> getAllDevicesByType(String deviceType) {
        return repo.findAllByDeviceType(deviceType);
    }

    public Device getDeviceById(Long id) throws NotFoundException {
        Optional<Device> device = repo.findById(id);
        
        if (device.isEmpty()) {
            throw new NotFoundException();
        }
      
        return device.get();
    }

    public Device save(Device received) throws ItemAlreadyExistsException {

        if (repo.existsBySerialNumber(received.getSerialNumber())) {
            throw new ItemAlreadyExistsException("Product with this serial number already exists");
        }
        return repo.saveAndFlush(received);
    }

    public Device update(Long id, Device received) throws NotFoundException, ItemAlreadyExistsException {
        
        Device device = getDeviceById(id);     

        if(!device.getDeviceType().equals(received.getDeviceType())) {
            throw new ItemAlreadyExistsException("You can not change type of the product");
        }

        return repo.saveAndFlush(received);
    }   
    
    public void delete(Long id) throws NotFoundException {
        
        Device device = getDeviceById(id);
        repo.delete(device);
    }
}
