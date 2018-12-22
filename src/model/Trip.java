package model;

import org.json.JSONArray;
import org.json.JSONObject;

public class Trip {
	// VARIABLES
	
	private String startLocation, endLocation;
	private double distance;
	
	// TO STRING
	@Override
	public String toString() {
		return "Trip [startLocation=" + startLocation + ", endLocation=" + endLocation + ", distance=" + distance + "]";
	}
	
	// GETTERS
	
	public String getStartLocation() { return this.startLocation; }
	public String getEndLocation() { return this.endLocation; }
	public double getDistance() { return this.distance; }
	
	// SETTERS
	
	public boolean setStartLocation(String startLocation) { this.startLocation = startLocation; return true; }
	public boolean setEndLocation(String endLocation) { this.endLocation = endLocation; return true; }
	public boolean setDistance(double newDistance) {
		try {
			this.distance = newDistance;
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static double calculateLength(StringBuffer content) {
		JSONObject responseJSON = new JSONObject(content.toString());
		JSONArray childElement = responseJSON.getJSONArray("rows");
		JSONObject nestedChild = childElement.getJSONObject(0);
		childElement = nestedChild.getJSONArray("elements");
		nestedChild = childElement.getJSONObject(0);
		nestedChild = nestedChild.getJSONObject("distance");
		int lengthInMeters = nestedChild.getInt("value");
		double lengthInKilometers = lengthInMeters / 1000.0;
		
		return lengthInKilometers;
	}
	
	public static int calculateDuration(StringBuffer content) {
		JSONObject responseJSON = new JSONObject(content.toString());
		JSONArray childElement = responseJSON.getJSONArray("rows");
		JSONObject nestedChild = childElement.getJSONObject(0);
		childElement = nestedChild.getJSONArray("elements");
		nestedChild = childElement.getJSONObject(0);
		nestedChild = nestedChild.getJSONObject("duration");
		String durationInSeconds = nestedChild.getString("text");
		durationInSeconds = durationInSeconds.replaceAll(" mins", "");
		int durationInMinutes = Integer.parseInt(durationInSeconds);
		
		return durationInMinutes;
	}
	
}
