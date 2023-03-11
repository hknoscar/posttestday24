package com.juaracoding.cucumber.drivers.strategies;

import com.juaracoding.cucumber.utils.Constant;

public class DriverStrategyImplementer {
    public static DriverStrategy chooseStrategy(String strategy){
        return switch (strategy) {
            case Constant.CHROME -> new Chrome();
            case Constant.FIREFOX -> new Firefox();
            default -> null;
        };
    }
}
