package com.tyss.tourandtravels.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.tourandtravels.constant.ExceptionConstant;
import com.tyss.tourandtravels.dto.FeedBackDto;
import com.tyss.tourandtravels.entity.FeedBack;
import com.tyss.tourandtravels.entity.Location;
import com.tyss.tourandtravels.entity.User;
import com.tyss.tourandtravels.exception.AccountNotFoundException;
import com.tyss.tourandtravels.exception.LocationsNotFoundException;
import com.tyss.tourandtravels.exception.SomethingWentWrongException;
import com.tyss.tourandtravels.repository.FeedBackRepository;
import com.tyss.tourandtravels.repository.LocationRepository;
import com.tyss.tourandtravels.repository.UserRepository;

@Service
public class FeedBackServiceImpl implements FeedBackService {

	@Autowired
	private FeedBackRepository feedbackRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public FeedBackDto saveFeedback(FeedBackDto dto) {
		Optional<Location> findByLocationId = Optional.ofNullable(locationRepository.findById(dto.getLocationId())
				.orElseThrow(() -> new LocationsNotFoundException(ExceptionConstant.LOCATION_NOT_FOUND)));

		Optional<User> findByEmail = Optional.ofNullable(userRepository.findByEmail(dto.getEmail())
				.orElseThrow(() -> new AccountNotFoundException(ExceptionConstant.ACCOUNT_NOT_FOUND)));

		List<FeedBack> feedBackList = new ArrayList<>();
		if (!findByLocationId.isEmpty() && findByEmail.isPresent()) {
			Location location = findByLocationId.get();
			User user = findByEmail.get();

			FeedBack feedback = new FeedBack();
			BeanUtils.copyProperties(dto, feedback);
			feedBackList.add(feedback);

			location.setFeedBackList(feedBackList);
			user.setFeedBackList(feedBackList);

			List<FeedBack> feedBackList2 = location.getFeedBackList();
			feedBackList2.forEach(feed -> {
				feed.setLocation(location);
				feed.setUser(user);
			});
			feedbackRepository.saveAll(feedBackList2);
			BeanUtils.copyProperties(feedback, dto);
			return dto;
		}
		throw new SomethingWentWrongException(ExceptionConstant.SOMETHING_WENT_WRONG);
	}

}
