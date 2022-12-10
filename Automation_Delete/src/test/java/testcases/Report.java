package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.Delete.AllDelete;
import com.Login.UserLogin;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Report {
	AllDelete allDelete;
	ChromeDriver driver;
	FileInputStream fs;
	static Logger log;
	@BeforeMethod
	public void setUp() throws IOException {
		Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
		System.out.println(currentTimestamp);

		String u_name = "naxep99573@ceoshub.com";
		String u_pass = "qwerty77";
		
		// System.out.println(detailDAO.connectionName()+"\n"+detailDAO.connectionString());
		String os=System.getProperty("os.name").toLowerCase();
		System.out.println("OS name: "+os);
	       String driver_type = os.contains("windows") ? "/chromedriver.exe" :"/chromedriver";
			final URL driver_path = Report.class.getResource(driver_type);
		    System.out.println(driver_path.getFile());
		
		System.setProperty("webdriver.chrome.driver", driver_path.getFile());

				ChromeOptions options = new ChromeOptions();
						options.addArguments("headless");
						options.addArguments("window-size=1500,800");
						options.addArguments("incognito");
						driver = new ChromeDriver(options);

		
		UserLogin user = new UserLogin(driver);
		log = Logger.getLogger(Report.class);
		driver.get("https://studio.dronahq.com/apps");
		driver.manage().window().maximize();
		user.login(u_name, u_pass);
		log.info("Login Successfull");
		allDelete = new AllDelete(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@Test
	public void DeleteAll() {
		allDelete.navigatetoConnector();
		allDelete.deleteConnector("AutoTestMongo");
//		log.info("Mongo Deleted");
		allDelete.deleteConnector("AutoTestPostgre");
		log.info("Postgre Deleted");
		allDelete.deleteConnector("AutoApi");
		log.info("Rest Api Deleted");
		allDelete.deleteConnector("AutoGraphQL");
		log.info("GraphQL Deleted");
//		allDelete.deleteGoogleSheet();
//		log.info("Google Sheet Deleted");
		allDelete.deleteAutoApp();
		log.info("App Deleted");
		driver.navigate().refresh();
		allDelete.deleteExportApp();
	}
	//@Ignore
	@Test
	public void DeleteExportApp()
	{
		allDelete.deleteExportApp();
	}
//	@AfterMethod
//	public void tearOff()
//	{
//		driver.quit();
//	}
}
