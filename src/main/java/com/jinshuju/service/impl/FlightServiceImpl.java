package com.jinshuju.service.impl;

import com.jinshuju.dao.FlightInfoDAO;
import com.jinshuju.dao.FlightPriceDAO;
import com.jinshuju.dao.model.FlightInfoDTO;
import com.jinshuju.dao.model.FlightPriceDTO;
import com.jinshuju.enums.CustomerTypeEnum;
import com.jinshuju.service.FlightService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description
 * @outhor xuhang
 * @create 2020-03-27 15:00
 */
public class FlightServiceImpl implements FlightService {

    private FlightInfoDAO flightInfoDAO;

    private FlightPriceDAO flightPriceDAO;

    /**
     * @param customerTypeEnum 客户类型
     * @param from             始发地
     * @param to               目的地
     * @param startTime        航班起飞时间
     * @param returnTime       航班结束时间
     * @return
     */
    @Override
    public FlightInfoDTO filterFlights(CustomerTypeEnum customerTypeEnum, String from, String to, String startTime, String returnTime) {
        //根据始发地，目的地，起飞时间，回程时间查询出符合条件的航班
        List<FlightInfoDTO> flights = flightInfoDAO.listSpecifyFlights(from, to, startTime, returnTime);
        return filterFlights(customerTypeEnum, flights);
    }

    //过滤航班
    private FlightInfoDTO filterFlights(CustomerTypeEnum customerTypeEnum, List<FlightInfoDTO> flights) {
        FlightInfoDTO flight = null;
        List<FlightPriceDTO> priceList = new ArrayList<>();
        List<BigDecimal> prices = new ArrayList<>();

        for (FlightInfoDTO flightItem : flights) {
            //根据航班号和客户类型筛选出对应航班的价格
            FlightPriceDTO flightPrice = flightPriceDAO.getFlightPriceByFlightNumAndCustomerTypeEnum(flightItem.getFlightNumber(), customerTypeEnum);
            priceList.add(flightPrice);
            prices.add(flightPrice.getPrice());
        }

        //对航班的价格升序和时间的降序排序
        Collections.sort(prices);
        BigDecimal lowestPrice = prices.get(0);
        priceList.stream()
                .filter(flightInfoDTO -> flightInfoDTO.getPrice().equals(lowestPrice))
                .collect(Collectors.toList())
                .stream()
                .sorted(Comparator.comparing(FlightPriceDTO::getDateTypeEnum).reversed()).collect(Collectors.toList());

        String flightNum = priceList.get(0).getFlightNumber();
        for (FlightInfoDTO flightItem : flights) {
            if (flightItem.getFlightNumber() == flightNum) {
                flight = flightItem;
            }
        }
        return flight;
    }
}
