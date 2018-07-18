package FindOutlier;

/*
You are given an array (which will have a length of at least 3, but could be very large) containing integers.
The array is either entirely comprised of odd integers or entirely comprised of even integers except for a
single integer N. Write a method that takes the array as an argument and returns this "outlier" N.

Examples
[2, 4, 0, 100, 4, 11, 2602, 36]
Should return: 11 (the only odd number)

[160, 3, 1719, 19, 11, 13, -21]
Should return: 160 (the only even number)
 */

public class FindOutlier
{
    public static void main(String[] args)
    {
        //System.out.println(find(new int[] {2, 4, 0, 100, 4, 11, 2602, 36}));
        //System.out.println(find(new int[] {160, 3, 1719, 19, 11, 13, -21}));
        System.out.println(find(new int[] {17,6,8,10,6,12,24,36}));
    }

    public static int find(int[] integers)
    {
        int oe= 0;
        for (int i = 0; i < 3; i++)
        {
            if(integers[i] % 2 == 0) oe++;
            else oe--;
        }

        boolean ifEven = oe >= 1;

        for (int i = 0; i < integers.length; i++)
        {
            if (integers[i] % 2 != 0 && ifEven) return integers[i];
            if (integers[i] % 2 == 0 && !ifEven) return integers[i];
        }

        return 0;
    }
}
