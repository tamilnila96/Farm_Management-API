package com.app.Farm.Management.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Farm.Management.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, UUID>{

	List<State> findByCountryId(UUID id);

}
