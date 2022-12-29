
public class Main {
    public static void main(String[] args) {
        DifferentialEvolution DE = new DifferentialEvolution();
        try{
            DE.init(6, 1, -8, -45, 360, 324, -2592);
            for (int i = 0; i < DE.max_generations-1; i++) {
//                System.out.println();
//                for (int j = 0; j < DE.size; j++) {
//                    System.out.printf("%.1f ", DE.x[j]);
//                }
                DE.nG = new double[DE.size];
                DE.mutate();
                DE.cross_bin();
                DE.selection();
            }
//            for (int i = 0; i < DE.size; i++) {
//                System.out.printf("%.1f ", DE.x[i]);
//            }
            DE.solve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}