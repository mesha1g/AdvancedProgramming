package JavaOrgExample.Seven.Concurency;

import java.util.stream.IntStream;

public class ComputationalIntensive {
    public static final int MAX = 2500;

    public static void main(String[] args) {
        long currentTime = System.currentTimeMillis();
       /* double sum = 0;
        for(int i = 0; i<MAX; i++){
            sum = sum + compute(MAX);
        }
        System.out.println(sum);*/
        double sum = IntStream.range(0, MAX)
                .sequential()
                .parallel()
                // .parallel()
                .mapToDouble(ComputationalIntensive::compute)
                .reduce(0, (total, number)->total+number);
        System.out.println(sum);
        long period = System.currentTimeMillis()-currentTime;
        System.out.println("Trebalo je : " +period/1000+"  sekundi");
    }

    // double sum = 0
    // double novi_sum = sum +  novi_broj

    private  static double compute(double value){
        double result = 0;
        for(int i = 0; i<MAX; i++){
            for(int j = 0; j<MAX; j++){
                result = result + Math.sqrt(i*j*value);
            }
        }
        return result;
    }
}
