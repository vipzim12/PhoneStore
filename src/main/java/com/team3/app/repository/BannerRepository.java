package com.team3.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team3.app.entities.Banner;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Integer>{

	
}
