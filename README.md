# AmazonTest-HybridFramework

A Hybrid Test Automation Framework for E-commerce website “Amazon” to test its Shopping cart feature using my skills on selenium webdriver with TestNg
Testcases:
1.	Adding an item to the cart and validating its price
2.	Increasing the quantity of the same item from the cart and verifying it
3.	Increasing the quantity of the same item and checking its stock
4.	Adding multiple items of different types and verifying it
5.	Removing all items from the cart and verifying it
6.	Validating page title
7.	Verifying SignupPage
8.	Verifying LoginPage

Deep Dive into the Framework:

1.	Followed Page Object Model design pattern
2.	Used Maven for dependencies
3.	Used Log4j2 for logging
4.	Used ExtentReporter for generating neat HTML report
5.	Used Listeners for taking Screenshots on failures
6.	Created Base class for common Utilities
7.	Tested Amazon’s signup page by fetching data from Excel file using Data Driven testing (Used pre-built Xls_Reader utility)
8.	Used various TestNg annotations in the project for eg. 
a.	@beforeTest
b.	@afterTest
c.	@Test(description=””, priority=1)
d.	@DataProvider

Framework Structure:

Src/main/Java:

•	Pageobject:
1.	Addtocart
2.	CartItems
3.	CeraveItems
4.	Homepage
5.	Iphonepricepage
6.	IphoneSearchPage
7.	Loginpage
8.	loginpagecontinuePW
9.	Previewcart
10.	Registrationpage

•	Resources:
1.	Base.java
2.	ExtentReporterNG.java
3.	Xls_Reader.java
4.	Data.properties
5.	Log4j2.xml
6.	Signupdata.xlsx

Src/test/Java:
•	EndtoEndProject:
1.	AmazonAddingMultipleItemstoCart
2.	AmazonAddingSameItemstoCart
3.	AmazonLogin
4.	AmazonValidateTItle
5.	DataDrivenSignup
6.	Listeners

Logs folder
Reports folder
Pom.xml
Testing.xml
