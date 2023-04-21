import java.util.ArrayList;

public class LocationField {
private String [][] locationField;//String array of locations and unused points
private ArrayList <Location> locations;//ArrayList of given location objects to have coordinites put into locationField
private int rangeX;//maximum x value/columns in the locationField variable 
private int rangeY;//maximum y value/columns in the locationField variable

/**
 * Instantiates needed components for the locationField to be printed properly with the minimum sized locationField, and the locations
 * ArrayList instantiated with at least one value
 * 
 * @param loc the first location in the locations ArrayList
 */
public LocationField(Location loc) {
    locationField = new String[1][1];//instantiates a minimum locationField size if no other methods are ran to update it
    locations = new ArrayList<Location>();
    locations.add(loc);
}

/**
 * Sets the minimum and maximum range of a by inputting seperate x and y variables, these values will not change the maximum
 * range of the locationfield variable with this method
 * 
 * @param x new maximum x value/columns 
 * @param y new maximum y value/columns 
 */
public void setRange(int x, int y) {
    rangeX = x;
    rangeY = y;
}

/**
 * @param x separately set the max range on the x-axis
 */
public void setRangeX(int x) {
    rangeX = x;
}

/**
 * @param y separately set the max range on the y-axis
 */
public void setRangeY(int y) {
    rangeY = y;
}

/**
 * @param l Arraylist of location objects updating the locations variable
 */
public void setLocations(ArrayList<Location> l) {
    locations = l;
}

/**
 * Adds a new Location object to the existing locations ArrayList variable
 * 
 * @param loc A singluar Location object
 */
public void addLocation(Location loc) {
    locations.add(loc);
}

/**
 * Updates the maximum range variables of the locationField variable by finding the highest x and y values in the locations
 * ArrayList and updating the ranggeX and rangeY variables
 */
public void updateRange() {
    int[] temp = new int[2];// Local variable to hold temporary coordinites of each Location object in the locations ArrayList

    for(int i = 0; i < locations.size(); i++) { 
        temp = locations.get(i).getLocation();
        if(temp[0] > rangeY) {
            rangeY = temp[0];
        }

        if(temp[1] > rangeX) {
            rangeX = temp[1];
        }

    }
}

/**
 * Updates the locationField String array by adding the symbol of each Location object in the locations ArrayList to the correlating 
 * index in the locationField array. Also adds "." in the remaining indexes to denote the lack of locations at those coordinites
 */
public void updateField() {
    int[] temp = new int[2];// Local variable to hold temporary coordinites for each Location Object in the locations ArrayList
    locationField = new String[rangeY][rangeX];
    
    /**
     * Iterates through each Location object in the locations ArrayList, checking that their location values fall within the maximum 
     * values. If this is true it will add the symbol to the index of the locationField array. If false, nothing will change in the array.
     */

    for (int i = 0; i < locations.size(); i++) {
        temp = locations.get(i).getLocation();
        if((temp[0] <= rangeY) && (temp[1] <= rangeX)) {
            locationField[temp[0]-1][temp[1]-1] = locations.get(i).getSymbol();
        }
    }

    /**
     * Iterates through all remaining empty values in the locationField array, replacing it with "." to indicate the lack of a location object in that
     * part of the grid
     */
    for (int u = 0; u < locationField.length; u++) {
        for (int j = 0; j < locationField[u].length; j++) {
            if(locationField[u][j] == null) {
                locationField[u][j]=".";
            }
        }
    }
}

/**
 * @return returns the locationField array, not formatted as a regular string
 */
public String[][] getLocationField() {
    return locationField;
}

/**
 * @return returns the locations ArrayList with each Location object inside
 */
public ArrayList<Location> getLocations() {
    return locations;
}

/**
 * @return returns the maximum x-axis range separately
 */
public int getRangeX() {
    return rangeX;
}

/**
 * @return returns the maximum y-axis range separately
 */
public int getRangeY() {
    return rangeY;
}

/**
 * @return An array with both the max y-axis and x-axis range formatted [y,x]
 */
public int[] getRange() {
    return new int[] {rangeY, rangeX};
}

/**
 * converts the locationField array into a single string to be printed, seeing the grid of locations printed properly. It also prints the y axis in opposite
 * order since in normal order the y-axis index 0 will start at the top of the print and the final index will be printed on the bottom. This is corrected
 * so the y-axis takes a normal form with the lowest values on the bottom and the highest on the top.
 */
public String toString() {
    String full = "";
    for (int i = locationField.length-1; i > -1; i--) {
        for (int j = 0; j < locationField[0].length; j++ ) {
            if (j == rangeX-1) {
                full += locationField[i][j] + "\n";
            } else {
                full += locationField[i][j];
            }
        }
    }
    return full;
}

}
