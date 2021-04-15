package com.valuemomentum.retail.testautomation.tests;

import org.testng.annotations.Test;

public class DependsOnMethod {

	@Test(dependsOnMethods = { "testcase3", "testcase2" })
	public void testcase1() 
	{
		System.out.println("This is test case1");
	}

	@Test
	public void testcase2()
	{
		System.out.println("This is test case2");
	}

	@Test
	public void testcase3() 
	{
		System.out.println("This is test case3");
	}

}
