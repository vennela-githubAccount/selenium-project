package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillraryHomePage {
	
	//declaration
	@FindBy(xpath="//img[@alt='SkillRary']")
	private WebElement logo;

	@FindBy(xpath="//ul[contains(@class, 'home_menu')]/li[1]")
	private WebElement languageIcon;

	@FindBy(xpath="//ul[contains(@class, 'home_menu')]/descendant::a[text()=' English ']")
	private WebElement english;

	@FindBy(xpath="//a[text()= ' GEARS ']")
	private WebElement gearsTab;

	@FindBy(xpath="//ul[@class='dropdown-menu gear_menu']/descendant::a[text()=' SkillRary Demo APP']")
	private WebElement SkillraryDemoAppLink;
	
	//initialization
	public SkillraryHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	//utilization
	/**
	 * this method return logo
	 * @return
	 */
	public WebElement getLogo() {
		return logo;
	}
	
	/**
	 * this method is used to select english as default language
	 */
	public void chooseEnglish() {
		languageIcon.click();
		english.click();
	}
	
	/**
	 * this method is used to click on gears tab
	 */
	public void clickGearsTab() {
		gearsTab.click();
		
	}
	
	/**
	 * this method is used to click on skillrary down app link
	 */
	public void clickSkillraryDemoAppLink() {
		SkillraryDemoAppLink.click();
	}

}
