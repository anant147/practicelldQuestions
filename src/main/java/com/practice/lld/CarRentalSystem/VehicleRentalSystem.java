package com.practice.lld.CarRentalSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleRentalSystem {
	
	
	List<User> users;
	List<Store> stores;
	Map<String, List<Store>> allStoresInfo;
	Map<User, Store> transaction;
	
	public VehicleRentalSystem() {
		this.users = new ArrayList<>();
		this.stores = new ArrayList<>();
		this.allStoresInfo = new HashMap<>();
		this.transaction = new HashMap<>();
	}
	
	public void addStore(Store store) {
		this.stores.add(store);
		String address = store.loc.address;
		List<Store> st = new ArrayList<>();
		if (this.allStoresInfo.containsKey(address)) {
			st = this.allStoresInfo.get(address);
		}
		else {
			this.allStoresInfo.put(address, st);
		}
		st.add(store);
	}
	
	public void addUser(User user) {
		this.users.add(user);
	}
	
	public void addVehicle(int storeid, Vehicle vh) {
		Store store = getStore(storeid);
		if (store != null) {
			store.addVehicle(vh);
		}
		else {
			System.out.println(" store with " + storeid + " not present");
		}
	}
	
	public void removeVehicle(int storeid, Vehicle vh) {
		Store store = getStore(storeid);
		if (store != null) {
			store.removeVehicle(vh);
		}
		else {
			System.out.println(" store with " + storeid + " not present");
		}
	}
	
	private Store getStore(int storeid) {
		for (Store store : this.stores) {
			if(storeid == store.storeid)
				return store;
		}
		return null;
	}

	public Vehicle searchVehicle(VehicleType vt, Location location) {
		String address = location.address;
		if (this.allStoresInfo.containsKey(address)) {
			List<Store> stores = this.allStoresInfo.get(address);
			for (Store store : stores) {
				Vehicle vh = store.getAvailableVehicle(vt);
				if (vh != null) {
					return vh;
				}
			}
		}
		System.out.println(" vehcile of " + vt + " is not present in " + location.address);
		return null;
	}
	
	public Reservation reserveVehicle(int storeid, User user, Vehicle vehicle, int reserveId, int bookedFrom, int bookedTo) {
		Store store = getStore(storeid);
		if (store != null) {
			this.transaction.put(user, store);
			return store.reserveVehicle(user, vehicle, reserveId, bookedFrom, bookedTo);
		}
		System.out.println(" store : " + storeid + " not present");
		return null;
	}
	
	public void cancelReservation(Reservation res) {
		Store store = getStoreFromMap(res.user);
		if (store != null) {
			store.cancelReservation(res);
		}
	}
	
	public void accessReservation(Reservation res) {
		Store store = getStoreFromMap(res.user);
		if (store != null) {
			store.accessReservation(res);
		}
	}
	
	private Store getStoreFromMap(User user) {
		return this.transaction.get(user);
	}
	
	public Bill getBill(int billid, Reservation res) {
		Store store = getStoreFromMap( res.user);
		if (store != null) {
			return store.makeBill(billid, res);
		}
		return null;
	}
	
	public Payment makePayment(int paymentid, Bill bill, boolean doPayment) {
		Store store = getStoreFromMap(bill.reservation.user );
		if (store != null) {
			store.makePayment(paymentid, bill, doPayment);
			this.transaction.remove(bill.reservation.user);
			return store.makePayment(paymentid, bill, doPayment);
		}
		return null;
	}
	
}
