package listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import analyzer.RetryAnalyzer;

import org.apache.commons.io.FileUtils;


public class TestListeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("test starts----------"+result.getName() );
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("test passed-----------"+result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute("driver");
		
		System.out.println("test failed---------------"+result.getName());
		TakesScreenshot ts=(TakesScreenshot)driver;
		try {
			File source = ts.getScreenshotAs(OutputType.FILE);
			if(source != null)
			FileUtils.copyFile(source, new File ("C:\\Users\\DIGAMBAR\\workspace_Oxygen\\amazonDemo\\test-output\\screenshots\\"+result.getName()+".PNG"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object currentRetryAnalyzer = result.getMethod().getRetryAnalyzer();
		if (currentRetryAnalyzer == null) {
			result.getMethod().setRetryAnalyzer(new RetryAnalyzer());
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
