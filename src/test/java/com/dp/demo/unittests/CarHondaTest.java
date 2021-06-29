package com.dp.demo.unittests;

import com.dp.demo.contracts.Brake;
import com.dp.demo.contracts.Engine;
import com.dp.demo.implementation.CarHonda;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

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
    public void shouldReturnCarModelasHondaWhenModelIsCalled()
    {
       assertTrue(car.model().equals("Honda City"));
    }

    @Test
    public void shouldReturnCarModelWithBrakeAndEngineDetails()
    {
        when(fakeBrake.get()).thenReturn("fake Brake");
        when(fakeEngine.get()).thenReturn("fake Engine");

        assertTrue(car.description().equals("Honda City Car with fake Brake,fake Engine"));
    }
}
