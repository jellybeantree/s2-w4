import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;


/**
 * Analyzer for U.S. state renewable electricity data using ArrayList + Scanner + File I/O.
 * CSV expected: Location,TotalGenTWh,PercentRenewable,RenewableGenTWh,PercentOfUSRenewable,CO2MtPerTWh
 */
public class StateRenewableAnalyzer {
    private ArrayList<StateRenewable> states;

    /**
     * Constructor initializes an empty ArrayList.
     */
    public StateRenewableAnalyzer() {
        states = new ArrayList<StateRenewable>();
        
        
        
    }

    /**
     * Reads state data from a CSV file and populates the ArrayList.
     * Assumes the first line is a header.
     * @param filename path to the CSV file
     * @throws IOException if the file is not found
     */
    public void readFromFile(String filename) throws IOException {
        File f = new File(filename);
        Scanner s = new Scanner(f);
        s.nextLine();
        while(s.hasNextLine()){
            String line = s.nextLine();
            String[] items = line.split(",");
            StateRenewable aah = new StateRenewable(items[0], Double.parseDouble(items[1]), Double.parseDouble(items[2]),Double.parseDouble(items[3]),Double.parseDouble(items[4]),Double.parseDouble(items[5]));
            states.add(aah);
        }
        s.close();
    }

    /**
     * Display all states in the list.
     */
    public void displayAllStates() {
        for(StateRenewable states: states){
            System.out.println(states);
        }
    }

    /**
     * Display states at or above a renewable percent threshold.
     * @param threshold minimum percent renewable to include
     * @return ArrayList of StateRenewable objects meeting the threshold
     */
    public ArrayList<StateRenewable> displayAbovePercent(double threshold) {
        ArrayList<StateRenewable> statesAbove = new ArrayList<StateRenewable>();
        for(StateRenewable boom: states){
            if(boom.isAboveRenewableThreshold(threshold))
                statesAbove.add(boom);
        }
        return statesAbove;
    }

    /**
     * Find the state with the highest renewable percent.
     * @return StateRenewable with highest percent, or null if list is empty
     */
    public StateRenewable findHighestPercentRenewable() {
        if(states.size() == 0)
            return null;
        StateRenewable highest = states.get(0);
        for(int i = 1; i < states.size(); i ++){
            if(states.get(i).getPercentRenewable() > highest.getPercentRenewable())
                highest = states.get(i);
        }
        return highest;
    }

    /**
     * Find the state with the lowest renewable percent.
     * @return StateRenewable with lowest percent, or null if list is empty
     */
    public StateRenewable findLowestPercentRenewable() {
        if(states.size() == 0)
            return null;
        StateRenewable highest = states.get(0);
        for(int i = 1; i < states.size(); i ++){
            if(states.get(i).getPercentRenewable() < highest.getPercentRenewable())
                highest = states.get(i);
        }
        return highest;
    }

    /**
     * Calculate the average renewable percent across all states.
     * @return average percent, or 0 if list is empty
     */
    public double calculateAveragePercentRenewable() {
        double total = 0;
        for(StateRenewable bablam: states){
            total += bablam.getPercentRenewable();
        }
        return total/states.size();
    }

    /**
     * Calculate total renewable generation (TWh) across all states.
     * @return sum of renewableGenTWh values
     */
    public double totalRenewableGenTWh() {
        double total = 0;
        for(StateRenewable boomShakaLaka : states){
            total += boomShakaLaka.getRenewableGenTWh();
        }
        return total;
    }

    /**
     * Find the state with the highest renewable generation (TWh).
     * @return StateRenewable with highest renewableGenTWh, or null if list is empty
     */
    public StateRenewable findHighestRenewableGen() {
        if(states.size() == 0)
            return null;
        StateRenewable highest = states.get(0);
        for(int i = 1; i < states.size(); i++){
            if(states.get(i).getRenewableGenTWh() > highest.getRenewableGenTWh())
                highest = states.get(i);
        }
        return highest;
    }

    /**
     * Display summary statistics.
     */
    public void displayStatistics() {
        System.out.println(findHighestPercentRenewable());
        System.out.println(findLowestPercentRenewable());
        System.out.println(calculateAveragePercentRenewable());
}
    /**
     * Helper method to get total number of states (for testing).
     * @return size of the ArrayList
     */
    public int getTotalStates() {
        return states.size();
    }
}