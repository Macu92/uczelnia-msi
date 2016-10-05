/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msi.project1.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

/**
 *
 * @author Maciek
 */
public class PoissonStramCalc {
    
    public ArrayList calculatePropability(Integer[] lambdas,Integer[] secs,Integer time){
        ArrayList<ArrayList> propability = new ArrayList<>();
        for(Integer lambda:lambdas){
            ArrayList<BigDecimal> perLamda = new ArrayList<>();
            for(Integer sec:secs){
                perLamda.add(new BigDecimal(String.valueOf(calculatePropability(lambda,sec,time))).setScale(4, BigDecimal.ROUND_HALF_UP));
//                perLamda.add(calculatePropability(lambda,sec,time));
            }
            propability.add(perLamda);
        }
        return propability;
    }

    private BigDecimal calculatePropability(Integer lambda, Integer sec, Integer time) {
        BigDecimal bLamda =  new BigDecimal(lambda);
        BigDecimal bSec = new BigDecimal(sec);
        BigDecimal bTime =  new BigDecimal(time);
        BigDecimal temp = bLamda.multiply(bTime);
        temp = temp.divide(factorial(bSec),MathContext.DECIMAL128);
        temp = temp.multiply(new BigDecimal(Math.exp(Double.valueOf(lambda)*(-time))));
        return temp;
    }
    
    public BigDecimal factorial(BigDecimal n) {
    BigDecimal factorial = BigDecimal.valueOf(1);
    for (int i = 1; i <= n.intValue(); i++) {
        factorial = factorial.multiply(BigDecimal.valueOf(i));
    }
    return factorial;
} 
}
