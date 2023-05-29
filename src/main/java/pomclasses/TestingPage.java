package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this class contains elements locators and respective business libraries of testing page
 * @author j
 */

public class TestingPage {
	
	//declaration
	@FindBy(xpath = "//h1[@class='page-header']")
	private WebElement pageHeader;
	
	@FindBy(id = "python")
	private WebElement pythonImage;
	
	@FindBy(id = "cartArea")
	private WebElement cartArea;
	
	@FindBy(xpath = "//ul[@class='list-socialicons']/descendant::i[@class='fa fa-facebook']")
	private WebElement facebookIcon;
	
	//initialization
	public TestingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	//utilization
	/**
	 * this method returns page header text
	 * @return
	 */
	public String getPageHeader() {
		return pageHeader.getText();	
	}

	/**
	 * this method returns python image
	 * @return
	 */
	public WebElement getPythonImage() {
		return pythonImage;
	}
	
	/**
	 * this method returns cart area element
	 * @return
	 */
	public WebElement getCartArea() {
		return cartArea;
	}
	
	/**
	 * this method returns facebook icon
	 * @return
	 */
	public WebElement getFacebookIcon() {
		return facebookIcon;
	}
	
	/**
	 * this method is used to click on facebook icon
	 */
	public void clickFacebookIcon() {
		facebookIcon.click();
	}
}
	

