package JosephusSurvivor;

/*
In this kata you have to correctly return who is the "survivor", ie: the last element of a Josephus permutation.

Basically you have to assume that n people are put into a circle and that they are eliminated in steps of k elements,
like this:

josephus_survivor(7,3) => means 7 people in a circle;
(7,6) -> 3
(7,5) -> 6
(7,4) -> 3
(7,3) -> 4
(7,2) -> 7
(7,1) -> 7
one every 3 is eliminated until one remains
[1,2,3,4,5,6,7] - initial sequence
[1,2,4,5,6,7] => 3 is counted out
[1,2,4,5,7] => 6 is counted out
[1,4,5,7] => 2 is counted out
[1,4,5] => 7 is counted out
[1,4] => 5 is counted out
[4] => 1 counted out, 4 is the last element - the survivor!
The above link about the "base" kata description will give you a more thorough insight about the origin of this kind of
permutation, but basically that's all that there is to know to solve this kata.

Notes and tips: using the solution to the other kata to check your function may be helpful, but as much larger numbers
will be used, using an array/list to compute the number of the survivor may be too slow; you may assume that both n and
k will always be >=1.
 */

public class JosephusSurvivor
{
    public static void main(String[] args)
    {
        System.out.println(josephusSurvivor(7,6));
    }

    public static int josephusSurvivor(final int n, final int k)
    {
        // F(2^n + k) = 2k + 1
        // F(2^7 + 3) = 2*3 + 1
        int res = n;
        while (res >= n)
            res = (josephusSurvivor(--res,k) + k - 1) % res + 1;
        return res;
    }
}
