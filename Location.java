public class Location {

    private String name; //name of a location
    private String symbol; //one character symbol of a location
    private String type; //type of location i.e. town, store, home, country, etc
    private int location[]; //coordinites for the locaion

    /**
     * Instantiates a Location object with its name, symbol, type, and both x and y coordinites
     * 
     * @param n location name
     * @param s locaition symbol
     * @param t location type
     * @param x location x coordinite (greater than 0)
     * @param y location y coordinite (greater than 0)
     
     */
    public Location(String n, String s, String t, int x, int y) {
        name = n;
        symbol = s;
        type = t;
        location = new int[] {y,x}; //done with two values for added simplicity for users
    }


    /**
     * @param name new name of location
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param symbol new symbol of location
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * @param type new type of location
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @param x new x coordinite for location
     * @param y new y coordinite for location
     */
    public void setLocation(int x, int y) {
        location[0] = y;
        location[1] = x;
    }


    /**
     * @return name of given Location object
     */
    public String getName() {
        return name;
    }

    /**
     * @return symbol of given Location object
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @return type of given Location object
     */
    public String getType() {
        return type;
    }

    /**
     * @return coordinites of given Location object
     */
    public int[] getLocation() {
        return location;
    }

    public String toString() {
        return ("The " + type + " Called " + name + ", it is located at (" + location[1] + ", " + location[0] + ") on the grid. It is indicated with the symbol: " + symbol);
    }
}