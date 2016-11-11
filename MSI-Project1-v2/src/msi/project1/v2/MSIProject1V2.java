/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msi.project1.v2;


import java.math.BigDecimal;
import java.util.ArrayList;
import msi.project1.v2.model.InitDataModel;
import msi.project1.v2.service.PoissonStramCalc;
import msi.project1.v2.view.Window;

/**
 *
 * @author Maciek
 */
public class MSIProject1V2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PoissonStramCalc calc = new PoissonStramCalc();
        InitDataModel dataModel = new InitDataModel();
        ArrayList<ArrayList<BigDecimal>> propability = calc.calculatePropability(dataModel.getLambda(), dataModel.getSec(), 1);
        for (ArrayList<BigDecimal> list : propability) {
            for (BigDecimal d : list) {
                System.out.println(d);
            }
            System.out.println("-----------------------");
        }

        Window w = new Window();
        w.pack();
        w.setVisible(true);
    }

}
