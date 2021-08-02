package com.example.app1.unittests;

import contracts.Brake;
import contracts.Engine;
import implementation.CarHonda;
import org.junit.*;
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
    public void shouldCallBrakeGetOnce()
    {
        String expectation = "Honda Car with test Brake,test Engine";
        when(fakeBrake.get()).thenReturn("test Brake");
        when(fakeEngine.get()).thenReturn("test Engine");
        String actual = car.getModel();
        assertTrue(actual.equals(expectation));
        verify(fakeBrake, times(1)).get();
        verify(fakeEngine, times(1)).get();
    }
}
