package com.betverdict.berverdict.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betverdict.berverdict.entities.Admin;
import com.betverdict.berverdict.repositories.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public List<Admin> getAllAdmin() {

		return adminRepository.findAll();
	}

}
