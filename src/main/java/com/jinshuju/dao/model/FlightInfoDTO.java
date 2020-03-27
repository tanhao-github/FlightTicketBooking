package com.jinshuju.dao.model;

/**
 * 航班信息DTO
 *
 * @author tanchaowen
 */
public class FlightInfoDTO {

    /**
     * 航班号
     */
    private String flightNumber;

    /**
     * 预计起飞时间
     */
    private String scheduledTime;

    /**
     * 起飞城市
     */
    private String from;

    /**
     * 到达城市
     */
    private String to;

    public FlightInfoDTO(){}

    public FlightInfoDTO(String flightNumber, String scheduledTime, String from, String to) {
        this.flightNumber = flightNumber;
        this.scheduledTime = scheduledTime;
        this.from = from;
        this.to = to;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(String scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "FlightInfoDTO{" +
                "flightNumber='" + flightNumber + '\'' +
                ", scheduledTime='" + scheduledTime + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }

}
