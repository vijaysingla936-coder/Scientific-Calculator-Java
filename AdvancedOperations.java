public class AdvancedOperations {
    public static double factorial(int n) {
        if(n<0) return -1;
        double res=1;
        for(int i=2;i<=n;i++) res*=i;
        return res;
    }
    public static double power(double a, double b){ return Math.pow(a,b); }
    public static double log10(double a){ return Math.log10(a); }
    public static double ln(double a){ return Math.log(a); }
    public static double sqrt(double a){ return Math.sqrt(a); }
    public static double sin(double a){ return Math.sin(Math.toRadians(a)); }
    public static double cos(double a){ return Math.cos(Math.toRadians(a)); }
    public static double tan(double a){ return Math.tan(Math.toRadians(a)); }
}
