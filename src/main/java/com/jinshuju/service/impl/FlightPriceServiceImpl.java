package com.jinshuju.service.impl;

import com.jinshuju.dao.FlightPriceDAO;
import com.jinshuju.dao.impl.FlightPriceDAOImpl;
import com.jinshuju.dao.model.FlightInfoDTO;
import com.jinshuju.dao.model.FlightPriceDTO;
import com.jinshuju.enums.CustomerTypeEnum;
import com.jinshuju.enums.DateTypeEnum;
import com.jinshuju.service.FlightPriceService;
import com.sun.tools.javac.util.Assert;

import java.util.Iterator;
import java.util.List;

/**
 * 航班价格服务实现
 *
 * @author tanchaowen
 */
public class FlightPriceServiceImpl implements FlightPriceService {

    FlightPriceDAO flightPriceDAO = new FlightPriceDAOImpl();

    @Override
    public void getFlightPriceIntoFlightInfo(List<FlightInfoDTO> flightInfoDTOList, CustomerTypeEnum customerTypeEnum, DateTypeEnum dateTypeEnum) {
        Assert.checkNonNull(flightInfoDTOList,"航班信息不能为空");
        Assert.checkNonNull(customerTypeEnum,"客户类型不能为空");
        Assert.checkNonNull(dateTypeEnum,"日期类型不能为空");

        Iterator<FlightInfoDTO> iterator = flightInfoDTOList.iterator();
        while (iterator.hasNext()){
            FlightInfoDTO flightInfoDTO = iterator.next();
            FlightPriceDTO flightPriceDTO = flightPriceDAO.getFlightPrice(flightInfoDTO.getFlightNumber(),customerTypeEnum,dateTypeEnum);
            flightInfoDTO.setFlightPrice(null != flightPriceDTO ? flightPriceDTO.getPrice() : null);
        }

    }
}
