package cma;

import cma.ScoreTeam1;
import java.awt.Color;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.GradientPaint;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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


public class ScoreComparison extends ApplicationFrame {

   
    int score1[][]=new int[10][10];
    
    int score2[][]=new int[10][10];
    
    String name1,name2;
  
    public ScoreComparison(final String title) {

        super(title);
        this.name1 = MainForm.Team1;
        this.name2 = MainForm.Team2;
        
        this.score1=ScoreTeam1.score1;
        this.score2=ScoreTeam2.score1;
        

        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(750,500));
        setContentPane(chartPanel);

        addWindowListener(new WindowAdapter() {
        public void windowOpened(WindowEvent e) {
        setExtendedState(MAXIMIZED_BOTH);
        }
        });
    }

    
    private CategoryDataset createDataset() {
        
        // row keys...
        final String team1 = name1;
        final String team2 = name2;
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

        dataset.addValue(score1[0][6], team1, over1);
        dataset.addValue(score1[1][6], team1, over2);
        dataset.addValue(score1[2][6], team1, over3);
        dataset.addValue(score1[3][6], team1, over4);
        dataset.addValue(score1[4][6], team1, over5);
        dataset.addValue(score1[5][6], team1, over6);
        dataset.addValue(score1[6][6], team1, over7);
        dataset.addValue(score1[7][6], team1, over8);
        dataset.addValue(score1[8][6], team1, over9);
        dataset.addValue(score1[9][6], team1, over10);

        dataset.addValue(score2[0][6], team2, over1);
        dataset.addValue(score2[1][6], team2, over2);
        dataset.addValue(score2[2][6], team2, over3);
        dataset.addValue(score2[3][6], team2, over4);
        dataset.addValue(score2[4][6], team2, over5);
        dataset.addValue(score2[5][6], team2, over6);
        dataset.addValue(score2[6][6], team2, over7);
        dataset.addValue(score2[7][6], team2, over8);
        dataset.addValue(score2[8][6], team2, over9);
        dataset.addValue(score2[9][6], team2, over10);

        
        return dataset;
        
    }
    
    
    private JFreeChart createChart(final CategoryDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart(
            name1+" vs "+name2,         // chart title
            "OVERS",               // domain axis label
            "RUNS",                  // range axis label
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
            0.0f, 0.0f, Color.blue, 
            0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp1 = new GradientPaint(
            0.0f, 0.0f, Color.green, 
            0.0f, 0.0f, Color.lightGray
        );
        
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        
        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        // OPTIONAL CUSTOMISATION COMPLETED.
        
        return chart;
        
    }
    
    
    public static void main(final String[] args) {

        final ScoreComparison demo = new ScoreComparison("SCORECARD COMPARISON");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}
