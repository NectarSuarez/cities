package com.cities.geo.VO;
// Clase creada para poder manipular el listado de ciudades del archivo
public class geoname
{
	private int id;
	private String name;
	private String ascii;
	private String alt_name;
	private double lat;
	private double longt;
	private String feat_class;
	private String feat_code;
	private String country;
	private String cc2;
	private String admin1;
	private String admin2;
	private String admin3;
	private String admin4;
	private String population;
	private String elevation;
	private String dem;
	private String tz;
	private String modified_at;
	private double score;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAscii() {
		return ascii;
	}
	public void setAscii(String ascii) {
		this.ascii = ascii;
	}
	public String getAlt_name() {
		return alt_name;
	}
	public void setAlt_name(String alt_name) {
		this.alt_name = alt_name;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLongt() {
		return longt;
	}
	public void setLongt(double longt) {
		this.longt = longt;
	}
	public String getFeat_class() {
		return feat_class;
	}
	public void setFeat_class(String feat_class) {
		this.feat_class = feat_class;
	}
	public String getFeat_code() {
		return feat_code;
	}
	public void setFeat_code(String feat_code) {
		this.feat_code = feat_code;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCc2() {
		return cc2;
	}
	public void setCc2(String cc2) {
		this.cc2 = cc2;
	}
	public String getAdmin1() {
		return admin1;
	}
	public void setAdmin1(String admin1) {
		this.admin1 = admin1;
	}
	public String getAdmin2() {
		return admin2;
	}
	public void setAdmin2(String admin2) {
		this.admin2 = admin2;
	}
	public String getAdmin3() {
		return admin3;
	}
	public void setAdmin3(String admin3) {
		this.admin3 = admin3;
	}
	public String getAdmin4() {
		return admin4;
	}
	public void setAdmin4(String admin4) {
		this.admin4 = admin4;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	public String getElevation() {
		return elevation;
	}
	public void setElevation(String elevation) {
		this.elevation = elevation;
	}
	public String getDem() {
		return dem;
	}
	public void setDem(String dem) {
		this.dem = dem;
	}
	public String getTz() {
		return tz;
	}
	public void setTz(String tz) {
		this.tz = tz;
	}
	public String getModified_at() {
		return modified_at;
	}
	public void setModified_at(String modified_at) {
		this.modified_at = modified_at;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public geoname(int id, String name, String ascii, String alt_name, double lat, double longt, String feat_class,
			String feat_code, String country, String cc2, String admin1, String admin2, String admin3, String admin4,
			String population, String elevation, String dem, String tz, String modified_at, double score) {
		super();
		this.id = id;
		this.name = name;
		this.ascii = ascii;
		this.alt_name = alt_name;
		this.lat = lat;
		this.longt = longt;
		this.feat_class = feat_class;
		this.feat_code = feat_code;
		this.country = country;
		this.cc2 = cc2;
		this.admin1 = admin1;
		this.admin2 = admin2;
		this.admin3 = admin3;
		this.admin4 = admin4;
		this.population = population;
		this.elevation = elevation;
		this.dem = dem;
		this.tz = tz;
		this.modified_at = modified_at;
		this.score = score;
	}
	public geoname() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
