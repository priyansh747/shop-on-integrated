package com.ShopOn.TestSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ShopOn.test.*;

@RunWith(Suite.class)
@SuiteClasses({ChangePasswordTest.class,ChangePasswordTest1.class,BillingTest.class,ShippingTest.class})

public class MyAccountTestSuite {

}
