/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author HOME
 */
public class WicketTeam1 extends javax.swing.JFrame {

    public static final int fow[]= new int[10];
    public static String team1;
    
    
    public WicketTeam1(final String title) {

        super(title);

        for(int i=0;i<10;i++)
        {
        this.fow[i]=ScoreTeam1.wickets1[i];
        }
        
            
        this.team1=MainForm.Team1;
        
        final CategoryDataset dataset = createDataset(title);
        final JFreeChart chart = createChart(dataset,title);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(1500,1500));
        setContentPane(chartPanel);
        
        addWindowListener(new WindowAdapter() {
        public void windowOpened(WindowEvent e) {
        setExtendedState(MAXIMIZED_BOTH);
        }
        });

    }
    
    private CategoryDataset createDataset(String name) {
        
        // row keys...
        
        final String team1 = name;
        
        // column keys...
        final String over1 = "Over 1";
        final String over2 = "Over 2";
        final String over3 = "Over 3";
        final String over4 = "Over 4";
        final String over5 = "Over 5";
        final String over6 = "Over 6";
        final String over7 = "Over 7";
        final String over8 = "Over 8";
        final String over9 = "Over 9";
        final String over10 = "Over 10";
        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
   

        dataset.addValue(fow[0], team1, over1);
        dataset.addValue(fow[1], team1, over2);
        dataset.addValue(fow[2], team1, over3);
        dataset.addValue(fow[3], team1, over4);
        dataset.addValue(fow[4], team1, over5);
        dataset.addValue(fow[5], team1, over6);
        dataset.addValue(fow[6], team1, over7);
        dataset.addValue(fow[7], team1, over8);
        dataset.addValue(fow[8], team1, over9);
        dataset.addValue(fow[9], team1, over10);

        
        return dataset;
        
    }
    
    
    public static void main(final String[] args) {

         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
        final WicketTeam1 demo = new WicketTeam1("WICKETS");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);     
            }
        });
        
    }
    private JFreeChart createChart(final CategoryDataset dataset,String name) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart(
           team1,         // chart title
            "OVERS",               // domain axis label
            "WICKETS",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips?
            false                     // URLs?
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

        // set the background color for the chart...
        chart.setBackgroundPaint(Color.white);

        // get a reference to the plot for further customisation...
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // disable bar outlines...
        final BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        
        // set up gradient paints for series...
        
        final GradientPaint gp0 = new GradientPaint(
            0.0f, 0.0f, Color.red, 
            0.0f, 0.0f, Color.lightGray
        );
       
        renderer.setSeriesPaint(0, gp0);
        //renderer.setSeriesPaint(1, gp1);

        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        // OPTIONAL CUSTOMISATION COMPLETED.
        
        return chart;
        
    }
    
    
}
