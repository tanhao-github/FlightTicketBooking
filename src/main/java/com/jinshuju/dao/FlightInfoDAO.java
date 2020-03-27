package com.jinshuju.dao;

import com.jinshuju.dao.model.FlightInfoDTO;
import com.jinshuju.enums.CustomerTypeEnum;
import com.jinshuju.enums.DateTypeEnum;

import java.util.List;

/**
 *
 * @author tanchaowen
 */
public interface FlightInfoDAO {

    /**
     * 保存航班信息
     *
     * @param flightInfoDTO
     * @return true | false
     */
    boolean save(FlightInfoDTO flightInfoDTO);

    /**
     * 更新航班信息
     *
     * @param flightInfoDTO
     * @return true | false
     */
    boolean update(FlightInfoDTO flightInfoDTO);

    /**
     * 删除航班信息
     *
     * @param flightNumber
     * @return true | false
     */
    boolean delete(String flightNumber);

    /**
     * 根据航班号查找航班信息
     *
     * @param flightNumber
     * @return 航班信息DTO
     */
    FlightInfoDTO getFlightInfo(String flightNumber);

    /**
     * 根据出发城市和到达城市查找航班信息
     * @param from 出发城市(必须)
     * @param to 到达城市(必须)
     * @return
     */
    List<FlightInfoDTO> getFlightInfo(String from, String to);


    /**
     *
     * @param from 出发城市(必须)
     * @param to 到达城市(必须)
     * @param startTime 出发时间
     * @param returnTime 返程时间
     * @return
     */
    List<FlightInfoDTO> listSpecifyFlights(String from, String to,String startTime,String returnTime);

}
