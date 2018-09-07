package startup;

import DataStorage.DataStrore;

public class StartUP {
	public static void main(String[] args) {
		DataStrore ds = new DataStrore();
		ds.addStringToDataStore();
		
		System.out.println(ds.acceptAndReturn("shyam"));
	}
}
