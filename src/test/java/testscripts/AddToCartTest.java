package testscripts;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import genericLibraries.BaseClass;

@Test
public class AddToCartTest extends BaseClass {
	public void addToCartTest() {
		
		SoftAssert soft = new SoftAssert();
		
		home.clickGearsTab();
		home.clickSkillraryDemoAppLink();
		web.switchToChildBrowser();
		
		soft.assertTrue(demoApp.getPageHeader().contains("ECommerce"));
		
		demoApp.mouseHoverToCourse(web);
		demoApp.clickSeleniumTraining();
		
		soft.assertEquals(selenium.getPageHeader(), "Selenium Training");
		
		int initialQuantity = Integer.parseInt(selenium.getQuantity());
		selenium.doubleClickPlusButton(web);
		int finalQuantity = Integer.parseInt(selenium.getQuantity());
		
		soft.assertEquals(finalQuantity, initialQuantity+1);
		
		selenium.clickAddToCart();
		web.handleAlert("ok");
		soft.assertEquals(selenium.getItemAddedMessage(),"Item added to cart");
		
		soft.assertAll();
		
		
			
	}

}
