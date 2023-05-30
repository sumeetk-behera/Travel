package com.tyss.tourandtravels.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.tourandtravels.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

	Optional<Location> findByLocationName(String locationName);

}
