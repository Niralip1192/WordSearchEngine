package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.jsoup.Jsoup;

/*************************************************************************
 *  Compilation:  javac TST.java
 *  Execution:    java TST < words.txt
 *  Dependencies: StdIn.java
 *
 *  Symbol table with string keys, implemented using a ternary search
 *  trie (TST).
 *
 *
 *  % java TST < shellsST.txt
 *  by 4
 *  sea 6
 *  sells 1
 *  she 0
 *  shells 3
 *  shore 7
 *  the 5

 *
 *  % java TST
 *  theory the now is the time for all good men

 *  Remarks
 *  --------
 *    - can't use a key that is the empty string ""
 *
 *************************************************************************/

public class Project_1 implements Serializable{
	
	
	
    public static void main(String[] args) throws IOException, ClassNotFoundException {
    	
    In in;
   List<Keys_Sort> obj=new ArrayList<Keys_Sort>();
   ArrayList<String> arrayList = new ArrayList<String>();
	File folder = new File(".\\textfiles\\");
	File[] listOfFiles = folder.listFiles();
	File folder1 = new File(".\\htmls\\"); 
	File[] listOfFiles1 = folder1.listFiles(); 
	
	 for (int i = 0; i < listOfFiles.length; i++) {
	      if (listOfFiles[i].isFile()) {
	    	  arrayList.add(".\\textfiles\\"+listOfFiles[i].getName());
	      }
	 }
	 for(int i=0;i<arrayList.size();i++)
	 {
	    	  org.jsoup.nodes.Document doc1 = Jsoup.parse(new File(arrayList.get(i)), "UTF-8", "www.w3sfjj.com");
	    	  String text = doc1.text();
	 		 TST<Integer> st=new TST<Integer>();
	 		 StringTokenizer taker = new StringTokenizer(text," .,'\"\"*&^%$#@`~-_+=;:?<>()[]/|!\t\n\r\f,.:;?![]'\\{}");
	 		ArrayList<String> keys=new ArrayList();
	 		while (taker.hasMoreElements())
	        {
	        	keys.add(taker.nextToken().toLowerCase());
	        }
	 		
	 		for (int j = 0; j < keys.size(); j++) {
	        	int counter=1;
	        	for(int k=0;k<keys.size();k++){

	        		   if(keys.get(j).equals(keys.get(k))){
	       			 counter++;
	       		 }
	       		  		 
	       	     }   
	        		 st.put(keys.get(j), counter);
	        }
	 		/*ArrayList<String> duplicate=new ArrayList<String>();
	        duplicate.add(keys.get(0));
	        for(int u=0;u<keys.size();u++)
	        {
	     	   for(int w=1;w<duplicate.size();w++)
	     	   {
	     		   if(keys.get(u).equals(duplicate.get(w)))
	     		   {
	     			   keys.remove(u);
	     		   }
	     			   
	     		   
	     	   }duplicate.add(keys.get(u));
	     	   
	        }*/
	 		Keys_Sort p1 = null;
			for (String key : st.keys()) 
			{
				
				p1 = new Keys_Sort();
				p1.file=arrayList.get(i);
				p1.pcount= st.get(key);
				p1.key= key;
				obj.add(p1);
			
	 		
	    } 
	  }
	 
    FileOutputStream out = new FileOutputStream("dictionary.txt");
	ObjectOutputStream oout = new ObjectOutputStream(out);
	oout.writeObject(obj);
	oout.writeObject(null);
	oout.close();
    }
        
	     
	
        
}


 
