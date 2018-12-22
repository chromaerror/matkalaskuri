package apiPackage;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import model.Trip;

public class Api {
	
	private static String googleMapsUrlBase = "https://maps.googleapis.com/maps/api/distancematrix/json?";
	private static final String apiKey = "";
	
	public static double getDistance(String startLocation, String endLocation) throws IOException {
		
		if(apiKey.equalsIgnoreCase("")) {
			System.out.println("Error, API key in 'Api.java' is empty. Exiting.");
			System.exit(0);
		}
		
		String thisUrl = googleMapsUrlBase + "origins="+ startLocation + "&destinations=" + endLocation;
		thisUrl += "&key=" + apiKey;
		thisUrl = thisUrl.replaceAll("\\s", "+");
		System.out.println(thisUrl);
		URL url = new URL(thisUrl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		
		Map<String, String> parameters = new HashMap<>();
		parameters.put("origins", startLocation);
		parameters.put("destinations", endLocation);
		parameters.put("key", apiKey);
		
		con.setDoOutput(true);
		DataOutputStream out = new DataOutputStream(con.getOutputStream());
		out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
		out.flush();
		out.close();
		
		con.setConnectTimeout(5000);
		con.setReadTimeout(5000);
		
		int status = con.getResponseCode();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();
		
		JSONObject responseJSON = new JSONObject(content.toString());
		System.out.println(responseJSON);
		
		System.out.println(Trip.calculateDuration(content) + " minutes");
		
		con.disconnect();
		return Trip.calculateLength(content);
	}
}
