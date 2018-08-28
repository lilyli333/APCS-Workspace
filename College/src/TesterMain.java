import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;

public class TesterMain {
	public static void main(String[] args) throws IOException {
		Gson gson = new Gson();
		String fileData = new String(Files.readAllBytes(Paths
				.get("boston")));
	
			ParseJSON ps = gson.fromJson(fileData, ParseJSON.class);
		
//		ps.sort();
//		System.out.println(ps.getCollegeName(0));
	}
	
}
