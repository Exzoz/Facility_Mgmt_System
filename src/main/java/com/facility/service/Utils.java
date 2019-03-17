package com.facility.service;

import java.text.DecimalFormat;

public class Utils {

    public static String calculatePercentage(double obtained, double total) {
        DecimalFormat df = new DecimalFormat("#.00"); // format to two decimals
        return df.format(obtained * 100 / total);
    }
}

