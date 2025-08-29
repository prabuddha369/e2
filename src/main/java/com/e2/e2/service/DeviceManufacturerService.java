package com.e2.e2.service;

import com.e2.e2.entity.DeviceManufacturer;
import com.e2.e2.repository.DeviceManufacturerRepository;
import org.springframework.stereotype.Service;

@Service
public class DeviceManufacturerService extends BaseService<DeviceManufacturer, DeviceManufacturerRepository> {
    public DeviceManufacturerService(DeviceManufacturerRepository repo) { super(repo); }
}
