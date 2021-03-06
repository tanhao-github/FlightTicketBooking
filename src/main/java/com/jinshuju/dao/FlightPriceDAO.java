package com.jinshuju.dao;

import com.jinshuju.dao.model.FlightPriceDTO;
import com.jinshuju.enums.CustomerTypeEnum;
import com.jinshuju.enums.DateTypeEnum;

import java.util.List;

/**
 * @author tanchaowen
 */
public interface FlightPriceDAO {

    /**
     * 保存航班价格信息
     *
     * @param flightPriceDTO
     * @return true | false
     */
    boolean save(FlightPriceDTO flightPriceDTO);

    /**
     * 更新航班价格信息
     *
     * @param flightPriceDTO
     * @return true | false
     */
    boolean update(FlightPriceDTO flightPriceDTO);

    /**
     * 根据航班号删除航班价格信息
     *
     * @param flightNumber
     * @return true | false
     */
    boolean delete(String flightNumber);

    /**
     * 根据航班号查找航班价格信息
     *
     * @param flightNumber
     * @return 航班信息DTO
     */
    List<FlightPriceDTO> getFlightPrice(String flightNumber);

    /**
     * 根据航班号和客户类型以及日期类型精确获取价格
     *
     * @param flightNumber
     * @param customerTypeEnum
     * @param dateTypeEnum
     * @return
     */
    FlightPriceDTO getFlightPrice(String flightNumber, CustomerTypeEnum customerTypeEnum, DateTypeEnum dateTypeEnum);

}
