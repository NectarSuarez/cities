package com.cities.geo.service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cities.geo.VO.geoname;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.apache.commons.text.similarity.LevenshteinDistance;

@Service
public class geoService {

	// Función de prueba de funcionamiento del micro servicio
	public int Test(int a, int b) throws Exception
	{		
		return a*b;
	}

	// Función principal para obtener el listado filtrado por nombre y puntuado con las similitudes y cercanias en las coordenadas. 
	public List<geoname> GetAll(String q, double lat, double lon)
	{
		List<geoname> FL = new ArrayList<geoname>();
		
		FL = ByName(q);
		FL = Score(FL, q, lat, lon);
		
		return FL;
	}
	
	// Función que accede al archivo y filtra por nombre
	public List<geoname> ByName(String Name)
	{	
		List<geoname> citiesList = new ArrayList<geoname>();
		List<geoname> filteredList = new ArrayList<geoname>();
		String fileName = "https://almacenamientogeo.file.core.windows.net/archivo/test.json?sv=2020-10-02&st=2022-03-14T06%3A04%3A51Z&se=2022-03-21T06%3A04%3A00Z&sr=f&sp=r&sig=j8KaDXirb1qVLyC%2FqkE7nQckj9sETyLr%2BOMho6kgvPk%3D";
		
		try
		{
			// Archivo de donde se consumen las ciudades - Esta alojado en el mismo servidor de la aplicación
			URL url = new URL(fileName);
			ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
	        CollectionType collectionTypes = mapper.getTypeFactory().constructCollectionType(List.class, geoname.class);
	        citiesList = mapper.readValue(url.openStream(), collectionTypes);

	        // Ciclo en donde se encuentra similitudes en el nombre, se agregan a un nuevo listado filtrado para hacer mas ligero el paso de listado entre funciones.
	        for (int i = 0; i < citiesList.size()-1; i++)
	        {
	        	if (citiesList.get(i).getAlt_name().contains(Name))
	        	{
	        		filteredList.add(citiesList.get(i));
				}
	        }
			
		} catch (Exception e)
		{
			System.out.print(e.getMessage());
		}
		
		return filteredList;
	}
	
	// Función para puntuar la búsqueda con los resultados
	public List<geoname> Score(List<geoname> FilList, String Name, double Lat, double Lon)
	{
		double ScLat;
		double ScLon;
		double ScName;
		
		/*
		 * Sistema de puntuación donde la Latitud, Longitud y el Nombre tienen el mismo valor dependiendo el porcentaje de similitud.
		 * 0.33 puntos para Latitud
		 * 0.33 puntos para Longitud
		 * 0.34 puntos para Nombre
		*/
		
		List<geoname> FilListNew = new ArrayList<geoname>();

        for (int i = 0; i < FilList.size(); i++)
        {
        	ScLat = FilList.get(i).getLat()-Lat;
        	ScLat = ScLat/10;
        	if (ScLat < 0)
        		ScLat = 1 + ScLat;
        	else
				ScLat = 1 - ScLat;
        	ScLat = ScLat * 0.33;
        	
        	ScLon = FilList.get(i).getLongt()-Lon;
        	ScLon = ScLon/10;
        	if (ScLon < 0)
        		ScLon = 1 + ScLon;
        	else
				ScLon = 1 - ScLon;
        	ScLon = ScLon * 0.33;
        	
        	if (ScLat < 0)
        		ScLat = 0;
        	if (ScLon < 0)
        		ScLon = 0;
        	
        	ScName = (levensteinRatio(Name, FilList.get(i).getName())*0.34);
        	
        	FilList.get(i).setScore(FilList.get(i).getScore()+ScName+ScLat+ScLon);
        	
        	FilListNew.add(FilList.get(i));
        }
        
		return FilListNew;
	}
    
	// Se usa para calcular el ratio de similitud con la medida de distancia de levenshtein 
    public double levensteinRatio(String s1, String s2)
    {
    	LevenshteinDistance lv = new LevenshteinDistance();
        return 1 - ((double) lv.apply(s1, s2)) / Math.max(s1.length(), s2.length());
    }

}
