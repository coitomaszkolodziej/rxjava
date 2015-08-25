/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gov.coi;

import java.util.List;

/**
 * @author Praktyki
 */
public class Random {

    public static String getStringValue(final List<String> list) {
        return list.get(new java.util.Random().nextInt(list.size()));
    }

    public static int getIntAgeValue() {
        return new java.util.Random().nextInt((80 - 20) + 1) + 20;
    }

    public static int getIntValue(final int max) {
        return new java.util.Random().nextInt(max);
    }

}
