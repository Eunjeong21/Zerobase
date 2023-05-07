public class GetDistance {
	public Double distance(Double lat, Double lnt, Double curLat, Double curLnt) {
	double theta = lnt - curLnt;
	double dist = Math.sin(deg2rad(lat)) * Math.sin(deg2rad(curLat)) + Math.cos(deg2rad(lat)) * Math.cos(deg2rad(curLat)) * Math.cos(deg2rad(theta));
	dist = Math.acos(dist);
	dist = rad2deg(dist);
	dist = dist * 60 * 1.1515 * 1609.344;
	
	return dist / 1000;
	}
	
	public static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}
	
	public static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
}

