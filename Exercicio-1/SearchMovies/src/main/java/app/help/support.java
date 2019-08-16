package app.help;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class support {
	
	private Date today; 
	
	public support() {
		this.today = new Date();
	}
	
	public String[] listYears(){
		 
		String format = "yyyy";
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		int currentYear = Integer.parseInt(formatter.format(today)); 
		
		String data[] = new String[currentYear-1899]; 
		
		for (int i=0;currentYear>=1900;i++){
			data[i] = String.valueOf(currentYear);
			currentYear--;
		} 
		
		return data; 
	 }  
	
	public String[] listMonth(){
		
		String[] month = new String[12];
		
		for (int i=0;i<=month.length-1;i++){
			month[i] = String.valueOf(i+1);
		} 
		
		return month; 
	}
	
	public String[] listDay(int month, int year) {
		
		int daysMonth = 0;
		
		switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				daysMonth = 31;
				break;
				
			case 2:
				//Verifica ano bissexto
				int div = year % 4;
				
				if(div == 0) 
				{
					div = year % 100;
					if (div != 0) 
					{
						daysMonth = 29; //bissexto
					}
				}
				else if (div != 0) 
				{
					div = year % 400;
					
					if (div == 0) 
					{
						daysMonth = 29; //bissexto
					}
					else if (div != 0) 
					{
						daysMonth = 28; //não bissexto
					}
				}
				break;
	
			default:
				daysMonth = 30;
				break;
		}
		
		String[] days = new String[daysMonth];
		
		for (int i = 0; i < daysMonth; i++) {
			days[i] = String.valueOf(i+1);
		}
		
		return days;
	}
	
	public void clearFields(JTextField txtMovie, JTextField txtDirector) {
		txtMovie.setText("");
		txtDirector.setText("");
	}
	
	public void openReport() {
		
		try {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir").toString() + "/drivers/chromedriver.exe");
			WebDriver driver =  new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("file:///" + System.getProperty("user.dir").toString() + "/target/reports/report.html");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível abrir o relatório! \n Você pode abri-lo manualmente em: \n C:/Automacao/AtomicSolutions/SearchMovies/target/reports/report.html", "Relatório", JOptionPane.WARNING_MESSAGE);
		}
		
	}

}