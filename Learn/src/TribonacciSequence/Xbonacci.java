package TribonacciSequence;

public class Xbonacci
{
    public static double[] tribonacci(double[] s, int n)
    {
        // hackonacci me
        double[] res = new double[n];

        if (s.length >= n)
        {
            for (int i = 0; i < n; i++)
            {
                res[i] = s[i];
            }
            return res;
        }

        for (int i = 0; i < 3; i++)
        {
            res[i] = s[i];
        }

        int index = 3;
        while (index < n)
        {
            res[index] = res[index-1] + res[index-2] + res[index-3];
            index++;
        }

        return res;
    }
}
