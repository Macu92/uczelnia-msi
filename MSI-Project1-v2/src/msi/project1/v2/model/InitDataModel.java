package msi.project1.v2.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maciek
 */
public class InitDataModel {
    private static final Integer[] lambda = {2,10};
    private static final Integer[] sec = {0,1,2,3,4,5,6,7,8,9,10};
    private static final Double[] dystrybuanta = {0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9,1.0,1.1,1.2,1.3};

    public Integer[] getLambda() {
        return lambda;
    }

    public Integer[] getSec() {
        return sec;
    }

    public Double[] getDystrybuanta() {
        return dystrybuanta;
    }    
}
