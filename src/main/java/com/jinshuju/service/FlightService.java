package com.jinshuju.service;

import com.jinshuju.dao.model.FlightInfoDTO;
import com.jinshuju.enums.CustomerTypeEnum;

import java.util.List;

/**
 * 航班价格信息服务
 *
 * @author tanchaowen
 */
public interface FlightService {

    /**
     * 查询航班信息
     *
     * @param from             始发地
     * @param to               目的地
     * @param travelTime       出行时间
     * @return 航班信息集合
     */
    List<FlightInfoDTO> getFlights(String from, String to, String travelTime);

    /**
     * 获取航班信息默认方法（获取价格最低&出发时间最早的航班）
     *
     * @param customerTypeEnum
     * @param startTime
     * @param returnTime
     * @return
     */
    List<FlightInfoDTO> getFlightsByDefault(CustomerTypeEnum customerTypeEnum, String startTime, String returnTime);

}
