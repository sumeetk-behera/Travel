package com.tyss.tourandtravels.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.tourandtravels.constant.ExceptionConstant;
import com.tyss.tourandtravels.dto.TourPackageDto;
import com.tyss.tourandtravels.entity.Location;
import com.tyss.tourandtravels.entity.TourPackage;
import com.tyss.tourandtravels.exception.LocationsNotFoundException;
import com.tyss.tourandtravels.exception.PackageAlreadyPresentException;
import com.tyss.tourandtravels.repository.LocationRepository;
import com.tyss.tourandtravels.repository.TourPackageRepository;

@Service
public class TourPackageServiceImpl implements TourPackageService {

	@Autowired
	private TourPackageRepository packageRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public TourPackageDto savePackage(TourPackageDto dto) {
		Optional<Location> findByLocationName = Optional
				.ofNullable(locationRepository.findByLocationName(dto.getLocationName())
						.orElseThrow(() -> new LocationsNotFoundException(ExceptionConstant.LOCATION_NOT_FOUND)));

		List<TourPackage> packageList = new ArrayList<>();

		if (findByLocationName.isPresent()) {
			Location location = findByLocationName.get();
			TourPackage tourPackage = new TourPackage();
			BeanUtils.copyProperties(dto, tourPackage);
			packageList.add(tourPackage);
			location.setPackagesList(packageList);

			List<TourPackage> packageList1 = location.getPackagesList();
			packageList1.forEach(pack -> pack.setLocation(location));
			packageRepository.saveAll(packageList1);
			BeanUtils.copyProperties(tourPackage, dto);
			return dto;
		}
		throw new PackageAlreadyPresentException(ExceptionConstant.PACKAGE_DUPLICATE_ENTRY);
	}

}
