package Main;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


import twitter4j.TwitterException;


public class SenticNet {
	public static void main(String[] args) throws TwitterException, IOException{

		}	
	
	public  double SenticSina(String gelenTag,Map<String,String> map) throws IOException
	{	        
	        try (BufferedReader in1 = new BufferedReader(new FileReader("#"+gelenTag+".txt")))
	        {
	        	Double Puan = 0.0 ;
	        	String line1 = "";
	        	while ((line1 = in1.readLine()) != null)
	        	{
	        		Puan =0.0;
	        		String parts1[] = line1.split(" ");
	        		for(String part : parts1)
	        		{
	        			if(map.get(part)!=null)
	        			{
	        				Puan +=Double.parseDouble((String) map.get(part));
	        			}	        			
	        		}
	        		return Puan/parts1.length;        		
	        	}
	       }
	        
		return 0;	
	}
	
	public void SenticYaz(String gelenTag,Map<String,String> map) throws NumberFormatException, IOException
	{
		 		
		try (BufferedReader in1 = new BufferedReader(new FileReader(gelenTag+".txt")))
	        {
	        	Double Puan = 0.0 ;
	        	String line1 = "";
	        	ArrayList<String> tweets = new ArrayList<String>();
	        	while ((line1 = in1.readLine()) != null)
	        	{
	        		Puan =0.0;
	        		String parts1[] = line1.split(" ");
	        		for(String part : parts1)
	        		{
	        			if(map.get(part)!=null)
	        			{
	        				Puan +=Double.parseDouble((String) map.get(part));
	        			}
	        			
	        		}
	        		tweets.add(line1+"-----"+Puan/parts1.length);
	        		}
	        	
	        	File f =new File(gelenTag+".txt");
	        	FileWriter fw = new FileWriter(f);
        		BufferedWriter writeOnFile = new BufferedWriter(fw);
        		
        		for(String tweet : tweets)
        		{
        			writeOnFile.append(tweet);
        			writeOnFile.newLine();
        		}
        		writeOnFile.flush();
        		writeOnFile.close();
	        }			
	}
}
	


