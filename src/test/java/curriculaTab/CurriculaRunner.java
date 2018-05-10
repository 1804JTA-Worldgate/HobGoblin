package curriculaTab;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		plugin={"pretty","html:C:/Reports/CurriculaTests"},tags= {"@curriculaTest"},
		features = {"C:/revature/webdriver2/src/test/resources/curriculaTest.feature"}
		)
 
public class CurriculaRunner extends AbstractTestNGCucumberTests {

}
