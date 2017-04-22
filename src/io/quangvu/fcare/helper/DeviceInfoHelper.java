package io.quangvu.fcare.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DeviceInfoHelper {

	private DeviceInfoHelper() {
	}

	public static String getSerialNumber() {
		try {
			ProcessBuilder pb = new ProcessBuilder("wmic", "baseboard", "get", "serialnumber");
			Process process = pb.start();
			process.waitFor();
			String serialNumber = "";
			try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
				for (String line = br.readLine(); line != null; line = br.readLine()) {
					if (line.length() < 1 || line.startsWith("SerialNumber")) {
						continue;
					}
					serialNumber = line;
					break;
				}
			}
			return serialNumber;
		} catch (Exception ex) {
			return null;
		}
	}
}
