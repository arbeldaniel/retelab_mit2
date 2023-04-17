package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.time.LocalTime;
import com.google.common.collect.ArrayTable;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	public Table<LocalTime, Integer, Integer> tacho;


	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		int lastSpeedLimit = this.speedLimit;
		this.speedLimit = speedLimit;
		if(speedLimit < 0 || speedLimit > 500)
		{
			user.setAlarmState(true);
		}
		// else if(speedLimit < lastSpeedLimit * 0.5)
		// {
		// 	user.setAlarmState(true);
		// }
		controller.setSpeedLimit(speedLimit);
	}

	public void refereshTacho() {
		tacho = HashBasedTable.create();
		tacho.put(LocalTime.now(), 1, 1);
	}

	public Table<LocalTime, Integer, Integer> getTacho(){
		return tacho;
	}

}
