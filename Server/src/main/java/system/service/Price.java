package system.service;

import system.entity.Way;
import system.entity.WayInfo;

public class Price {
    private double price(double k, float l){
        return k*l;
    }
    public double fullPrice(WayInfo wayInfo){
        double fullPrice = 0;
        for(Way way : wayInfo.getWays()){
            fullPrice += price(way.getLine().getTransport().getKoeff(), way.getLine().getDistance());
        }
        return fullPrice;
    }

    private double time(double l, float v){
        return l/v;
    }
    public double fullTime(WayInfo wayInfo){
        double fullTime = 0;
        for(Way way : wayInfo.getWays()){
            fullTime += price(way.getLine().getDistance(), way.getLine().getTransport().getSpeed());
        }
        return fullTime;
    }
}
