package com.jinshuju.strategy;

import com.jinshuju.dao.model.FlightInfoDTO;

import java.math.BigDecimal;
import java.util.*;

/**
 * 航班价格筛选策略
 *
 * @author tanchaowen
 */
public class FlightPriceStrategy implements FlightStrategy {

    @Override
    public FlightInfoDTO getFlight(List<FlightInfoDTO> flightInfoDTOList) {
        if(null != flightInfoDTOList && !flightInfoDTOList.isEmpty()){

            TreeMap<BigDecimal,List<FlightInfoDTO>> flightInfoDTOMap = new TreeMap<>(new Comparator<BigDecimal>() {
                @Override
                public int compare(BigDecimal o1, BigDecimal o2) {
                    return o1.compareTo(o2);
                }
            });

            for (FlightInfoDTO flightInfoDTO : flightInfoDTOList){
                List<FlightInfoDTO> temp = flightInfoDTOMap.get(flightInfoDTO.getFlightPrice());
                if(null == temp){
                    temp = new ArrayList<>();
                    temp.add(flightInfoDTO);
                    flightInfoDTOMap.put(flightInfoDTO.getFlightPrice(),temp);
                }else {
                    temp.add(flightInfoDTO);
                }
            }

            List<FlightInfoDTO> lowestFlight = flightInfoDTOMap.firstEntry().getValue();

            //TODO 下面部分可以再抽出一个策略实现的，但是时间关系没有做了
            if(lowestFlight.size() > 1){
                //TODO 说明有价格相同的航班，再次根据航班出发时间进行筛选（暂时根据出发时间最早的获取）
                Collections.sort(lowestFlight, new Comparator<FlightInfoDTO>() {
                    @Override
                    public int compare(FlightInfoDTO o1, FlightInfoDTO o2) {
                        Long t1 = Long.valueOf(o1.getScheduledTime().replace(":",""));
                        Long t2 = Long.valueOf(o2.getScheduledTime().replace(":",""));
                        return t1.compareTo(t2);
                    }
                });
            }

            //获取出发时间最早的航班返还
            return lowestFlight.get(0);

        }
        return null;
    }

}
