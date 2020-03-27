package com.jinshuju.dao.impl;

import com.jinshuju.dao.FlightInfoDAO;
import com.jinshuju.dao.model.FlightInfoDTO;
import com.sun.tools.javac.util.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tanchaowen
 */
public class FlightInfoDAOImpl implements FlightInfoDAO {

    /**
     * 模拟数据库数据表信息
     */
    private static List<FlightInfoDTO> flightInfoDTOList = Collections.synchronizedList(new ArrayList<>(16));

    //初始化航班信息数据
    static {
        flightInfoDTOList.add(new FlightInfoDTO("GD2501","08:00","西安","成都"));
        flightInfoDTOList.add(new FlightInfoDTO("GD2606","12:25","西安","成都"));
        flightInfoDTOList.add(new FlightInfoDTO("GD8732","19:30","西安","成都"));
        flightInfoDTOList.add(new FlightInfoDTO("GD2502","12:00","成都","西安"));
        flightInfoDTOList.add(new FlightInfoDTO("GD2607","16:25","成都","西安"));
        flightInfoDTOList.add(new FlightInfoDTO("GD8733","23:30","成都","西安"));
    }

    @Override
    public boolean save(FlightInfoDTO flightInfoDTO) {
        //TODO 只是简单判断，应该做更详细字段检查
        Assert.checkNonNull(flightInfoDTO,"保存的信息不能为空");
        return flightInfoDTOList.add(flightInfoDTO);
    }

    @Override
    public boolean update(FlightInfoDTO flightInfoDTO) {
        return false;
    }

    @Override
    public boolean delete(String flightNumber) {
        return false;
    }

    @Override
    public FlightInfoDTO getFlightInfo(String flightNumber) {
        if(null != flightNumber && !flightNumber.trim().isEmpty()){
            return flightInfoDTOList.stream()
                    .filter(flightInfoDTO -> flightInfoDTO.getFlightNumber().equals(flightNumber))
                    .collect(Collectors.toList())
                    .get(0);
        }
        return null;
    }

    @Override
    public List<FlightInfoDTO> getFlightInfo(String from, String to) {
        if(null != from && !from.trim().isEmpty() && null != to && !to.isEmpty()){
            return flightInfoDTOList.stream()
                    .filter(flightInfoDTO -> flightInfoDTO.getFrom().equals(from) && flightInfoDTO.getTo().equals(to))
                    .collect(Collectors.toList());
        }
        return null;
    }

}
