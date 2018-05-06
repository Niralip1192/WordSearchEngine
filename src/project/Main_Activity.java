package project;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_Activity {
	public static void main(String args[]) throws Exception{
		Scanner input = new Scanner(System.in);
		List<Keys_Sort> index=new ArrayList<Keys_Sort>();
		List<Keys_Sort> s1=new ArrayList<Keys_Sort>();
		
		System.out.println("Enter a Keyword to be searched :");
		int f=0;
		String inputString = input.nextLine();

		try {

			InputStream in = new FileInputStream(".\\dictionary.txt");
			InputStream bin = new BufferedInputStream(in);
			ObjectInput ob = new ObjectInputStream (bin);

		
			Keys_Sort obj = null;
			index = (List<Keys_Sort>) ob.readObject();
						


		}

		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			   
				for (int i=0;i<index.size();i++) {
				if(index.get(i).key.equals(inputString)) {
					s1.add(index.get(i));
					
					f=1;
				} 
			}
            if(f==0)
            {
            	System.out.println("Keyword is not found");
            }
            	
            else
            {
			
            Collections.sort(s1);

			 for(Keys_Sort str: s1){
				System.out.println();
				System.out.println(str.file);
				System.out.println("Occurance is: " +str.pcount);	
				System.out.println();
			 }
            }
		}
		
	}
}
