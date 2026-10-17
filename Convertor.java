import java.util.HashMap;
import java.util.Map;

/**
 * Converter - Scientific Calculator Project
 * Author: Vijay Singla
 * Supports Length, Weight, Temperature, Area, Volume
 */
public class Converter {

    // ================= LENGTH CONVERSION =================
    public static class LengthConverter {
        public static double metersToKm(double m) { return m / 1000.0; }
        public static double kmToMeters(double km) { return km * 1000.0; }
        public static double metersToCm(double m) { return m * 100.0; }
        public static double cmToMeters(double cm) { return cm / 100.0; }
        public static double metersToMm(double m) { return m * 1000.0; }
        public static double mmToMeters(double mm) { return mm / 1000.0; }
        public static double metersToFeet(double m) { return m * 3.28084; }
        public static double feetToMeters(double ft) { return ft / 3.28084; }
        public static double metersToInches(double m) { return m * 39.3701; }
        public static double inchesToMeters(double inch) { return inch / 39.3701; }
        public static double kmToMiles(double km) { return km * 0.621371; }
        public static double milesToKm(double miles) { return miles / 0.621371; }
    }

    // ================= WEIGHT CONVERSION =================
    public static class WeightConverter {
        public static double kgToGrams(double kg) { return kg * 1000.0; }
        public static double gramsToKg(double g) { return g / 1000.0; }
        public static double kgToPounds(double kg) { return kg * 2.20462; }
        public static double poundsToKg(double lb) { return lb / 2.20462; }
        public static double kgToOunces(double kg) { return kg * 35.274; }
        public static double ouncesToKg(double oz) { return oz / 35.274; }
        public static double gramsToMilligrams(double g) { return g * 1000.0; }
        public static double milligramsToGrams(double mg) { return mg / 1000.0; }
        public static double tonsToKg(double ton) { return ton * 1000.0; }
        public static double kgToTons(double kg) { return kg / 1000.0; }
    }

    // ================= TEMPERATURE CONVERSION =================
    public static class TemperatureConverter {
        public static double celsiusToFahrenheit(double c) { return (c * 9/5) + 32; }
        public static double fahrenheitToCelsius(double f) { return (f - 32) * 5/9; }
        public static double celsiusToKelvin(double c) { return c + 273.15; }
        public static double kelvinToCelsius(double k) { return k - 273.15; }
        public static double fahrenheitToKelvin(double f) { return (f - 32) * 5/9 + 273.15; }
        public static double kelvinToFahrenheit(double k) { return (k - 273.15) * 9/5 + 32; }
    }

    // ================= AREA CONVERSION =================
    public static class AreaConverter {
        public static double sqMetersToSqKm(double sqm) { return sqm / 1_000_000.0; }
        public static double sqKmToSqMeters(double sqkm) { return sqkm * 1_000_000.0; }
        public static double sqMetersToSqFeet(double sqm) { return sqm * 10.7639; }
        public static double sqFeetToSqMeters(double sqft) { return sqft / 10.7639; }
        public static double sqMetersToAcres(double sqm) { return sqm * 0.000247105; }
        public static double acresToSqMeters(double acres) { return acres / 0.000247105; }
        public static double sqMetersToHectares(double sqm) { return sqm / 10000.0; }
        public static double hectaresToSqMeters(double h) { return h * 10000.0; }
    }

    // ================= VOLUME CONVERSION =================
    public static class VolumeConverter {
        public static double litersToMl(double l) { return l * 1000.0; }
        public static double mlToLiters(double ml) { return ml / 1000.0; }
        public static double litersToGallons(double l) { return l * 0.264172; }
        public static double gallonsToLiters(double g) { return g / 0.264172; }
        public static double litersToCubicMeters(double l) { return l / 1000.0; }
        public static double cubicMetersToLiters(double cbm) { return cbm * 1000.0; }
    }

    // ================= CURRENCY (STATIC RATES) =================
    public static class CurrencyConverter {
        private static Map<String, Double> rates = new HashMap<>();
        static {
            rates.put("USD", 83.0);
            rates.put("EUR", 89.0);
            rates.put("GBP", 102.0);
            rates.put("JPY", 0.55);
            rates.put("INR", 1.0);
        }
        public static double convert(double amount, String from, String to) {
            double inr = amount * rates.getOrDefault(from, 1.0);
            return inr / rates.getOrDefault(to, 1.0);
        }
    }

    // Test main
    public static void main(String[] args) {
        System.out.println("Converter Module Loaded");
        System.out.println("10m = " + LengthConverter.metersToFeet(10) + " feet");
        System.out.println("10kg = " + WeightConverter.kgToPounds(10) + " pounds");
        System.out.println("25C = " + TemperatureConverter.celsiusToFahrenheit(25) + " F");
    }
}
