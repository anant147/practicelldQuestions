package com.practice.lld.quadtree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Quad {
	
	static int nextQuadId = 1;
	static int noOfCabs = 4;
	
	Location centre;
	double halfWidth;
	double halfHeight;
	QuadStatus status;
	Cab cab;
	Location cabsLocation;
	Quad nwchild;
	Quad nechild;
	Quad swchild;
	Quad sechild;
	Quad parent;
	int quadid;
	
	public Quad(Location centre, double halfWidth, double halfHeight, Quad parent) {
		this.quadid = nextQuadId;
		nextQuadId++;
		this.centre = centre;
		this.halfHeight = halfHeight;
		this.halfWidth = halfWidth;
		this.parent = parent;
		this.status = QuadStatus.EMPTY_LEAF;
	}
	
	///////

	public Location getCentre() {
		return centre;
	}

	public void setCentre(Location centre) {
		this.centre = centre;
	}

	public double getHalfWidth() {
		return halfWidth;
	}

	public void setHalfWidth(double halfWidth) {
		this.halfWidth = halfWidth;
	}

	public double getHalfHeight() {
		return halfHeight;
	}

	public void setHalfHeight(double halfHeight) {
		this.halfHeight = halfHeight;
	}

	public QuadStatus getStatus() {
		return status;
	}

	public void setStatus(QuadStatus status) {
		this.status = status;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public Location getCabsLocation() {
		return cabsLocation;
	}

	public void setCabsLocation(Location cabsLocation) {
		this.cabsLocation = cabsLocation;
	}

	public Quad getNwchild() {
		return nwchild;
	}

	public void setNwchild(Quad nwchild) {
		this.nwchild = nwchild;
	}

	public Quad getNechild() {
		return nechild;
	}

	public void setNechild(Quad nechild) {
		this.nechild = nechild;
	}

	public Quad getSwchild() {
		return swchild;
	}

	public void setSwchild(Quad swchild) {
		this.swchild = swchild;
	}

	public Quad getSechild() {
		return sechild;
	}

	public void setSechild(Quad sechild) {
		this.sechild = sechild;
	}

	public Quad getParent() {
		return parent;
	}

	public void setParent(Quad parent) {
		this.parent = parent;
	}

	public int getQuadid() {
		return quadid;
	}

	public void setQuadid(int quadid) {
		this.quadid = quadid;
	}
	
	
	//////
	
	void insert(Cab pcab, Location pLoc) {
		
		if (pcab == null) {
			return ;
		}
		
		if (!containsLoc(pLoc)) {
			System.out.println(" this location ("+ pLoc.x + " , " + pLoc.y + ") at which you are trying to insert cab is out ");
			return;
		}
		
		if (this.status == QuadStatus.EMPTY_LEAF) {
			this.cab = pcab;
			this.cabsLocation = pLoc;
			this.status = QuadStatus.FILLED_LEAF;
			System.out.println(" Inserting cab at ("+pLoc.x + ", " + pLoc.y + ") in quad with centre at ("+ this.centre.x + " , " + this.centre.y + ") . Half width : " + this.halfWidth + " , Half Height : " + this.halfHeight);
		}
		else if (this.status == QuadStatus.DIVIDED_NODE) {
			
			if (pLoc.x < this.centre.x && pLoc.y > this.centre.y) {
				System.out.println(" Recursively inserting cab in northwest of quad with centre at ("+this.centre.x + ","+this.centre.y+")");
				this.nwchild.insert(pcab, pLoc);
			}
			else if (pLoc.x >= this.centre.x && pLoc.y > this.centre.y) {
				System.out.println(" Recursively inserting cab in northeast of quad with centre at ("+this.centre.x + ","+this.centre.y+")");
				this.nechild.insert(pcab, pLoc);
			}
			else if (pLoc.x < this.centre.x && pLoc.y <= this.centre.y) {
				System.out.println(" Recursively inserting cab in southwest of quad with centre at ("+this.centre.x + ","+this.centre.y+")");
				this.swchild.insert(pcab, pLoc);
			}
			else {
				System.out.println(" Recursively inserting cab in southeast of quad with centre at ("+this.centre.x + ","+this.centre.y+")");
				this.sechild.insert(pcab, pLoc);
			}
		}
		else if (this.status == QuadStatus.FILLED_LEAF) {
			this.status = QuadStatus.DIVIDED_NODE;
			createChildren();
			
			Quad parentQuad = this;
			Quad smallestQuadConsidered = this;
			
			SubQuad cabsQuad = LocateSubQuad(this.cabsLocation);
			SubQuad newCabsQuad = LocateSubQuad(pLoc);
			
			System.out.println(" Prev cab was in sub quad : " + cabsQuad + " of quad with centre : (" + this.centre.x + " , " + this.centre.y + " ) " );
			System.out.println(" New cab to be inserted in sub quad : " + newCabsQuad + " of quad with centre : (" + this.centre.x + " , " + this.centre.y + " ) " );

			while(cabsQuad == newCabsQuad) {
				System.out.println(" since 2 cabs are in same quad and capacity is 1, subdividing");
				
				parentQuad = smallestQuadConsidered;
				if (cabsQuad == SubQuad.NORTH_WEST) {
					smallestQuadConsidered.nwchild.createChildren();
					cabsQuad = smallestQuadConsidered.nwchild.LocateSubQuad(this.cabsLocation);
					newCabsQuad = smallestQuadConsidered.nwchild.LocateSubQuad(pLoc);
					smallestQuadConsidered = smallestQuadConsidered.nwchild;
				}
				else if (cabsQuad == SubQuad.NORTH_WEST) {
					smallestQuadConsidered.nechild.createChildren();
					cabsQuad = smallestQuadConsidered.nechild.LocateSubQuad(this.cabsLocation);
					newCabsQuad = smallestQuadConsidered.nechild.LocateSubQuad(pLoc);
					smallestQuadConsidered = smallestQuadConsidered.nechild;
				}
				else if (cabsQuad == SubQuad.SOUTH_WEST) {
					smallestQuadConsidered.swchild.createChildren();
					cabsQuad = smallestQuadConsidered.LocateSubQuad(this.cabsLocation);
					newCabsQuad = smallestQuadConsidered.LocateSubQuad(pLoc);
					smallestQuadConsidered = smallestQuadConsidered.swchild;
				}
				else {
					smallestQuadConsidered.sechild.createChildren();
					cabsQuad = smallestQuadConsidered.LocateSubQuad(this.cabsLocation);
					newCabsQuad = smallestQuadConsidered.LocateSubQuad(pLoc);
					smallestQuadConsidered = smallestQuadConsidered.sechild;
				}
			}
			
			
			if (newCabsQuad == SubQuad.NORTH_WEST) {
				smallestQuadConsidered = smallestQuadConsidered.nwchild;
			}
			else if (newCabsQuad == SubQuad.NORTH_EAST) {
				smallestQuadConsidered = smallestQuadConsidered.nechild;
			}
			else if (newCabsQuad == SubQuad.SOUTH_WEST) {
				smallestQuadConsidered = smallestQuadConsidered.swchild;
			}
			else {
				smallestQuadConsidered = smallestQuadConsidered.sechild;
			}
			
			smallestQuadConsidered.insert(pcab, pLoc);
			
			if (cabsQuad == SubQuad.NORTH_WEST) {
				parentQuad = parentQuad.nwchild;
			}
			else if (cabsQuad == SubQuad.NORTH_EAST) {
				parentQuad = parentQuad.nechild;
			}
			else if (cabsQuad == SubQuad.SOUTH_WEST) {
				parentQuad = parentQuad.swchild;
			}
			else {
				parentQuad = parentQuad.sechild;
			}
			
			parentQuad.insert(this.cab, this.cabsLocation);
		}
	}
	
	private SubQuad LocateSubQuad(Location pLoc) {
		if (pLoc.x < this.centre.x && pLoc.y > this.centre.y) {
			return SubQuad.NORTH_WEST;
		}
		
		if (pLoc.x >= this.centre.x && pLoc.y > this.centre.y) {
			return SubQuad.NORTH_EAST;
		}
		
		if (pLoc.x < this.centre.x && pLoc.y <= this.centre.y) {
			return SubQuad.SOUTH_WEST;
		}
		return SubQuad.SOUTH_EAST;
	}

	
	
	boolean containsLoc(Location pLoc) {
		return (pLoc.x >= this.centre.x - this.halfWidth) && // left
				(pLoc.x < this.centre.x + this.halfWidth) && // right
				(pLoc.y > this.centre.y - this.halfHeight) && // top
				(pLoc.y <= this.centre.y + this.halfHeight); // bottom
	}
	
	void createChildren() {
		
		System.out.println(" dividing the quad with centre ("+this.centre.x + ","+this.centre.y+") , halfWidth : " + this.halfWidth + " , halfHeight : " + this.halfHeight);
		
		this.nwchild = new Quad(new Location(this.centre.x - this.halfWidth/2, this.centre.y + this.halfHeight/2), this.halfWidth/2, this.halfHeight/2, this);
		
		this.nechild = new Quad(new Location(this.centre.x + this.halfWidth/2, this.centre.y + this.halfHeight/2), this.halfWidth/2, this.halfHeight/2, this);

		this.swchild = new Quad(new Location(this.centre.x - this.halfWidth/2, this.centre.y - this.halfHeight/2), this.halfWidth/2, this.halfHeight/2, this);

		this.sechild = new Quad(new Location(this.centre.x + this.halfWidth/2, this.centre.y - this.halfHeight/2), this.halfWidth/2, this.halfHeight/2, this);

	}
	
	void getCabsForParent(Quad pquad, Set<Cab> cabs, Map<Integer, Boolean> visited) {
		
		if (cabs.size()>= noOfCabs) {
			return;
		}
		
		if (pquad == null || pquad.parent == null) {
			return;
		}
		
		Quad parentQuad = pquad.getParent();
		
		if (visited.get(parentQuad.getQuadid()) != null) {
			return;
		}
		
		visited.put(parentQuad.getQuadid(), true);
		
		if (parentQuad.getNwchild().status == QuadStatus.DIVIDED_NODE) {
			getCabsFromChildren(parentQuad.getNwchild(), cabs, visited);
		}
		else if (parentQuad.getNwchild().getCab() != null && cabs.size() < noOfCabs) {
			cabs.add(parentQuad.getNwchild().getCab());
		}
		
		if (parentQuad.getNechild().status == QuadStatus.DIVIDED_NODE) {
			getCabsFromChildren(parentQuad.getNechild(), cabs, visited);
		}
		else if (parentQuad.getNechild().getCab() != null && cabs.size()< noOfCabs) {
			cabs.add(parentQuad.getNechild().getCab());
		}
		
		if (parentQuad.getSwchild().status == QuadStatus.DIVIDED_NODE) {
			getCabsFromChildren(parentQuad.getSwchild(), cabs, visited);
		}
		else if (parentQuad.getSwchild().getCab() != null && cabs.size()< noOfCabs) {
			cabs.add(parentQuad.getSwchild().getCab());
		}
		
		if (parentQuad.getSechild().status == QuadStatus.DIVIDED_NODE) {
			getCabsFromChildren(parentQuad.getSechild(), cabs, visited);
		}
		else if (parentQuad.getSechild().getCab() != null && cabs.size()< noOfCabs) {
			cabs.add(parentQuad.getSechild().getCab());
		}
		
		if (cabs.size()< noOfCabs) {
			getCabsForParent(pquad.getParent(), cabs, visited);
		}
	}
	
	void getCabsFromChildren(Quad pquad, Set<Cab> cabs, Map<Integer, Boolean> visited) {
		
		if (cabs.size()>=noOfCabs) {
			return;
		}
		
		if (pquad == null) {
			return;
		}
		
		visited.put(pquad.getQuadid(), true);
		
		if (pquad.status == QuadStatus.FILLED_LEAF) {
			cabs.add(pquad.getCab());
		}
		
		if (pquad.getNwchild() != null && visited.get(pquad.getNwchild().getQuadid()) == null) {
			getCabsFromChildren(pquad.getNwchild(), cabs, visited);
		}
		
		if (pquad.getNechild() != null && visited.get(pquad.getNechild().getQuadid()) == null) {
			getCabsFromChildren(pquad.getNechild(), cabs, visited);
		}
		
		if (pquad.getSwchild() != null && visited.get(pquad.getSwchild().getQuadid()) == null) {
			getCabsFromChildren(pquad.getSwchild(), cabs, visited);
		}
		
		if (pquad.getSechild() != null && visited.get(pquad.getSechild().getQuadid()) == null) {
			getCabsFromChildren(pquad.getSechild(), cabs, visited);
		}
		
		
	}
	
	Set<Cab> getNearByCabs(Location cabLoc){
		
		Set<Cab> cabs = new HashSet<>();
		Quad lowestQuad = this;
		SubQuad subQuad = SubQuad.NOT_ASSIGNED;
		
		Map<Integer, Boolean> vis = new HashMap<>();
		
		while (lowestQuad.status != QuadStatus.EMPTY_LEAF 
				&& lowestQuad.status != QuadStatus.FILLED_LEAF) {
			
			subQuad = lowestQuad.LocateSubQuad(cabLoc);
			
			if (subQuad == SubQuad.NORTH_WEST) {
				lowestQuad = lowestQuad.nwchild;
			}
			else if (subQuad == SubQuad.NORTH_EAST) {
				lowestQuad = lowestQuad.nechild;
			}
			else if (subQuad == SubQuad.SOUTH_WEST) {
				lowestQuad = lowestQuad.swchild;
			}
			else {
				lowestQuad = lowestQuad.sechild;
			}
		}
		
		getCabsForParent(lowestQuad, cabs, vis);
		return cabs;
	}
	
}
