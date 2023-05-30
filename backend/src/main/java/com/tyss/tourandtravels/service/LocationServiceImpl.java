package com.tyss.tourandtravels.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.tourandtravels.constant.ExceptionConstant;
import com.tyss.tourandtravels.dto.LocationDto;
import com.tyss.tourandtravels.dto.TourPackageDto;
import com.tyss.tourandtravels.entity.Location;
import com.tyss.tourandtravels.entity.TourPackage;
import com.tyss.tourandtravels.exception.LocationFoundException;
import com.tyss.tourandtravels.exception.LocationsNotFoundException;
import com.tyss.tourandtravels.exception.PackageNotAvailableException;
import com.tyss.tourandtravels.repository.LocationRepository;
import com.tyss.tourandtravels.repository.TourPackageRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private TourPackageRepository packageRepository;

	@Override
	public LocationDto saveLocation(LocationDto locationDto) {

		Optional<Location> findByLocationName = locationRepository.findByLocationName(locationDto.getLocationName());
		if (findByLocationName.isEmpty()) {
			Location location = new Location();
			BeanUtils.copyProperties(locationDto, location);
			Location save = locationRepository.save(location);
			BeanUtils.copyProperties(save, locationDto);
			return locationDto;
		}
		throw new LocationFoundException(ExceptionConstant.LOCATION_DUPLICATE_ENTRY);

	}

	@Override
	public List<LocationDto> getAllLocation() {
		List<Location> findAll = locationRepository.findAll();
		List<LocationDto> dtoList = new ArrayList<>();
		if (!findAll.isEmpty()) {
			findAll.forEach(loc -> {
				LocationDto dto = new LocationDto();
				BeanUtils.copyProperties(loc, dto);
				dtoList.add(dto);
			});
			return dtoList;
		}
		throw new LocationsNotFoundException(ExceptionConstant.LOCATION_NOT_FOUND);
	}

	@Override
	public List<TourPackageDto> chooseLocation(Integer locationId) {
		List<TourPackage> findByLocationName = packageRepository.findByLocationId(locationId);
		List<TourPackageDto> packageDtoList = new ArrayList<>();
		if (!findByLocationName.isEmpty()) {
			findByLocationName.forEach(pack -> {
				TourPackageDto dto = new TourPackageDto();
				BeanUtils.copyProperties(pack, dto);
				packageDtoList.add(dto);
			});
			return packageDtoList;

		}
		throw new PackageNotAvailableException(ExceptionConstant.LOCATION_PACK_NOT_FOUND);
	}

}
