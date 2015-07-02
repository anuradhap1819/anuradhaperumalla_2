package testjson;

import java.io.FileReader;
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

public class  TargetFile{

	public static void main(String[] args) throws Exception{
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
		
		
		
			
			/*for(int i=0; i<unsortedlist.size(); i++){
				System.out.println(unsortedlist.toArray()[i]);
			}
			
			Random rn = new Random();
			int answer = rn.nextInt(10) + 1;
			
			System.out.println("answer " + answer);
		    
		    */
			
		
	}

