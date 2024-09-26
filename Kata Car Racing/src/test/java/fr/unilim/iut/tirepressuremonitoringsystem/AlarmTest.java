package fr.unilim.iut.tirepressuremonitoringsystem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlarmTest {
	
	@Test
	void shouldTriggerAlarmByTooLowPressure() {
		
		PressureSensor sensor = mock(PressureSensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(15.0);
		
		Alarm alarm = new Alarm();
		AlarmController controller = new AlarmController(alarm,sensor);
		
		controller.check();
		assertTrue(alarm.isAlarmOn());		
	}
	
	@Test
	void shouldTriggerAlarmByTooHighPressure() {
		
		PressureSensor sensor = mock(PressureSensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(30.0);
		
		Alarm alarm = new Alarm();
		AlarmController controller = new AlarmController(alarm,sensor);
		System.out.println(sensor.popNextPressurePsiValue());
		
		controller.check();
		assertTrue(alarm.isAlarmOn());		
	}
	
	@Test
	void shouldNotTriggerAlarmByGoodPressure() {
		
		PressureSensor sensor = mock(PressureSensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(18.0);
		
		Alarm alarm = new Alarm();
		AlarmController controller = new AlarmController(alarm,sensor);
		
		controller.check();
		assertFalse(alarm.isAlarmOn());		
	}
	@Test
	void shouldTriggerAlarmAndStayTriggered() {
		
		PressureSensor sensor = mock(PressureSensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(15.0);
		
		Alarm alarm = new Alarm();
		AlarmController controller = new AlarmController(alarm,sensor);
		
		controller.check();
		
		when(sensor.popNextPressurePsiValue()).thenReturn(18.0);
		controller.check();
		
		assertFalse(alarm.isAlarmOn());
	}
}
