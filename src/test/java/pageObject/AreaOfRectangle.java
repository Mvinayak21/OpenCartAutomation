package pageObject;

import java.util.Scanner;

public class AreaOfRectangle {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter Lenth of the Rectangle");
		
		float length=scan.nextFloat();
		
		System.out.println("Please enter Breadth of the Rectangle");
		
		float breadth=scan.nextFloat();
		
		float area= length*breadth;
		
		System.out.println("Area of the Rectangle is : "+area);

	}

}
