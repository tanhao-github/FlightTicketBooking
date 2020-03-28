package com.jinshuju.strategy;

import com.jinshuju.dao.model.FlightInfoDTO;

import java.util.List;

/**
 * 航班筛选策略
 *
 * @author tanchaowen
 */
public interface FlightStrategy {

    /**
     * 筛选航班
     * @param flightInfoDTOList 待筛选的航班
     * @return
     */
    FlightInfoDTO getFlight(List<FlightInfoDTO> flightInfoDTOList);

}