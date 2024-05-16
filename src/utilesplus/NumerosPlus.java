package utilesplus;

import java.util.Random;

public class NumerosPlus {
    public static Integer[] generarNumsAleatorios(int longitud, int tope) {
        Integer[] nums = new Integer[longitud];

        Random rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(tope);
        }

        return nums;
    }

    public static Integer generarNumAleatorioEntre(int minIncl, int maxExcl) {
        Random rand = new Random();
        return rand.nextInt(maxExcl - minIncl) + minIncl;
    }
}
