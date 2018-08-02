package step_definitions;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	//	features = "classpath:features",
		features = "src/test/resources/features/MercuryDataDrivenExcel.feature",		
		plugin = {"pretty", "html:target/cucumber-html-report"},
	//	format={"json:target/Destination/cucumber.json"})
		monochrome = true,
	//	tags = {"@smoketest"},
		glue={"step_definitions"}
	//	glue={}
		)
public class TestRunner{
	
}