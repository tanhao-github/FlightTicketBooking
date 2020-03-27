package com.jinshuju.dao.model;

import com.jinshuju.enums.CustomerTypeEnum;
import com.jinshuju.enums.DateTypeEnum;

import java.math.BigDecimal;

/**
 * 航班价格信息DTO
 *
 * @author tanchaowen
 */
public class FlightPriceDTO {

    /**
     * 航班号
     */
    private String flightNumber;

    /**
     * 客户类型
     */
    private CustomerTypeEnum customerTypeEnum;

    /**
     * 时间类型
     */
    private DateTypeEnum dateTypeEnum;

    /**
     * 航班价格
     */
    private BigDecimal price;

    public FlightPriceDTO() {
    }

    public FlightPriceDTO(String flightNumber, CustomerTypeEnum customerTypeEnum, DateTypeEnum dateTypeEnum, BigDecimal price) {
        this.flightNumber = flightNumber;
        this.customerTypeEnum = customerTypeEnum;
        this.dateTypeEnum = dateTypeEnum;
        this.price = price;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public CustomerTypeEnum getCustomerTypeEnum() {
        return customerTypeEnum;
    }

    public void setCustomerTypeEnum(CustomerTypeEnum customerTypeEnum) {
        this.customerTypeEnum = customerTypeEnum;
    }

    public DateTypeEnum getDateTypeEnum() {
        return dateTypeEnum;
    }

    public void setDateTypeEnum(DateTypeEnum dateTypeEnum) {
        this.dateTypeEnum = dateTypeEnum;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "FlightPriceDTO{" +
                "flightNumber='" + flightNumber + '\'' +
                ", customerTypeEnum=" + customerTypeEnum +
                ", dateTypeEnum=" + dateTypeEnum +
                ", price=" + price +
                '}';
    }
}
