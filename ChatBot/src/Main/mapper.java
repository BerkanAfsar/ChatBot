package Main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class mapper {
	public Map<String, String> mapBuilder() throws IOException
	{
		Map<String, String> map = new HashMap<String, String>(); 
		try (BufferedReader in = new BufferedReader(new FileReader("senticnet4.txt"))) {
	            String line = "";
	            while ((line = in.readLine()) != null) {
	                String parts[] = line.split("\t");
	                map.put(parts[0], parts[2]);
	            }
	        }
		return map;
	}
}


