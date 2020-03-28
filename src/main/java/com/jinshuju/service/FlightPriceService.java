package com.jinshuju.service;

import com.jinshuju.dao.model.FlightInfoDTO;
import com.jinshuju.enums.CustomerTypeEnum;
import com.jinshuju.enums.DateTypeEnum;

import java.util.List;

/**
 * 航班价格服务
 *
 * @author tanchaowen
 */
public interface FlightPriceService {

    /**
     * 补充航班价格到航班信息
     *
     * @param flightInfoDTOList
     * @param customerTypeEnum
     * @param dateTypeEnum
     */
    void getFlightPriceIntoFlightInfo(List<FlightInfoDTO> flightInfoDTOList, CustomerTypeEnum customerTypeEnum, DateTypeEnum dateTypeEnum);

}
