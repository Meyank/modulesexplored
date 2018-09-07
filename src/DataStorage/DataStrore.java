package DataStorage;

import java.util.ArrayList;
import java.util.List;

public class DataStrore {

	private List<String> signatureDataStore = null;

	public DataStrore() {
		signatureDataStore = new ArrayList<>();
	}

	public void addStringToDataStore() {
		signatureDataStore.add("ram");
		signatureDataStore.add("shaym");
		signatureDataStore.add("rohan");

	}

	private int[] calculateSignature(String input) {

		int total = 0;
		String temp = null;
		int[] all = new int[5];

		if (input != "") {
			temp = input;
			for (int i = 0; i < temp.length(); i++) {
				Character c = temp.charAt(i);
				total = total * 2 + (int) (c);

			}
			all[0] = total;
		}
		if (input.equalsIgnoreCase("")) {
			for (int i = 0; i < signatureDataStore.size(); i++) {
				temp = this.signatureDataStore.get(i);
				for (int j = 0; j < temp.length(); j++) {
					Character c = temp.charAt(j);
					total = total * 2 + (int) (c);
				}
				all[i] = total;
			}

		}

		return all;

	}

	public int acceptAndReturn(String input) {

		int[] resultFromInput = this.calculateSignature(input);

		int[] resultFromDataStore = this.calculateSignature("");

		int distance = Math.abs(resultFromDataStore[0] - resultFromInput[0]);
		int idx = 0;
		for (int c = 1; c < resultFromDataStore.length; c++) {
			int cdistance = Math.abs(resultFromDataStore[c] - resultFromInput[0]);
			if (cdistance < distance) {
				idx = c;
				distance = cdistance;
			}
		}
		int theNumber = resultFromDataStore[idx];
		return theNumber;

	}
}
