package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="data")
	public String[][] getAllData() throws IOException{
		
		String path = System.getProperty("user.dir") + "//testdata//testdata.xlsx";
		XLUtility xlutility = new XLUtility(path);
		
		int rowNum = xlutility.getRowCount("Sheet1");
		int colNum = xlutility.getCellCount("Sheet1", 1);
		
		String apidata[][] = new String[rowNum][colNum];
		
		for(int i = 1; i <= rowNum; i++) {
			for(int j = 0; j < colNum; j++) {
				apidata[i-1][j] = xlutility.getCellData("Sheet1", i, j);
			}
		}
		
		return apidata;
	}
	
	@DataProvider(name="usernames")
	public String[] getUsernames() throws IOException{
		
		String path = System.getProperty("user.dir") + "//testdata//testdata.xlsx";
		XLUtility xl = new XLUtility(path);
		
		int rowNum = xl.getRowCount("Sheet1");
		
		String[] apidata = new String[rowNum];
		
		for(int i = 1; i <= rowNum; i++) {
			apidata[i-1] = xl.getCellData("Sheet1", i, 1);
		}
		
		return apidata;
	}

}
