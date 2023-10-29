package backend;

import java.io.*;
import java.util.*;

// Define a class to represent CSV data
class CSVData {
    String[] values;

    public CSVData(String[] values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return String.join(",", values);
    }
}

public class CSVMergeSort {
    public static void main(String[] args) {
        String inputFile = "./DATASET/cleandata.csv"; // Replace with your CSV file path
        String outputFile = "sorted_output.csv"; // Replace with desired output file path

        try {
            // Read CSV data into a list of CSVData objects
            List<CSVData> data = readCSV(inputFile);

            // Sort the data using merge sort
            mergeSort(data);

            // Write the sorted data to a new CSV file
            writeCSV(data, outputFile);

            System.out.println("CSV data sorted and saved to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read CSV data into a list of CSVData objects
    public static List<CSVData> readCSV(String fileName) throws IOException {
        List<CSVData> data = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            CSVData csvData = new CSVData(values);
            data.add(csvData);
        }

        br.close();
        return data;
    }

    // Merge sort implementation for a list of CSVData objects
    public static void mergeSort(List<CSVData> data) {
        if (data.size() <= 1) {
            return;
        }

        int mid = data.size() / 2;
        List<CSVData> left = data.subList(0, mid);
        List<CSVData> right = data.subList(mid, data.size());

        mergeSort(left);
        mergeSort(right);

        merge(data, left, right);
    }

    private static void merge(List<CSVData> data, List<CSVData> left, List<CSVData> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).toString().compareTo(right.get(j).toString()) <= 0) {
                data.set(k++, left.get(i++));
            } else {
                data.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            data.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            data.set(k++, right.get(j++));
        }
    }

    // Write sorted data to a CSV file
    public static void writeCSV(List<CSVData> data, String fileName) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (CSVData csvData : data) {
            bw.write(csvData.toString());
            bw.newLine();
        }
        bw.close();
    }
}

