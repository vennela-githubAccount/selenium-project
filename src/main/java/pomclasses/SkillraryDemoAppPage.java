package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

/**
 * this class contains elements and respective business libraries of skillrary demo app page
 * @author j
 */
public class SkillraryDemoAppPage {
	//declaration
	@FindBy(xpath = "//div[@class='navbar-header']")
	private WebElement pageHeader;
	
	@FindBy(id = "Course")
	private WebElement courseTab;
	
	@FindBy(xpath = "//span/a[text()='Selenium Training']")
	private WebElement seleniumTrainingLink;
	
	@FindBy(name= "addresstype")
	private WebElement categoryDD;
	
	@FindBy(xpath = "//a[text()=' Contact Us ']")
	private WebElement contactUsLink;
	
	//initialization
	public SkillraryDemoAppPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	//utilization
	/**
	 * this method returns page header text
	 * @return
	 */
	public String getPageHeader(){
		return pageHeader.getText();
	}
	
	/**
	 * this method is used to mouse hover to course tab
	 * @param web
	 */
	public void mouseHoverToCourse(WebDriverUtility web) {
		web.mouseHover(courseTab);
	}
	
	/**
	 * this method is used to click on selenium training
	 */
	public void clickSeleniumTraining() {
		seleniumTrainingLink.click();
	}
	
	/**
	 * this method is used to select category
	 * @param web
	 * @param index
	 */
	public void selectCategory(WebDriverUtility web, int index) {
		web.dropdown(categoryDD, index);
	}
	
	/**
	 * this method returns contact us link
	 * @return
	 */
	public WebElement getContactUsLink() {
		return contactUsLink;
		
	}

	public void clickContactUs() {
		// TODO Auto-generated method stub
		
	}
	
}
