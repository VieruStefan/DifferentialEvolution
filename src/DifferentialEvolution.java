import java.util.Arrays;
import java.util.Random;

public class DifferentialEvolution {
    public int size = 80;
    public Random rd = new Random();
    public double[] x;
    /// populatie
    public double[] v;
    /// trial array
    public double[] u;
    /// populatie G+1
    public double[] nG;
    public double cr = 0.8;
    public double f = 0.7;
    public int max_generations;
    public int xl = -20;
    public int xu = 20;
    double order;
    double[] coef;
    public double fun(double param){
        double res=0;
        for (int i = 0; i < coef.length; i++) {
            res = res + coef[i]* Math.pow(param, coef.length - i - 1);
        }
        return res;
    }
    public void init(int order, double ...coef) throws Exception {
        this.order = order;
        this.coef = coef;
        if(order != coef.length)
            throw new Exception("Numar insuficient de coeficienti");
        x = new double[size];
        for (int i = 0; i < size; i++) {
            x[i] = xl + rd.nextInt(xu - xl) + rd.nextDouble();
        }
        this.max_generations = order * 10;
    }

    public void mutate() {
        v = new double[size];
        int i, r1, r2, r3;
        for(i = 0; i< size; i++){
            r1 = r2 = r3 = i;
            while(r1 == i)
                r1 = rd.nextInt(size);
            while(r2 == i || r2 == r1)
                r2 = rd.nextInt(size);
            while(r3 == i || r3 == r1 || r2 == r3)
                r3 = rd.nextInt(size);
            v[i] = x[r1] + f*(x[r2] - x[r3]);
        }
    }

    public void cross_bin(){
        u = new double[size];
        int k = rd.nextInt(size);
        for (int i = 0; i < size; i++) {
            u[i] = rd.nextDouble() < cr || k == i?v[i]:x[i];
        }
    }

    public void selection() {
        for (int i = 0; i < size; i++) {
            double fu = fun(u[i]);
            double fx = fun(x[i]);
            x[i] = Math.abs(fu) < Math.abs(fx)? u[i]:x[i];
            x[i] = Math.round(x[i]);
        }
    }

    public void solve() {
//        double[] res = new double[2];
//        res[1] = x[0];
//        res[0] = fun(x[0]);
//        for (int i = 1; i < size; i++) {
//            double val = fun(x[i]);
//            if(res[0] > val){
//                res[0] = val;
//                res[1] = x[i];
//            }
//        }
//        return res;
        for (int i = 0; i < size; i++) {
            x[i] = Double.parseDouble(String.format("%.2f", x[i]));
        }
        System.out.print("Solutii: ");
        Arrays.stream(x).distinct().forEach(x -> System.out.printf("\n%.2f", x));
    }
}
