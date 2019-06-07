package SumOfSeries;

import java.util.Locale;

public class NthSeries {
    public static String seriesSum(int n) {
        // Happy Coding ^_^
        int znamenatel = 1;
        float res = 0f;
        for (int i = 0; i < n; i++) {
            // знаменатель = 1 + n*i;
            res = res + (1 / (1 + 3f * i));
        }
        return String.format(Locale.ENGLISH, "%.2f", res);
        // return Float.toString(res).;
    }
}
