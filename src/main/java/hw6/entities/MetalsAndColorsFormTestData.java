package hw6.entities;


import java.util.ArrayList;

public class MetalsAndColorsFormTestData {

    // names should match keys names from json file
    public ArrayList<Integer> summary;
    public ArrayList<String> elements;
    public String color;
    public String metals;
    public ArrayList<String> vegetables;

    public MetalsAndColorsFormTestData(ArrayList<Integer> summary, ArrayList<String> elementsList,
                                       String color, String metals, ArrayList<String> vegetablesList) {
        this.summary = summary;
        this.elements = elementsList;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetablesList;
    }

    public String getSummaryAsString() {
        Integer sumOfSummaryArray = summary.get(0) + summary.get(1);
        return sumOfSummaryArray.toString();
    }

    @Override
    public String toString() {
        return "* Print: MetalsAndColorsFormTestData {" +
                " summary=" + summary +
                ", elementsList=" + elements +
                ", color='" + color + '\'' +
                ", metals='" + metals + '\'' +
                ", vegetablesList=" + vegetables +
                '}';
    }

}
