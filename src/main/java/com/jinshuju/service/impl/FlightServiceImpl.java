package com.jinshuju.service.impl;

import com.jinshuju.dao.FlightInfoDAO;
import com.jinshuju.dao.impl.FlightInfoDAOImpl;
import com.jinshuju.dao.model.FlightInfoDTO;
import com.jinshuju.enums.CustomerTypeEnum;
import com.jinshuju.service.FlightPriceService;
import com.jinshuju.service.FlightService;
import com.jinshuju.strategy.FlightPriceStrategy;
import com.jinshuju.strategy.FlightStrategyContext;
import com.jinshuju.utils.CommUtils;
import com.sun.tools.javac.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 航班信息服务实现
 *
 * @author tanchaowen
 */
public class FlightServiceImpl implements FlightService {

    private FlightInfoDAO flightInfoDAO = new FlightInfoDAOImpl();

    private FlightPriceService flightPriceService = new FlightPriceServiceImpl();

    /**
     * 默认出发城市
     */
    private final static String DEF_FROM = "西安";

    /**
     * 默认到达城市
     */
    private final static String DEF_TO = "成都";

    @Override
    public List<FlightInfoDTO> getFlights(String from, String to, String travelTime) {
        //TODO 因为航班是固定每天都有，所以暂时 travelTime 不用
        List<FlightInfoDTO> flightInfoDTOList = flightInfoDAO.getFlightInfo(from, to);
        return flightInfoDTOList;
    }

    @Override
    public List<FlightInfoDTO> getFlightsByDefault(CustomerTypeEnum customerTypeEnum, String startTime, String returnTime) {
        Assert.checkNonNull(customerTypeEnum,"请输入客户类型");
        Assert.checkNonNull(startTime,"请输入出发时间");
        Assert.checkNonNull(returnTime,"请输入返程时间");

        List<FlightInfoDTO> result = new ArrayList<>();

        //出发航班
        List<FlightInfoDTO> departFlightInfoDTOList = getFlights(DEF_FROM, DEF_TO, startTime);
        //回程航班
        List<FlightInfoDTO> returnFlightInfoDTOList = getFlights(DEF_TO, DEF_FROM, returnTime);

        //根据航班和客户类型和日期类型得到航班最终价格
        flightPriceService.getFlightPriceIntoFlightInfo(departFlightInfoDTOList,customerTypeEnum, CommUtils.getDateTypeEnumByDateStr(startTime));
        flightPriceService.getFlightPriceIntoFlightInfo(returnFlightInfoDTOList,customerTypeEnum, CommUtils.getDateTypeEnumByDateStr(returnTime));

        FlightStrategyContext flightStrategyContext = new FlightStrategyContext();
        flightStrategyContext.setStrategy(new FlightPriceStrategy());
        result.add(flightStrategyContext.executeStrategy(departFlightInfoDTOList));
        result.add(flightStrategyContext.executeStrategy(returnFlightInfoDTOList));

        return result;
    }

}
