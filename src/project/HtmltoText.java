package project;


import java.io.*;
import java.util.ArrayList;

import org.jsoup.*;

public class HtmltoText {

	public static void main(String[] args) throws IOException {
		//org.jsoup.nodes.Document doc = Jsoup.connect().get();
		//org.jsoup.nodes.Document doc = Jsoup.connect("http://blogs.windsorstar.com/news/woman-to-be-charged-with-child-abandonment-after-infants-found-in-apartment-stairwell").get();
		
		ArrayList<String> arrayList = new ArrayList<String>();
		File folder = new File("C:\\Users\\admin\\workspace\\ACT_Project\\htmls\\");
		File[] listOfFiles = folder.listFiles();
		
		 for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  arrayList.add("C:\\Users\\admin\\workspace\\ACT_Project\\htmls\\"+listOfFiles[i].getName());
		       // System.out.println( listOfFiles[i].getName());
		      } 
		  }
		 System.out.println("Converting HTML files...");
		 for(int i=0;i<arrayList.size();i++){
			 org.jsoup.nodes.Document doc1 = Jsoup.parse(new File(arrayList.get(i)), "UTF-8", "www.w3sfjj.com");
			 String text = doc1.text();
			 //System.out.println(text);
			 PrintWriter printWriter = new PrintWriter("C:\\Users\\admin\\workspace\\ACT_Project\\textfiles\\"+listOfFiles[i].getName()+".txt");
			 printWriter.println(text);
			 printWriter.close();
		 }
		 System.out.println("Text files created successfully!");
		
	}
}
