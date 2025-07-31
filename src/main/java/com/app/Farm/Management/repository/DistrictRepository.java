package com.app.Farm.Management.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Farm.Management.entity.District;
@Repository
public interface DistrictRepository extends JpaRepository<District, UUID>{

	List<District> findByStateId(UUID id);

}
 