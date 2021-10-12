package com.betverdict.berverdict.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betverdict.berverdict.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
