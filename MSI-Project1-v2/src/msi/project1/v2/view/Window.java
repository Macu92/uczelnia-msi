/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msi.project1.v2.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Maciek
 */
public class Window extends JFrame {

    static final int witdh = 800;
    static final int height = 600;

    String[] names = {"k", "Rozkład wykładniczy", "Rozkład deterministyczny","sigma=0.75*tau2","sigma=0.35*tau2"};
    final JTable table = new JTable(getW(), names);
    JButton propButton = new JButton("Pokaz diagram prawdopodobienstwa");
    JButton distButton = new JButton("Pokaz diagram dystrybuanty");

    JFreeChart jfc;

    JPanel listPane = new JPanel();

    public Window() throws HeadlessException {
        setSize(witdh, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        propButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultCategoryDataset dcd = new DefaultCategoryDataset();
                for (String[] s : getW()) {
                    dcd.addValue((double) Double.valueOf(s[1]), "Rozkład wykładniczy", s[0]);
                    dcd.addValue((double) Double.valueOf(s[2]), "Rozkład deterministyczny", s[0]);
                    dcd.addValue((double) Double.valueOf(s[3]), "sigma=0.75*tau2", s[0]);
                    dcd.addValue((double) Double.valueOf(s[4]), "sigma=0.35*tau2", s[0]);
                }
                jfc = ChartFactory.createLineChart("Średni czas oczekiwania w kolejce ", "Lambda", "t", dcd, PlotOrientation.VERTICAL, true, true, false);
                CategoryPlot plot = jfc.getCategoryPlot();
                plot.setRangeGridlinePaint(Color.black);
                ChartFrame cf = new ChartFrame("Prawdopodobienstwo", jfc, true);
                cf.setSize(800, 500);
                cf.setVisible(true);
            }
        });

        listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
        listPane.add(new JScrollPane(table), BorderLayout.CENTER);
        listPane.add(propButton);
        getContentPane().add(listPane);
    }

    private String[][] getN() {
        String[][] table = {
            {"0","0.14285714285714300","0.1339285714285710","0.138950892857143000","0.1350223214285710"},
            {"1","0.33333333333333300","0.2916666666666670","0.315104166666667000","0.2967708333333330"},
            {"2","0.60000000000000000","0.4875000000000000","0.550781250000000000","0.5012812500000000"},
            {"3","1.00000000000000000","0.7500000000000000","0.890625000000000000","0.7806250000000000"},
            {"4","1.66666666666667000","1.1458333333333300","1.438802083333330000","1.2096354166666700"},
            {"5","3.00000000000000000","1.8750000000000000","2.507812500000000000","2.0128125000000000"},
            {"6","7.00000000000000000","3.9375000000000000","5.660156250000000000","4.3126562500000000"}
//            {"7", "0.0034", "0.0901"},
//            {"8", "0.0009", "0.1126"},
//            {"9", "0.0002", "0.1251"},
//            {"10", "0.0000", "0.1251"},
//            {"11", "0.0000", "0.1137"},
//            {"12", "0.0000", "0.0948"},
//            {"13", "0.0000", "0.0729"},
//            {"14", "0.0000", "0.0521"},
//            {"15", "0.0000", "0.0347"}
        };
        return table;
    }

    private String[][] getV() {
        String[][] table = {
            {"0","0.017857142857143","0.00892857142857142","0.013950892857142800","0.01002232142857140"},
            {"1","0.083333333333333","0.04166666666666670","0.065104166666666700","0.04677083333333330"},
            {"2","0.225000000000000","0.11250000000000000","0.175781250000000000","0.12628125000000000"},
            {"3","0.500000000000000","0.25000000000000000","0.390625000000000000","0.28062500000000000"},
            {"4","1.041666666666670","0.52083333333333300","0.813802083333333000","0.58463541666666700"},
            {"5","2.250000000000000","1.12500000000000000","1.757812500000000000","1.26281250000000000"},
            {"6","6.125000000000000","3.06250000000000000","4.785156250000000000","3.43765625000000000"}
        };

        return table;
    }
    
        private String[][] getW() {
        String[][] table = {
            {"0","0.017857142857143","0.008928571428571420","0.013950892857142800","0.01002232142857140"},
            {"1","0.041666666666667","0.020833333333333300","0.032552083333333300","0.02338541666666670"},
            {"2","0.075000000000000","0.037500000000000000","0.058593750000000000","0.04209375000000000"},
            {"3","0.125000000000000","0.062500000000000000","0.097656250000000000","0.07015625000000000"},
            {"4","0.208333333333333","0.104166666666667000","0.162760416666667000","0.11692708333333300"},
            {"5","0.375000000000000","0.187500000000000000","0.292968750000000000","0.21046875000000000"},
            {"6","0.875000000000000","0.437500000000000000","0.683593750000000000","0.49109375000000000"}
        };

        return table;
    }
}
