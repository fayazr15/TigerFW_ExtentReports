package testRunner;


import org.testng.TestNG;

import automationTestScripts.Organizations.CreatOrganisationTest;
import automationTestScripts.Organizations.CreateAndDeleteOrganizationTest;

public class TestRunnerClass 
{

	static TestNG testng;
	
	public static void main(String[] args)
	{
		testng =new TestNG();
		testng.setTestClasses(new Class[]{CreatOrganisationTest.class,CreateAndDeleteOrganizationTest.class});
		testng.run();
	}

}
