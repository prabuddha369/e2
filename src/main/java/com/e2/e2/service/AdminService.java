package com.e2.e2.service;

import com.e2.e2.entity.Admin;
import com.e2.e2.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends BaseService<Admin, AdminRepository> {
    public AdminService(AdminRepository repo) { super(repo); }
}
