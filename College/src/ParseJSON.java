

import java.awt.Window.Type;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 
 * @author lilili
 *
 */
public class ParseJSON {
	private Map<String, String> metadata;
	private ArrayList<Map<String, Holder>> results;
//	private ArrayList<College> colleges;
	
	public ParseJSON() {
		super();

	}
	
//	public void sort() {
//		for(Map<String, Holder> college : results) {
//			SchoolInfo info;
//			Stats stats;
//			for (String key : college.keySet()) {
//				if(key.equals("school"))
//					info = (SchoolInfo) college.get(key);
//				else if(key.equals("2015"))
//					stats = (Stats) college.get(key);
//			}
//		}
//	}
	
//	public String getCollegeName(int index) {
//		College selected = colleges.get(index);
//		SchoolInfo info = selected.getInfo();
//		return info.getName();
//		
//	}
	
//	public String getAvgSATScore(int index) {
//		College selected = results.get(index);
//		System.out.println(selected);
//	}

}