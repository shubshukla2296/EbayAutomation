Taask - UI Automation On ebay.com website, 
I'm using Selenium WebDriver with Java, following best practices in test automation. The framework will be structured using Page Object Model (POM) to ensure maintainability and reusability.
Tech Stack:
•	Java
•	Selenium WebDriver
•	TestNG (for assertions and test execution)
•	Maven (for dependency management)
•	GitHub (to share the work)

EbayAutomation/
│── src/main/java/
│   ├── pages/
│   │   ├── BasePage.java
│   │   ├── HomePage.java
│   │   ├── SearchResultsPage.java
│   │   ├── ProductPage.java
│   │   ├── CartPage.java
│── src/test/java/
│   ├── tests/
│   │   ├── BaseTest.java
│   │   ├── AddToCartTest.java
│── pom.xml
│── README.md

-----------------------------------------------------------------------------------------------------------------------
In our automation project, we have two packages
•	Package names start with a lowercase letter (pages, tests).
•	Class names start with an uppercase letter (HomePage, CartPage).

1.	BasePage.java
o	Purpose: Common setup for all pages (parent class).
all pages can use WebDriver easily.
it contains WebDriver and WebDriverWait.
2.	HomePage.java
o	Purpose: Performs search action on eBay.
o	Methods: searchItem(String item)
3.	SearchResultsPage.java
o	Purpose: Handles the search results and clicks on the first item.
o	Methods: clickFirstItem()
4.	ProductPage.java
o	Purpose: Clicks on "Add to Cart".
o	Methods: addToCart()
5.	CartPage.java
o	Purpose: Verifies if the cart count is updated.
o	Methods: isCartUpdated()
________________________________________
Inside the tests/ Package (Test Execution)
6.	BaseTest.java
o	Purpose: Manages WebDriver setup & teardown.
o	Methods: setup(), tearDown()
7.	AddToCartTest.java
o	Purpose: Runs the test step-by-step using page classes.
o	Methods: verifyItemCanBeAddedToCart()
________________________________________
How Do They Work Together?
Here’s how each class interacts during test execution: When we run AddToCartTest.java:
1.	WebDriver starts (BaseTest)
2.	Opens eBay (HomePage)
3.	Searches for 'book' (HomePage.searchItem("book"))
4.	Clicks first search result (SearchResultsPage.clickFirstItem())
5.	Clicks 'Add to Cart' (ProductPage.addToCart())
6.	Verifies cart count (CartPage.isCartUpdated())
Each page class is responsible for only one thing, keeping the code clean!
________________________________________
Key Java Concepts Used in This Project
Concept	Where Used?	Explanation
Package	package pages;	Organizes related classes together.
Class	public class HomePage	Defines objects with methods & variables.
Method	public void searchItem(String item)	Performs actions like searching an item.
Inheritance	public class HomePage extends BasePage	HomePage inherits WebDriver from BasePage.
Encapsulation	private By searchBox = By.id("gh-ac");	Keeps elements private & accessible via methods.
TestNG Framework	@Test in AddToCartTest	Marks methods as test cases.
Assertions	Assert.assertTrue(cartPage.isCartUpdated());	Checks if cart count is updated.
________________________________________
Summary
1.	Packages (pages, tests) help organize code.
2.	Classes are blueprints for actions (like searching, adding to cart).
3.	Methods inside classes perform specific tasks.
4.	Test class (AddToCartTest.java) calls all page classes to execute the test.
