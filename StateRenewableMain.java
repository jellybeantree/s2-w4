import java.io.IOException;

public class StateRenewableMain {
    public static void main(String[] args) {
        StateRenewableAnalyzer analyzer = new StateRenewableAnalyzer();
         try {
            // Read the data file
            analyzer.readFromFile("renewable-energy-data.csv");
            analyzer.displayStatistics();
        } catch (IOException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}
