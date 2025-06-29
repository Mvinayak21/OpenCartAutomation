package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders 
{
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=".\\testData\\LoginTestData.xlsx";
		
		ExcelUtility xlutil=new ExcelUtility(path);
		int rowCount= xlutil.getRowCount("Sheet1");
		int colCount= xlutil.getCellCount("Sheet1",1);
		
		String loginData[][] = new String[rowCount][colCount];
		
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
		}
		
				
		return loginData;
		
		
	}

}