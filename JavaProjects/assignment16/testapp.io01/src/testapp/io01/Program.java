package testapp.io01;

import java.io.File;
import java.util.Date;

public class Program {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file=new File("data/mydata.txt");
		
		System.out.println("FileName\t"+file.getName());
		System.out.println("Parent\t"+file.getParent());
		System.out.println("Path\t"+file.getAbsolutePath());
		
		System.out.println("exists ?"+file.exists());
		
		System.out.println("Length of the file?"+file.length());
		System.out.println("Date Modified"+new Date(file.lastModified()));
		
		
	}

}
