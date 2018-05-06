package project;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.StringTokenizer;

public class Keys_Sort implements Serializable, Comparable{

	
	public String file;
	public int pcount;
	public String key;
	@Override
	public int compareTo(Object in) {
		int sc = ((Keys_Sort) in).pcount; 

	
		//descending order
		return sc - this.pcount;

	}

	
}
