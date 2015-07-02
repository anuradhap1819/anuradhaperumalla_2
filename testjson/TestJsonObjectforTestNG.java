package testjson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestJsonObjectforTestNG {
	
	
		  
	 
	 @Test
	 public void testjsonvalues() throws Exception{
			JSONObject baseobj = new JSONObject();
			JSONObject targetobj = new JSONObject();
			JSONObject scorerobj = new JSONObject();
			Map<Integer, String> rmap = new HashMap<Integer, String>();
			List unsortedlist = new ArrayList();
			List sortedlist = new ArrayList();
			BaseObjects bo = new  BaseObjects();
			
			baseobj = bo.createJsOnobjectList();
			bo.writeListToJsonfile(baseobj, "test");
			unsortedlist = bo.readListFromJsonfile("baselist","test");
			System.out.println("unsortedlist: \n" + unsortedlist);
			
			sortedlist = bo.sortIterator(unsortedlist);
			targetobj.put("Sortedlist", sortedlist);
			bo.writeListToJsonfile(targetobj, "test");
			
			rmap = bo.Scoreassign(sortedlist);
			scorerobj.put("Scorer List", rmap);
			bo.writeListToJsonfile(scorerobj, "test");
			System.out.println("scorerobj: "+ rmap);
		}
	 

}
