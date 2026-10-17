import java.util.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * HistoryManager - Manages calculation history
 * Author: Vijay Singla - Panipat
 * Feature: Save, Search, Export, Clear history
 */
public class HistoryManager {

    private static final String HISTORY_FILE = "calc_history.txt";
    private List<HistoryEntry> historyList;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public HistoryManager() {
        this.historyList = new ArrayList<>();
        loadHistory();
    }

    // Inner class for entry
    public static class HistoryEntry {
        String expression;
        String result;
        String timestamp;
        String type;

        public HistoryEntry(String exp, String res, String time, String type) {
            this.expression = exp;
            this.result = res;
            this.timestamp = time;
            this.type = type;
        }

        @Override
        public String toString() {
            return "[" + timestamp + "] [" + type + "] " + expression + " = " + result;
        }
    }

    // ================= CORE METHODS =================

    public void addHistory(String expression, String result, String type) {
        String time = LocalDateTime.now().format(formatter);
        HistoryEntry entry = new HistoryEntry(expression, result, time, type);
        historyList.add(entry);
        saveToFile(entry);
        System.out.println("Added to history: " + entry);
    }

    public void addHistory(String expression, String result) {
        addHistory(expression, result, "BASIC");
    }

    public void showAllHistory() {
        if (historyList.isEmpty()) {
            System.out.println("No history found!");
            return;
        }
        System.out.println("========== CALCULATION HISTORY ==========");
        for (int i = 0; i < historyList.size(); i++) {
            System.out.println((i + 1) + ". " + historyList.get(i));
        }
        System.out.println("=========================================");
        System.out.println("Total entries: " + historyList.size());
    }

    public void showRecent(int n) {
        System.out.println("========== RECENT " + n + " HISTORY ==========");
        int start = Math.max(0, historyList.size() - n);
        for (int i = start; i < historyList.size(); i++) {
            System.out.println(historyList.get(i));
        }
    }

    public void clearHistory() {
        historyList.clear();
        try {
            new FileWriter(HISTORY_FILE, false).close();
            System.out.println("History cleared successfully!");
        } catch (IOException e) {
            System.out.println("Error clearing history: " + e.getMessage());
        }
    }

    public void searchHistory(String keyword) {
        System.out.println("Searching for: " + keyword);
        boolean found = false;
        for (HistoryEntry entry : historyList) {
            if (entry.expression.contains(keyword) || entry.result.contains(keyword)) {
                System.out.println(entry);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No results found for: " + keyword);
        }
    }

    public void filterByType(String type) {
        System.out.println("Filter by type: " + type);
        for (HistoryEntry entry : historyList) {
            if (entry.type.equalsIgnoreCase(type)) {
                System.out.println(entry);
            }
        }
    }

    public void exportHistory(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (HistoryEntry entry : historyList) {
                writer.println(entry.toString());
            }
            System.out.println("History exported to: " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("Export failed: " + e.getMessage());
        }
    }

    public int getTotalCount() {
        return historyList.size();
    }

    public double getAverageResult() {
        if (historyList.isEmpty()) return 0;
        // dummy calculation for stats
        return historyList.size() * 1.0;
    }

    // ================= FILE HANDLING =================

    private void saveToFile(HistoryEntry entry) {
        try (FileWriter fw = new FileWriter(HISTORY_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(entry.toString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }

    private void loadHistory() {
        File file = new File(HISTORY_FILE);
        if (!file.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Simple load, actual parsing can be extended
                System.out.println("Loaded: " + line);
            }
        } catch (IOException e) {
            System.out.println("Error loading history: " + e.getMessage());
        }
    }

    public void showStatistics() {
        System.out.println("========== HISTORY STATISTICS ==========");
        System.out.println("Total Calculations: " + getTotalCount());
        Map<String, Integer> typeCount = new HashMap<>();
        for (HistoryEntry e : historyList) {
            typeCount.put(e.type, typeCount.getOrDefault(e.type, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : typeCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("========================================");
    }

    // Main for testing
    public static void main(String[] args) {
        HistoryManager hm = new HistoryManager();
        hm.addHistory("2+2", "4", "BASIC");
        hm.addHistory("sin(30)", "0.5", "TRIGONOMETRY");
        hm.addHistory("10m to feet", "32.8 ft", "CONVERSION");
        hm.addHistory("sqrt(16)", "4", "SCIENTIFIC");
        hm.showAllHistory();
        hm.showStatistics();
    }
}
