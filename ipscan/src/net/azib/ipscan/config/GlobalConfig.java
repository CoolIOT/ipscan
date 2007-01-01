/**
 * 
 */
package net.azib.ipscan.config;

import java.util.prefs.Preferences;

/**
 * Global configuration holder.
 *
 * @author anton
 */
public final class GlobalConfig {
	
	private Preferences preferences;

	public int maxThreads;
	public int threadDelay;
	public int activeFeeder;
	public boolean scanDeadHosts;
	public String selectedPinger;
	public int pingTimeout;
	public int pingCount;
	public boolean skipBroadcastAddresses;
	public int portTimeout;
	public boolean adaptPortTimeout;
	public String portString;

	/**
	 * Package local constructor.
	 * It loads all preferences.
	 * @param preferences
	 */
	GlobalConfig(Preferences preferences) {
		this.preferences = preferences;
		
		maxThreads = preferences.getInt("maxThreads", 100);
		threadDelay = preferences.getInt("threadDelay", 20);
		activeFeeder = preferences.getInt("activeFeeder", 0);
		scanDeadHosts = preferences.getBoolean("scanDeadHosts", false);
		selectedPinger = preferences.get("selectedPinger", "pinger.icmp");
		pingTimeout = preferences.getInt("pingTimeout", 3000);
		pingCount = preferences.getInt("pingCount", 3);
		skipBroadcastAddresses = preferences.getBoolean("skipBroadcastAddresses", true);
		portTimeout = preferences.getInt("portTimeout", 3000);
		adaptPortTimeout = preferences.getBoolean("adaptPortTimeout", true);
		portString = preferences.get("portString", "");
	}
		
	/**
	 * Stores all the internal properties to the storage media
	 */
	public void store() {
		preferences.putInt("maxThreads", maxThreads);
		preferences.putInt("threadDelay", threadDelay);
		preferences.putInt("activeFeeder", activeFeeder);
		preferences.putBoolean("scanDeadHosts", scanDeadHosts);
		preferences.put("selectedPinger", selectedPinger);
		preferences.putInt("pingTimeout", pingTimeout);
		preferences.putInt("pingCount", pingCount);
		preferences.putBoolean("skipBroadcastAddresses", skipBroadcastAddresses);
		preferences.putInt("portTimeout", portTimeout);
		preferences.putBoolean("adaptPortTimeout", adaptPortTimeout);
		preferences.put("portString", portString);
	}
}
