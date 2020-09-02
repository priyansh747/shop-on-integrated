package com.ShopOn.TestSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ShopOn.contentManagement.*;

@RunWith(Suite.class)
@SuiteClasses({CreatePages.class,ManageBoxes.class,ManageImagesUpload1.class,ManageImagesUpload2.class,ManagePages1.class})
public class contentManagementTestSuite {

}
