/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msi.project1;

import com.msi.project1.model.InitDataModel;
import com.msi.project1.service.PoissonStramCalc;
import com.msi.project1.view.Window;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Maciek
 */
public class MsiP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PoissonStramCalc calc = new PoissonStramCalc();
        InitDataModel dataModel =  new InitDataModel();
        ArrayList<ArrayList<BigDecimal>> propability = calc.calculatePropability(dataModel.getLambda(), dataModel.getSec(), 1);
        for(ArrayList<BigDecimal> list :propability){
            for(BigDecimal d :list){
                System.out.println(d);
            }
            System.out.println("-----------------------");
        }
        
        Window w = new Window();
        w.pack();
        w.setVisible(true);
    }
    
}
