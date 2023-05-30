package com.tyss.tourandtravels.service;

import com.tyss.tourandtravels.dto.LoginDto;
import com.tyss.tourandtravels.dto.UserDto;

public interface UserService {

	UserDto login(LoginDto loginDto);

	UserDto register(UserDto userDto);

	
}
