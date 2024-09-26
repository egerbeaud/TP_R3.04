package fr.unilim.iut.tirepressuremonitoringsystem;

public class AlarmController {

	private Alarm alarm;
	private PressureSensor sensorPressure;
	
	public AlarmController(Alarm alarm, PressureSensor sensorPressure) {
		this.alarm = alarm;
		this.sensorPressure = sensorPressure;
	}
	
	public void check()
    {
        if ( sensorPressure.sensoredValueIsNotGood())
        {
            this.alarm.alarmTriggering();
        }
        else {
        	this.alarm.stopAlarm();
        }
    }
	

	
	
}
