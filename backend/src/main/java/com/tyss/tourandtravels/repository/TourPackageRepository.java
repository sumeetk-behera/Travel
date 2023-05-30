package com.tyss.tourandtravels.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.tourandtravels.entity.TourPackage;

public interface TourPackageRepository extends JpaRepository<TourPackage, Integer> {

	Optional<TourPackage> findByPackName(String packName);

//	Optional<TourPackage> findByLocationId(Integer locationId);

//	List<TourPackage> findByLocationNameAndLocationId(String name, Integer id);
	
	List<TourPackage> findByLocationId(Integer locationId);

}
