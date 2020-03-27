package com.jinshuju.dao.impl;

import com.jinshuju.dao.FlightPriceDAO;
import com.jinshuju.dao.model.FlightPriceDTO;
import com.jinshuju.enums.CustomerTypeEnum;
import com.jinshuju.enums.DateTypeEnum;
import com.sun.tools.javac.util.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tanchaowen
 */
public class FlightPriceDAOImpl implements FlightPriceDAO {

    /**
     * 模拟价格信息
     */
    private static List<FlightPriceDTO> flightPriceDTOList = Collections.synchronizedList(new ArrayList<>(24));

    //初始化航班价格信息数据
    static {
        flightPriceDTOList.add(new FlightPriceDTO("GD2501", CustomerTypeEnum.REGULAR, DateTypeEnum.WEEKDAYS,new BigDecimal("1100")));
        flightPriceDTOList.add(new FlightPriceDTO("GD2501", CustomerTypeEnum.REWARD, DateTypeEnum.WEEKDAYS,new BigDecimal("800")));
        flightPriceDTOList.add(new FlightPriceDTO("GD2501", CustomerTypeEnum.REGULAR, DateTypeEnum.WEEKENDS,new BigDecimal("900")));
        flightPriceDTOList.add(new FlightPriceDTO("GD2501", CustomerTypeEnum.REWARD, DateTypeEnum.WEEKENDS,new BigDecimal("500")));

        flightPriceDTOList.add(new FlightPriceDTO("GD2606", CustomerTypeEnum.REGULAR, DateTypeEnum.WEEKDAYS,new BigDecimal("1600")));
        flightPriceDTOList.add(new FlightPriceDTO("GD2606", CustomerTypeEnum.REWARD, DateTypeEnum.WEEKDAYS,new BigDecimal("1100")));
        flightPriceDTOList.add(new FlightPriceDTO("GD2606", CustomerTypeEnum.REGULAR, DateTypeEnum.WEEKENDS,new BigDecimal("600")));
        flightPriceDTOList.add(new FlightPriceDTO("GD2606", CustomerTypeEnum.REWARD, DateTypeEnum.WEEKENDS,new BigDecimal("500")));

        flightPriceDTOList.add(new FlightPriceDTO("GD8732", CustomerTypeEnum.REGULAR, DateTypeEnum.WEEKDAYS,new BigDecimal("2200")));
        flightPriceDTOList.add(new FlightPriceDTO("GD8732", CustomerTypeEnum.REWARD, DateTypeEnum.WEEKDAYS,new BigDecimal("1000")));
        flightPriceDTOList.add(new FlightPriceDTO("GD8732", CustomerTypeEnum.REGULAR, DateTypeEnum.WEEKENDS,new BigDecimal("1500")));
        flightPriceDTOList.add(new FlightPriceDTO("GD8732", CustomerTypeEnum.REWARD, DateTypeEnum.WEEKENDS,new BigDecimal("400")));

        flightPriceDTOList.add(new FlightPriceDTO("GD2502", CustomerTypeEnum.REGULAR, DateTypeEnum.WEEKDAYS,new BigDecimal("1700")));
        flightPriceDTOList.add(new FlightPriceDTO("GD2502", CustomerTypeEnum.REWARD, DateTypeEnum.WEEKDAYS,new BigDecimal("800")));
        flightPriceDTOList.add(new FlightPriceDTO("GD2502", CustomerTypeEnum.REGULAR, DateTypeEnum.WEEKENDS,new BigDecimal("900")));
        flightPriceDTOList.add(new FlightPriceDTO("GD2502", CustomerTypeEnum.REWARD, DateTypeEnum.WEEKENDS,new BigDecimal("800")));

        flightPriceDTOList.add(new FlightPriceDTO("GD2607", CustomerTypeEnum.REGULAR, DateTypeEnum.WEEKDAYS,new BigDecimal("1600")));
        flightPriceDTOList.add(new FlightPriceDTO("GD2607", CustomerTypeEnum.REWARD, DateTypeEnum.WEEKDAYS,new BigDecimal("1100")));
        flightPriceDTOList.add(new FlightPriceDTO("GD2607", CustomerTypeEnum.REGULAR, DateTypeEnum.WEEKENDS,new BigDecimal("600")));
        flightPriceDTOList.add(new FlightPriceDTO("GD2607", CustomerTypeEnum.REWARD, DateTypeEnum.WEEKENDS,new BigDecimal("500")));

        flightPriceDTOList.add(new FlightPriceDTO("GD8733", CustomerTypeEnum.REGULAR, DateTypeEnum.WEEKDAYS,new BigDecimal("1600")));
        flightPriceDTOList.add(new FlightPriceDTO("GD8733", CustomerTypeEnum.REWARD, DateTypeEnum.WEEKDAYS,new BigDecimal("1500")));
        flightPriceDTOList.add(new FlightPriceDTO("GD8733", CustomerTypeEnum.REGULAR, DateTypeEnum.WEEKENDS,new BigDecimal("1000")));
        flightPriceDTOList.add(new FlightPriceDTO("GD8733", CustomerTypeEnum.REWARD, DateTypeEnum.WEEKENDS,new BigDecimal("400")));

    }

    @Override
    public boolean save(FlightPriceDTO flightPriceDTO) {
        //TODO 只是简单判断，应该做更详细字段检查
        Assert.checkNonNull(flightPriceDTO,"保存的信息不能为空");
        return flightPriceDTOList.add(flightPriceDTO);
    }

    @Override
    public boolean update(FlightPriceDTO flightInfoDTO) {
        return false;
    }

    @Override
    public boolean delete(String flightNumber) {
        return false;
    }

    @Override
    public List<FlightPriceDTO> getFlightPrice(String flightNumber) {
        if(null != flightNumber && !flightNumber.trim().isEmpty()){
            return flightPriceDTOList.stream()
                    .filter(flightPriceDTO -> flightPriceDTO.getFlightNumber().equals(flightNumber))
                    .collect(Collectors.toList());
        }
        return null;
    }

}
