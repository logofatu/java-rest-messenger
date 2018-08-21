package logofatu.galina.messenger.database;

import java.util.HashMap;
import java.util.Map;

import logofatu.galina.messenger.model.Message;
import logofatu.galina.messenger.model.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<Long, Profile> profiles = new HashMap<>();
	
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static void setMessages(Map<Long, Message> messages) {
		DatabaseClass.messages = messages;
	}
	public static Map<Long, Profile> getProfiles() {
		return profiles;
	}
	public static void setProfiles(Map<Long, Profile> profiles) {
		DatabaseClass.profiles = profiles;
	}
	
}
