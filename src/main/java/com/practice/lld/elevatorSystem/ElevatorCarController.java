package com.practice.lld.elevatorSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ElevatorCarController {
	
	int ecid;
	ElevatorCar elevator;
	PriorityQueue<Integer> upPq; // min pq
	PriorityQueue<Integer> downPq; // max pq
	List<Integer> pendingRequests = new ArrayList<>();
	
	public ElevatorCarController(int ecid) {
		this.ecid = ecid;
		this.elevator = new ElevatorCar(ecid);
		this.upPq = new PriorityQueue<Integer>();
		this.downPq = new PriorityQueue<Integer>(Collections.reverseOrder());
		this.pendingRequests = new ArrayList<>();
	}
	
	public void moveToDest(int floor, Direction dir) {
		this.elevator.move(floor, dir);
	}
	
	public void setInternalDispatcher(InternalButtonDispatcher internalDispatcher) {
		this.elevator.setInternalDispatcher(internalDispatcher);
	}
	
	public void submitRequest(int floorid, Direction dir) {
		
		if (this.elevator.status == Status.IDLE) {
			flipStatus();
		}
		
		int currentFloor = this.elevator.currentFloor;
		Direction currentDir = this.elevator.dir;
		if (currentFloor == floorid) {
			System.out.println(" no need to process req. User is at current floor : " + floorid);
		}
		else if (currentFloor < floorid  && currentDir == dir && currentDir == Direction.UP) {
			this.upPq.add(floorid);
			System.out.println("up req, currentFloor : " + currentFloor + " , floorid : " + floorid + " , currentDir : " + currentDir);;
		}
		else if (currentFloor > floorid && currentDir == dir && currentDir == Direction.DOWN) {
			this.downPq.add(floorid);
			System.out.println("down req, currentFloor : " + currentFloor + " , floorid : " + floorid + " , currentDir : " + currentDir);;
		}
		else {
			this.pendingRequests.add(floorid);
			System.out.println("pending req, currentFloor : " + currentFloor + " , floorid : " + floorid + " , currentDir : " + currentDir);;
		}
	}
	
	public void processElevatorRequest() {
		
		System.out.println("\n \n processing elev req. of elev : " + this.ecid);
		
		if ( !this.upPq.isEmpty() || !this.downPq.isEmpty() || this.pendingRequests.size() > 0) {
			
			System.out.println(" size of up pq : " + this.upPq.size());
			System.out.println(" size of down pq : " + this.downPq.size());
			System.out.println(" size of pending pq : " + this.pendingRequests.size());

			
			while ( !this.upPq.isEmpty() || !this.downPq.isEmpty() || this.pendingRequests.size() > 0) {
				
				while ( !upPq.isEmpty() || !downPq.isEmpty()) {
					
					if (this.elevator.dir == Direction.UP && this.upPq.size()>0) {
						System.out.println(" process up");
						processRequest(this.upPq);
					}
					else if (this.elevator.dir == Direction.DOWN && this.downPq.size()>0) {
						System.out.println(" process down");
						processRequest(this.downPq);
					}
					flipDirection();
					
				}
				
			
				if (pendingRequests.size() > 0) {
					int currentFloor = this.elevator.currentFloor;
					
					for (Integer i : this.pendingRequests) {
						
						if (currentFloor > i) {
							this.downPq.add(i);
							System.out.println(" pending req : " + i + " is added to down pq , currentFloor : " + currentFloor);
						}
						else {
							this.upPq.add(i);
							System.out.println(" pending req : " + i + " is added to up pq , currentFloor : " + currentFloor);
						}
					}
				}
				else {
					System.out.println(" there is no pending request for elevator : " + this.ecid);
				}
				
			}
			
			flipStatus();
			
		}
		else {
			System.out.println(" there is no request to process for elevator : " + this.ecid);
		}
		
		System.out.println("\n \n");
	}
	
	public void flipStatus() {
		Status oldStatus = this.elevator.status;
		Status newStatus = Status.IDLE == oldStatus ? Status.MOVING : Status.IDLE;
		this.elevator.status = newStatus;
		System.out.println(" status of elevator : " + this.ecid + " is changed from " + oldStatus + " to " + newStatus);
		
	}

	private void flipDirection() {
		Direction olddir = this.elevator.dir;
		Direction newDir = Direction.UP == olddir ? Direction.DOWN : Direction.UP;
		this.elevator.dir = newDir;
		System.out.println(" dir of elevator : " + this.ecid + " is changed from " + olddir + " to " + newDir);
	}
	
	

	private void processRequest(PriorityQueue<Integer> pq) {
		
		while(!pq.isEmpty()) {
			int df = pq.poll();
			this.elevator.currentFloor = df;
			displayCurrentFloor();
		}
	}

	private void displayCurrentFloor() {
		this.elevator.display();
	}
}
