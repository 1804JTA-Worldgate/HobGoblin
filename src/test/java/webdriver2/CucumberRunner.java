package webdriver2;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
 
@CucumberOptions(
		plugin={"pretty","html:C:/Reports/CucumberTests"},tags= {"@loginTest"},
		features = {"C:/revature/webdriver2/src/test/resources/loginTest.feature"}
		)
 
public class CucumberRunner extends AbstractTestNGCucumberTests {
}

