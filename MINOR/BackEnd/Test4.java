package java.minor1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import org.apache.commons.math3.stat.regression.SimpleRegression;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Test4 {
    public static void main(String[] args) {
        String csvFile = "test.csv";
        BufferedReader reader = null;
        CSVParser csvParser = null;
        List<Double> gpaList = new ArrayList<>();
        List<Double> satList = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(csvFile));
            csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

            for (CSVRecord record : csvParser) {
                double gpa = Double.parseDouble(record.get(0));
                double sat = Double.parseDouble(record.get(1));
                gpaList.add(gpa);
                satList.add(sat);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (csvParser != null) {
                    csvParser.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        double[] gpaArray = gpaList.stream().mapToDouble(Double::doubleValue).toArray();
        double[] satArray = satList.stream().mapToDouble(Double::doubleValue).toArray();

        SimpleRegression regression = new SimpleRegression();
        regression.addData(gpaArray, satArray);

        double m = regression.getSlope();
        double b = regression.getIntercept();

        System.out.println("m: " + m);
        System.out.println("b: " + b);

        XYSeries series = new XYSeries("Regression Line");
        for (double x = 2; x <= 7; x++) {
            double y = m * x + b;
            series.add(x, y);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createScatterPlot("GPA vs SAT", "GPA", "SAT", createDataset(gpaArray, satArray), PlotOrientation.VERTICAL, true, true, false);
        chart.getXYPlot().setDataset(1, dataset);
        chart.getXYPlot().getRenderer(1).setSeriesPaint(0, java.awt.Color.RED);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 500));

        ChartFrame frame = new ChartFrame("Regression Analysis", chart);
        frame.pack();
        frame.setVisible(true);
    }

    private static XYDataset createDataset(double[] gpaArray, double[] satArray) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("Data Points");

        for (int i = 0; i < gpaArray.length; i++) {
            series.add(gpaArray[i], satArray[i]);
        }

        dataset.addSeries(series);
        return dataset;
    }
}