package com.dp.demo.unittests;

import com.dp.demo.contracts.Brake;
import com.dp.demo.contracts.Engine;
import com.dp.demo.implementation.CarHonda;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CarHondaTest {

    private CarHonda car;
    private Brake fakeBrake;
    private Engine fakeEngine;

    @Before
    public void setup()
    {
        fakeBrake = Mockito.mock(Brake.class);
        fakeEngine = Mockito.mock(Engine.class);
        car = new CarHonda(fakeBrake, fakeEngine);
    }

    @Test
    public void shouldCallBrakeGetOnce()
    {
        car.model();
        verify(fakeBrake, times(1)).get();
        verify(fakeEngine, times(1)).get();
    }
}
