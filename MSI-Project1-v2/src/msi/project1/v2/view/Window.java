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

    String[] names = {"lambda", "Pi"};
    final JTable table = new JTable(getPropabilityTable(), names);
    String[] namesDist = {"t", "lambda=2", "labmda=10"};
    final JTable tableDist = new JTable(getComultativeDistributionTable(), namesDist);
    JButton propButton = new JButton("Pokaz diagram prawdopodobienstwa blokady");
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
                for (String[] s : getPropabilityTable()) {
                    dcd.addValue((double) Double.valueOf(s[1]),"", s[0]);
                }
                jfc = ChartFactory.createLineChart("Wykres prawdopodobieństwa blokady", "lambda", "Pi", dcd, PlotOrientation.VERTICAL, true, true, false);
                CategoryPlot plot = jfc.getCategoryPlot();
                plot.setRangeGridlinePaint(Color.black);
                ChartFrame cf = new ChartFrame("Prawdopodobienstwo", jfc, true);
                cf.setSize(800, 500);
                cf.setVisible(true);
            }
        });
//
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
        listPane.add(new JScrollPane(table), BorderLayout.CENTER);
        listPane.add(propButton);

//        distButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                DefaultCategoryDataset dcd = new DefaultCategoryDataset();
//                for (String[] s : getComultativeDistributionTable()) {
//                    dcd.addValue((double) Double.valueOf(s[1]), "Lambda = 2", s[0]);
//                    dcd.addValue((double) Double.valueOf(s[2]), "Lambda = 10", s[0]);
//                }
//                jfc = ChartFactory.createBarChart3D("Wykres prawdopodobieństwa", "K", "F(t)", dcd, PlotOrientation.VERTICAL, true, true, false);
//                CategoryPlot plot = jfc.getCategoryPlot();
//                plot.setRangeGridlinePaint(Color.black);
//                ChartFrame cf = new ChartFrame("Dystrybuanta", jfc, true);
//                cf.setSize(800, 500);
//                cf.setVisible(true);
//            }
//        });
//        listPane.add(new JScrollPane(tableDist), BorderLayout.CENTER);
//        listPane.add(distButton);
        getContentPane().add(listPane);
    }

    private String[][] getPropabilityTable() {
        String[][] table = {
            {"0", "0.00000000000000000004048451"},
            {"1", "0.00000000000007332459421341"},
            {"2", "0.00000000030798707422831600"},
            {"3", "0.00000010521299191562000000"},
            {"4", "0.00000877489575282414000000"},
            {"5", "0.00028278485321736000000000"},
            {"6", "0.00420205484560207000000000"},
            {"7", "0.02863895640071260000000000"},
            {"8", "0.09077043366632230000000000"},
            {"9", "0.16974134888352100000000000"},
            {"10", "0.24296489346011500000000000"},
            {"11", "0.30565584561296400000000000"}//,
//            {"12", "0.041353864"},
//            {"13", "0.039699709"},
//            {"14", "0.038111721"},
//            {"15", "0.036587252"},
//            {"16", "0.035123762"},
//            {"17", "0.033718811"},
//            {"18", "0.032370059"},
//            {"19", "0.031075257"},
//            {"20", "0.029832246"},
//            {"21", "0.028638956"}
        };
        return table;
    }

    private String[][] getComultativeDistributionTable() {
        String[][] table = {
            {"0.1", "0.1813", "0.8647"},
            {"0.2", "0.3297", "0.9502"},
            {"0.3", "0.4512", "0.9817"},
            {"0.4", "0.5507", "0.9933"},
            {"0.5", "0.6321", "0.9975"},
            {"0.6", "0.6988", "0.9991"},
            {"0.7", "0.7534", "0.9991"},
            {"0.8", "0.7981", "0.9997"},
            {"0.9", "0.8347", "0.9999"},
            {"1.0", "0.8647", "1.0000"},
            {"1.1", "0.8892", "1.0000"},
            {"1.2", "0.9093", "1.0000"},
            {"1.3", "0.9257", "1.0000"}
        };

        return table;
    }
}
