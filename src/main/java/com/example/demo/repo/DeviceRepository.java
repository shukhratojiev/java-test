package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    
    List<Device> findAllByDeviceType(String deviceType);
    boolean existsBySerialNumber(String serialNumber);
}
