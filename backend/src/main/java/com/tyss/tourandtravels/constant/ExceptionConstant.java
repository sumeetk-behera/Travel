package com.tyss.tourandtravels.constant;

public class ExceptionConstant {

	private ExceptionConstant() {
	}

	public static final String USER_DUPLICATE_ENTRY = "User Already present, please register a new user";
	public static final String PACKAGE_DUPLICATE_ENTRY = "Package Already present, please register a New Package";

	public static final String LOCATION_DUPLICATE_ENTRY = "Location Already present, please register a new Location";
	public static final String LOCATION_NOT_FOUND = "Locations Not Available , please try again";
	public static final String LOCATION_PACK_NOT_FOUND = "No Package Available for this location";

	public static final String LOGIN_FAILED = "failed to load user, please check your crendentials and try again";
	public static final String ACCOUNT_NOT_FOUND = "No Account found with this ID, please check and try again";
	public static final String INCORRECT_ID = "No Loaction Found With this Id, please check location Id";
	public static final String SOMETHING_WENT_WRONG = "Please try again";
}
