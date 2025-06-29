package pageObject;

import java.util.Scanner;

public class VolumeOfCone {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter Radius of the Cone");
		
		float radius=scan.nextFloat();
		
		System.out.println("Please enter Height of the Cone");
		
		float height=scan.nextFloat();
		
		//double volume= ((1/3)*(3.14*radius*radius*height));
		
		double volume=(0.333*3.14*radius*radius*height);
		
		System.out.println("Volume of the Cone is : " + volume);
	}

}
