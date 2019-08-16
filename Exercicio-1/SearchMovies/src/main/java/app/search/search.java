package app.search;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import app.model.*;
import app.pages.*;
import app.views.ViewSearchMovie;

public class search extends ViewSearchMovie{
	
	private WebDriver driver;
	private tableModel table;
	private pageSearch page;
	//private WebDriverWait wait;

	@Before
	public void setUp() throws Exception {
		
		//wait = new WebDriverWait(driver, 10);
		table = getTblModel();
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir").toString() + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		page = new pageSearch(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		
		String result;
		int currentRow = getCurrentTableRow();
		
		String movie = table.getTableRow(currentRow).getMovie();
		String releaseYear = table.getTableRow(currentRow).getReleaseYear();
		String director = table.getTableRow(currentRow).getDirector();
		String dateBirth = table.getTableRow(currentRow).getDateBirth();
		
		String rowSearch = movie + " " + releaseYear + " " + director + " " + dateBirth;
		
		driver.navigate().to(pageSearch.url);
		page.txtSearch.sendKeys(rowSearch);
		page.btnBuscar.submit();
		
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
		Thread.sleep(3000);
		
		result = page.lblResult.getText();
		
		System.out.println();
		
		if (result != "") {
			getReport().reportTable(movie, releaseYear, director, dateBirth, result, true);
		}
		else
		{
			getReport().reportTable(movie, releaseYear, director, dateBirth, result, true);
			result = "Não foram encontrados resultados para a busca";
			fail(result);
			JOptionPane.showMessageDialog(null, result, "Resultado Busca", JOptionPane.ERROR_MESSAGE);
		}
	}

}
