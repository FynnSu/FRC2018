package org.usfirst.frc.team6141.misc;

import edu.wpi.first.wpilibj.DriverStation;

public class GameData {
	
	private Setting[] pointSetting;
	private int location;
	
	public GameData(DriverStation station) {
		String data = station.getGameSpecificMessage();
		pointSetting = new Setting[3];
		char[] data_char = data.toCharArray();
		for (int i = 0; i < data_char.length; i++) {
			if (data_char[i] == 'L') {
				pointSetting[i] = Setting.LEFT;
			} else {
				pointSetting[i] = Setting.RIGHT;
			}
		}
		
		location = station.getLocation();
		
		
	}
	
	public int getLocation() {
		return location;
	}
	
	public Setting getSwitch() {
		return pointSetting[0];
	}
	
	public Setting getScale() {
		return pointSetting[1];
	}
	
	public Setting getEnemySwitch() {
		return pointSetting[2];
	}
		

}
