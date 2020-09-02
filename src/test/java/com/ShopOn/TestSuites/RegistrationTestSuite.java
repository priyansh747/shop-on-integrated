package com.ShopOn.TestSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


import com.ShopOn.UserTriesToRegister.RegisterWithBlankFields_TC_17;
import com.ShopOn.UserTriesToRegister.RegisterWithEXISTINGUserDetails_TC_24;
import com.ShopOn.UserTriesToRegister.RegisterWithIncorrectConfirmPassword_TC_34;
import com.ShopOn.UserTriesToRegister.RegisterWithInvalidEmail_TC_27;
import com.ShopOn.UserTriesToRegister.RegisterWithInvalidFirstName_TC_25;
import com.ShopOn.UserTriesToRegister.RegisterWithInvalidLastName_TC_26;
import com.ShopOn.UserTriesToRegister.RegisterWithInvalidState_Province_TC_29;
import com.ShopOn.UserTriesToRegister.RegisterWithValidData_TC_14;

@RunWith(Suite.class)
@SuiteClasses({com.ShopOn.UserTriesToRegister.RegisterWithBlankFields_TC_17.class,com.ShopOn.UserTriesToRegister.RegisterWithEXISTINGUserDetails_TC_24.class,com.ShopOn.UserTriesToRegister.RegisterWithIncorrectConfirmPassword_TC_34.class,
	com.ShopOn.UserTriesToRegister.RegisterWithInvalidEmail_TC_27.class,com.ShopOn.UserTriesToRegister.RegisterWithInvalidFirstName_TC_25.class,com.ShopOn.UserTriesToRegister.RegisterWithInvalidLastName_TC_26.class,
	com.ShopOn.UserTriesToRegister.RegisterWithInvalidState_Province_TC_29.class,com.ShopOn.UserTriesToRegister.RegisterWithValidData_TC_14.class })

public class RegistrationTestSuite {

}
