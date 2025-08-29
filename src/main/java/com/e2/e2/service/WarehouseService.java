package com.e2.e2.service;

import com.e2.e2.entity.Warehouse;
import com.e2.e2.repository.WarehouseRepository;
import org.springframework.stereotype.Service;

@Service
public class WarehouseService extends BaseService<Warehouse, WarehouseRepository> {
    public WarehouseService(WarehouseRepository repo) { super(repo); }
}
