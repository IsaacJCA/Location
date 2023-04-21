/*
 * Title: Project 1
 * 
 * Author: Isaac Johnson
 * Date: 4/21/23
 * Course: APCSA, Period 4
 * 
 * Description: classes to prepare and print out a grid of different locations, representing them as text on a 2-dimensional plane, accurately 
 * placing them based on xy coordinites.
 */

public class Runner {
    public static void main(String args[]) {
        LocationField test = new LocationField(new Location("Poway", "P", "City", 6, 5));//instantiates a location field object with its first location
        
        //several locations added to showcase on the map
        test.addLocation(new Location("Ramona", "R", "Unincorporated Community", 11, 6));
        test.addLocation(new Location("San Diego", "S", "City", 2, 2));
        test.addLocation(new Location("Escondido", "E", "City", 5, 8));

        //prepares the locationField array for printing
        test.updateRange();
        test.updateField();

        System.out.println(test.toString());

        //sets teh range to a different value to show how it can be overriden to exclude locations oustide of the range
        test.setRange(15, 6);
        test.updateField();

        System.out.println(test.toString());

    }
    
}