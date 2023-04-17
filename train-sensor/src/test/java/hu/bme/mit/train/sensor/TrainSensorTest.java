package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {
    private TrainController tc;
    private TrainUser tu;
    private TrainSensorImpl trainSensor;

    @Before
    public void before() {
        tc = mock(TrainController.class);
        tu = mock(TrainUser.class);
        trainSensor = new TrainSensorImpl(tc, tu);
    }

    
    @Test
    public void SpeedLimitMinTest()
    {
        trainSensor.overrideSpeedLimit(-1);
        verify(tu, times(1)).setAlarmState(true);
    }
    @Test
    public void SpeedLimitMaxTest()
    {
        trainSensor.overrideSpeedLimit(501);
        verify(tu,times(1)).setAlarmState(true);
    }
    @Test
    public void SpeedLimitRealMarginTest()
    {
        trainSensor.overrideSpeedLimit(4);
        verify(tu, times(0)).setAlarmState(true);
    }

    @Test
    public void SpeedLimitBetweenTest()
    {
        trainSensor.overrideSpeedLimit(300);
        verify(tu, times(0)).setAlarmState(true);
    }


    @Test
    public void ThisIsAnExampleTestStub() {
        // TODO Delete this and add test cases based on the issues
    }

    @Test
    public void TachoWorking() {
        TrainSensorImpl x = new TrainSensorImpl(tc, tu);
        x.refereshTacho();
        
        assertFalse(x.getTacho().isEmpty());

    }
}
