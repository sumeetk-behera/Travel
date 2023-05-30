package com.tyss.tourandtravels.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.tourandtravels.constant.ExceptionConstant;
import com.tyss.tourandtravels.dto.LoginDto;
import com.tyss.tourandtravels.dto.UserDto;
import com.tyss.tourandtravels.entity.User;
import com.tyss.tourandtravels.exception.AccountNotFoundException;
import com.tyss.tourandtravels.exception.LoginFailedException;
import com.tyss.tourandtravels.exception.UserFoundException;
import com.tyss.tourandtravels.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto login(LoginDto loginDto) {
		Optional<User> findByEmail = Optional.ofNullable(userRepository.findByEmail(loginDto.getEmail())
				.orElseThrow(() -> new AccountNotFoundException(ExceptionConstant.ACCOUNT_NOT_FOUND)));

		if (findByEmail.isPresent() && findByEmail.get().getPassword().equals(loginDto.getPassword())) {
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(findByEmail.get(), userDto);
			return userDto;
		}
		throw new LoginFailedException(ExceptionConstant.LOGIN_FAILED);
	}

	@Override
	public UserDto register(UserDto userDto) {
		Optional<User> findByEmail = userRepository.findByEmail(userDto.getEmail());
		if (findByEmail.isEmpty()) {
			User user = new User();
			BeanUtils.copyProperties(userDto, user);
			User save = userRepository.save(user);
			BeanUtils.copyProperties(save, userDto);
			return userDto;
		}
		throw new UserFoundException(ExceptionConstant.USER_DUPLICATE_ENTRY);
	}
}
