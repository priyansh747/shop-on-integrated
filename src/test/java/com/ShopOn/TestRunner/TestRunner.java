package com.ShopOn.TestRunner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import com.ShopOn.TestSuites.*;
import com.ShopOn.Utilities.Email;
import com.ShopOn.test.*;



public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		Result result=JUnitCore.runClasses(contentManagementTestSuite.class,LoginNShippingTestSuite.class,MyAccountTestSuite.class,
				RegistrationTestSuite.class,SortByDefaultTestSuite.class,storeTestSuite.class,TestSuiteAdminProfile.class);
		System.out.println(result.getRunCount());
		System.out.println(result.getFailureCount());
		System.out.println(result.getRunTime());
		//Email.sendEmail();
		//MakePDF pdf=new MakePDF(result.getRunCount(),result.getFailureCount(),result.getRunTime());
		//pdf.pdfMake();
		//Email.sendEmail();
		

	}

	}


