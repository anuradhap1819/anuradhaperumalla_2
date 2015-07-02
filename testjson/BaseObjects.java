package testjson;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
public class BaseObjects{
   
	public static String filepath = "C:\\anu\\selenium\\testjson\\";
	
	
public JSONObject createJsOnobjectList(){
        	   
	       JSONObject obj = new JSONObject();
	       
	       JSONArray list = new JSONArray();
	    	list.add("Am I The Only One ");
	        list.add("Futurama Fry");
	        list.add("Bad Luck Brian");
	        list.add("Skeptical Baby");
	        list.add("One Does Not Simply A");
	        list.add("Alien Guy");
	        list.add("I Dont Always");
	        list.add("First World Problems");
	        list.add("Condescending Wonka");
	        list.add("Grandma finds the");
	        
	        obj.put("baselist",  list);
	        
	        return obj;
}
	        
	      public void writeListToJsonfile(JSONObject jsonobj,String filename){	        
	        
	        
	        try{
	        	
	        	  FileWriter fr = new FileWriter(filepath+filename+".json", true );
	        	  PrintWriter bf = new PrintWriter(fr);
	        	  //BufferedWriter bf = new BufferedWriter(file);
	        	  //jsonobj = createJsOnobjectList().toString(); 
	        	  bf.write("");
	        	  bf.write(jsonobj.toString());
	        	  
	        	  bf.write("\r\n");
	        	  bf.flush();
	        	  bf.close();
	     
	        	 System.out.println("jsonobj : " + jsonobj);
	        }catch(Exception e){
	        	e.printStackTrace();
	        }

	       // System.out.println(obj);
	           	
}	        
 /*public void writeListToJsonfile(List li,String filename) throws Exception{	        
		        
	 FileWriter file = new FileWriter(filepath+filename+".json");
	  BufferedWriter bf = new BufferedWriter(file); 
   
	    file.write(li.toString());
	    bf.write("\n");
	    bf.close();
	
        System.out.println("li:" + li);
		        
		        

		       // System.out.println(obj);
		           	
	}	  */      
public List readListFromJsonfile(String objectkey,String filename) throws Exception{
   		
		JSONParser parser = new JSONParser();

			 Object obj = parser.parse(new FileReader(filepath+filename+".json"));
			
			JSONObject  jsonobj = (JSONObject) obj;
								
			JSONArray msg = (JSONArray) jsonobj.get(objectkey);
			
			List list = new ArrayList();
			
			Iterator <String> iterator = msg.iterator();

						while(iterator.hasNext()){
				
			    list.add(iterator.next());
			}	
			System.out.println("read from json filelist" + list);    
			return list;
			
            
} 


public List sortIterator(List list){
	
	Collections.sort(list);
    System.out.println("sorted list............");
    System.out.println(list);
    return list;
}

public Map Scoreassign(List list){
	
	Map<Integer, String> resultmap = new HashMap<Integer, String>();
	for(int i=0; i<list.size(); i++){
		resultmap.put(i, (String) list.toArray()[i]);
		
	}
	
	
	//System.out.println(obj);
	return resultmap;
	
	
	
}
}



 
