package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SenticNetSingleton {
      private static SenticNetSingleton sing = new SenticNetSingleton();
  Map<String, String> map ; 
    
    
	private SenticNetSingleton() 
        {
                map = new HashMap<String,String>();
	}
        public static SenticNetSingleton getInstance()
        {
            return sing;
                    
        }
 
  
        public void put(String Key, String Value)
        {
            map.put(Key, Value);
        }
        public int getSize()
        {
            return map.size();
            
        }
        public String get(String key)
        {
            return map.get(key);
           
        }
        public boolean containsKey(String key)
        {
            return(map.containsKey(key));
            
        }

}
