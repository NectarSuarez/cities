package com.cities.geo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cities.geo.service.geoService;
import com.cities.geo.VO.geoname;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("Geo")
public class geoController
{
	@Autowired
	geoService geoService;
	
	// Función usada para probar la conexión con el Micro Servicio
	@RequestMapping(value = "/Test", method = RequestMethod.GET)
	public int MultiSinSigno(@RequestParam("a")int A, @RequestParam("b") int B) throws Exception
	{
		return geoService.Test(A, B);
	}
	
	// Función principal requerida en el documento
	@RequestMapping(value = "/suggestions", method = RequestMethod.GET)
	public List<geoname> suggestions(@RequestParam("q") String q, @RequestParam(defaultValue="0.0") double latitude, @RequestParam(defaultValue="0.0") double longitude)
	{
		return geoService.GetAll(q, latitude, longitude);
	}
	
}
