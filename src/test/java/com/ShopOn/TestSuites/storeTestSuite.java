package com.ShopOn.TestSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ShopOn.store.*;

@RunWith(Suite.class)
@SuiteClasses({CreateStoreTest.class,StoreThemeTest.class,StoreTitleTest.class,ViewOrders.class})
public class storeTestSuite {

}
