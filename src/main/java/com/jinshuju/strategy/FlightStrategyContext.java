package com.jinshuju.strategy;

import com.jinshuju.dao.model.FlightInfoDTO;
import com.sun.tools.javac.util.Assert;

import java.util.List;

/**
 * 策略上下文
 *
 * @author tanchaowen
 */
public class FlightStrategyContext {

    /**
     * 持有策略
     */
    private FlightStrategy flightStrategy;

    /**
     * 指定策略
     *
     * @param flightStrategy
     */
    public void setStrategy(FlightStrategy flightStrategy) {
        this.flightStrategy = flightStrategy;
    }

    public FlightInfoDTO executeStrategy(List<FlightInfoDTO> flightInfoDTOList) {
        Assert.checkNonNull(flightStrategy,"请指定需要使用的策略");
        return flightStrategy.getFlight(flightInfoDTOList);
    }
}