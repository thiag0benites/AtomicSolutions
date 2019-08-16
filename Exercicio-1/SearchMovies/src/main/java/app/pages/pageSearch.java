package app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageSearch {
	
	public static final String url = "https://www.google.com";
	
	public pageSearch(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="q")
	public WebElement txtSearch;
	
	@FindBy(name="btnK")
	public WebElement btnBuscar;
	
	@FindBy(id="resultStats")
	public WebElement lblResult;

}
