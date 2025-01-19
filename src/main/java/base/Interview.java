package base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.http.impl.io.SocketOutputBuffer;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Interview {

	public static void main(String[] args) throws IOException {
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\DIGAMBAR\\Desktop\\Selenuim\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver= new ChromeDriver();
//		driver.get("https://google.com");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();

		//-------------------------------------------------
		// Count occurrence of a word in a file
		File file=new File("C:\\Users\\DIGAMBAR\\Desktop\\FISERV\\Test.txt");
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String line=null;
		int count=0;
		while((line = br.readLine()) != null) {
			String[] wordArr = line.split("\\s");
			for(String s:wordArr) {
				if(s.toLowerCase().contains("god")) {
					count++;
				}
			}
		}
		System.out.println("word god appeared "+count+" times");
		
	}
}
