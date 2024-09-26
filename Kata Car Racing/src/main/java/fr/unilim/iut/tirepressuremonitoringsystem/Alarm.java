package fr.unilim.iut.tirepressuremonitoringsystem;

public class Alarm
{

    private boolean alarmOn;
    
	public Alarm() {
    	this.alarmOn = false;
    }
    
 
    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
    
    public void alarmTriggering() {
    	this.alarmOn = true;
    }
    
    public void stopAlarm() {
    	this.alarmOn = false;
    }
}
