package Runner;


import java.io.File;
import java.net.MalformedURLException;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
(
features="src//test//resources//features",
glue= {"StepDefinitions"},
tags={"@Test"},
plugin ={"com.cucumber.listener.ExtentCucumberFormatter:"}
)
public class TestRunner {

	public static String ImagesPath;
	@BeforeClass
    public  static void setup() throws MalformedURLException {
 
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath("output/myreport.html");
        //ImagesPath = extentProperties.getReportPath().replace("/report.html", "/Screenshots/Img").replace("/myreport.html", "/Screenshots/Img");
    }
	
	@AfterClass
    public static void teardown() {
        Reporter.loadXMLConfig(new File("extent-config.xml"));
        Properties p = System.getProperties();
        p.list(System.out);
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os Name", System.getProperty("os.name"));
        Reporter.setSystemInfo("os Version", System.getProperty("os.version"));
        Reporter.setTestRunnerOutput("Test runner output message");     
    }
}

