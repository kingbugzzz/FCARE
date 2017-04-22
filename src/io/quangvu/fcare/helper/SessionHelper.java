package io.quangvu.fcare.helper;

public class SessionHelper {
	
	private SessionHelper(){}
	
	public static String getSessionUser() {
		return (IOHelper.read(".session/.temp").split("#"))[3];
	}
}
