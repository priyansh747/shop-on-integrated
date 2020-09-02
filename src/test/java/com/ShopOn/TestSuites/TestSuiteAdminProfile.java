package com.ShopOn.TestSuites;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ShopOn.admin.profile.CreateOrEditUserBlank;
import com.ShopOn.admin.profile.CreateOrEditUserDuplicate;
import com.ShopOn.admin.profile.CreateOrEditUserInvalid;
import com.ShopOn.admin.profile.CreateOrEditUserValid;
import com.ShopOn.admin.profile.EditUserFromUsersAllCheck;
import com.ShopOn.admin.profile.EditUserGroups;
import com.ShopOn.admin.profile.RemoveUserGroups;
import com.ShopOn.admin.profile.RemoveUsers;
import com.ShopOn.admin.profile.ViewUserGroups;
import com.ShopOn.admin.profile.ViewUsers;
import com.ShopOn.test.*;
@RunWith(Suite.class)
@SuiteClasses({CreateOrEditUserDuplicate.class,CreateOrEditUserValid.class,
EditUserFromUsersAllCheck.class,EditUserGroups.class,RemoveUserGroups.class,CreateOrEditUserInvalid.class,RemoveUsers.class,ViewUserGroups.class,
CreateOrEditUserBlank.class,ViewUsers.class})
public class TestSuiteAdminProfile {


}