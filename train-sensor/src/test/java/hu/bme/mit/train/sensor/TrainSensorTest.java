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

    @Before
    public void before() {
        // TODO Add initializations
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
