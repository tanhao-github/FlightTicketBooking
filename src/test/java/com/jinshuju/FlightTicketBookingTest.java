package com.jinshuju;

import com.jinshuju.enums.CustomerTypeEnum;
import com.jinshuju.service.FlightService;
import com.jinshuju.service.impl.FlightServiceImpl;
import org.junit.Before;
import org.junit.Test;

public class FlightTicketBookingTest {

    FlightService flightService;

    @Before
    public void init(){
        flightService = new FlightServiceImpl();
    }

    @Test
    public void testGetFlightsByDefault(){
        System.out.println(flightService.getFlightsByDefault(CustomerTypeEnum.REGULAR,"20200328","20200331"));
    }

}
