package com.tyss.tourandtravels.service;

import java.util.List;

import com.tyss.tourandtravels.dto.LocationDto;
import com.tyss.tourandtravels.dto.TourPackageDto;

public interface LocationService {

	LocationDto saveLocation(LocationDto locationDto);

	List<LocationDto> getAllLocation();

	List<TourPackageDto> chooseLocation(Integer locationId);

}
