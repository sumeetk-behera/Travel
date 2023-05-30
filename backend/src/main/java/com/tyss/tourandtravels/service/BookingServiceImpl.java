package com.tyss.tourandtravels.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.tourandtravels.constant.ExceptionConstant;
import com.tyss.tourandtravels.dto.BookingDto;
import com.tyss.tourandtravels.entity.Booking;
import com.tyss.tourandtravels.entity.Location;
import com.tyss.tourandtravels.entity.User;
import com.tyss.tourandtravels.exception.AccountNotFoundException;
import com.tyss.tourandtravels.exception.LocationsNotFoundException;
import com.tyss.tourandtravels.exception.SomethingWentWrongException;
import com.tyss.tourandtravels.repository.BookingRepository;
import com.tyss.tourandtravels.repository.LocationRepository;
import com.tyss.tourandtravels.repository.UserRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public BookingDto bookTour(BookingDto bookingDto) {
		Optional<Location> findByLocationName = Optional
				.ofNullable(locationRepository.findByLocationName(bookingDto.getLocationName())
						.orElseThrow(() -> new LocationsNotFoundException(ExceptionConstant.LOCATION_NOT_FOUND)));

		Optional<User> findByEmail = Optional.ofNullable(userRepository.findByEmail(bookingDto.getEmail())
				.orElseThrow(() -> new AccountNotFoundException(ExceptionConstant.ACCOUNT_NOT_FOUND)));

		List<Booking> bookingList = new ArrayList<>();
		if (findByLocationName.isPresent() && findByEmail.isPresent()) {
			Location location = findByLocationName.get();
			User user = findByEmail.get();
			Booking booking = new Booking();
			BeanUtils.copyProperties(bookingDto, booking);
			bookingList.add(booking);

			location.setBookingList(bookingList);
			user.setBookingList(bookingList);

			List<Booking> bookingList2 = user.getBookingList();
			bookingList2.forEach(book -> {
				book.setLocation(location);
				book.setUser(user);
				bookingRepository.saveAll(bookingList2);
			});
			BeanUtils.copyProperties(booking, bookingDto);
			return bookingDto;
		}
		throw new SomethingWentWrongException(ExceptionConstant.SOMETHING_WENT_WRONG);
	}

}
