package com.jinshuju.service;

import com.jinshuju.dao.model.FlightInfoDTO;
import com.jinshuju.enums.CustomerTypeEnum;

import java.util.List;

/**
 * @description
 * @outhor xuhang
 * @create 2020-03-27 14:58
 */
public interface FlightService {

    FlightInfoDTO filterFlights(CustomerTypeEnum customerTypeEnum, String from, String to, String startTime, String returnTime);

}
