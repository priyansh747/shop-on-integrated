package com.ShopOn.TestSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ShopOn.sortByFeature.SortByDEfaultDefaultTechnologyTest;
import com.ShopOn.sortByFeature.SortByDefaultComputerBasicstTest;
import com.ShopOn.sortByFeature.SortByTechnology11test;


@RunWith(Suite.class)
@SuiteClasses({com.ShopOn.sortByFeature.SortByDefaultComputerBasicstTest.class,com.ShopOn.sortByFeature.SortByDEfaultDefaultTechnologyTest.class,com.ShopOn.sortByFeature.SortByTechnology11test.class})



public class SortByDefaultTestSuite {


}
