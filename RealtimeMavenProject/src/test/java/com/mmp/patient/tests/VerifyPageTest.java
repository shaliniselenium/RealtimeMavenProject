package com.mmp.patient.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mmp.patient.pages.VerifyPage;
import com.mmp.util.TestBaseClass;

public class VerifyPageTest extends TestBaseClass {
	VerifyPage verify;
	
@Test(priority=1)
public void gettitleTest() {
	 verify= new VerifyPage(driver);
	
	String title=verify.gettitle();
	System.out.println("The title of the Page is :  " + title);
	Assert.assertEquals(title, "Send Messages");
	
}
@Parameters({"label1"})
@Test(priority=2)
public  void firstlabeltest( String label1) {
	
	String t1=verify.firstlabel();
	System.out.println("The first label on the Page is :  " + t1);
	Assert.assertEquals(t1, label1);
	
}
@Parameters({"label2"})
@Test(priority=3)
public  void secondlabeltest(String label2) {
	
	String t2=verify.secondlabel();
	System.out.println("The second label on the Page is :  " + t2);
	Assert.assertEquals(t2, label2);
	
}
@Parameters({"label3"})
@Test(priority=4)
public  void sendbuttontest(String label3) {
	
	String t3=verify.sendbutton();
System.out.println("The button  on the Page is :   " + t3);
	Assert.assertEquals(t3, label3);
	
}

}

/*//Contact Reason</label>
<label>Subject<*/