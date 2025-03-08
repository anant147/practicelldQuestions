package com.practice.lld.quadtree;

import java.util.Set;

public class QuadMainClass {

	public static void main(String[] args) {

		System.out.println(" parent quad is at center (100, 100) and half height , half width of 100, 100");
		Quad parentQuad = new Quad(new Location(100, 100), 100, 100, null);
		
		Cab keertiCab = new Cab("keerti");
		Cab gauravCab = new Cab("gaurav");
		Cab yogitaCab = new Cab("yogita");
		Cab striverCab = new Cab("striver");
		
		System.out.println(" inserting keerti cab at 250, 250");
		parentQuad.insert(keertiCab, new Location(250, 250));
		
		System.out.println(" \n \n inserting keerti cab at 120, 120");
		parentQuad.insert(keertiCab, new Location(120, 120));
		
		System.out.println(" \n \n inserting gaurav cab at 80, 80");
		parentQuad.insert(gauravCab, new Location(80, 80));
		
		System.out.println(" \n \n inserting yogita cab at 150, 150");
		parentQuad.insert(yogitaCab, new Location(150, 150));
		
		System.out.println(" \n \n inserting striver cab at 20, 20");
		parentQuad.insert(striverCab, new Location(20, 20));
		
		Set<Cab> cabs = parentQuad.getNearByCabs(new Location(30,30));
		
		for (Cab cab : cabs) {
			System.out.println("cab : " + cab.name);
		}
	}

}
