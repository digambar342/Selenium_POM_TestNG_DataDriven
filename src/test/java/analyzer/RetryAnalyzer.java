package analyzer;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	private static final int maxretryCount = 2;
	private static Map<String,Integer> retryCountMap = new HashedMap<String,Integer>();

	public boolean retry(ITestResult result) {
		String key = result.getMethod().getMethodName();
		int currentRetryCount = retryCountMap.getOrDefault(key, 0);
		if(currentRetryCount<maxretryCount) {
			System.out.println("inside retry method and retry count "+currentRetryCount);
			retryCountMap.put(key, currentRetryCount+1);
			return true;
		}
		return false;
	}
}
